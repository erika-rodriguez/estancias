package com.proyecto.estancias.servicios;

import com.proyecto.estancias.entidades.Cliente;
import com.proyecto.estancias.errores.ErrorServicio;
import com.proyecto.estancias.repositorios.ClienteRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio cr;

    @Transactional
    public void resgistrar(String nombre, String calle, int numero, String codPostal, String ciudad, String pais, String email) throws ErrorServicio {

        validar(nombre, calle, numero, codPostal, ciudad, pais, email);
        Cliente cliente = new Cliente();

        Optional<Cliente> respuesta = cr.findByEmail(email);
        if (respuesta.isPresent()) {
            Cliente cliente2 = respuesta.get();
            cliente.setNombre(cliente2.getNombre());
            cliente.setId(cliente2.getId());
            cliente.setCalle(cliente2.getCalle());
            cliente.setNumero(cliente2.getNumero());
            cliente.setCodPostal(cliente2.getCodPostal());
            cliente.setCiudad(cliente2.getCiudad());
            cliente.setPais(cliente2.getPais());
            cliente.setEmail(email);
            cr.save(cliente);
        } else {
            cliente.setNombre(nombre);
            cliente.setCalle(calle);
            cliente.setNumero(numero);
            cliente.setCodPostal(codPostal);
            cliente.setCiudad(ciudad);
            cliente.setPais(pais);
            cliente.setEmail(email);

            cr.save(cliente);
        }
    }

    @Transactional
    public void modificarCliente(String id, String nombre, String calle, int numero, String codPostal, String ciudad, String pais, String email) throws ErrorServicio {
        validar(nombre, calle, numero, codPostal, ciudad, pais, email);
        
        Optional<Cliente> respuesta = cr.findById(id);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            if (cliente.getId().equals(id)) {
                cliente.setNombre(nombre);
                cliente.setCalle(calle);
                cliente.setNumero(numero);
                cliente.setCodPostal(codPostal);
                cliente.setCiudad(ciudad);
                cliente.setPais(pais);
                cliente.setEmail(email);

                cr.save(cliente);

            } else {
                throw new ErrorServicio("No tiene permisos necesarios para realizar la operación.");
            }

        } else {
            throw new ErrorServicio("No existe un Cliente con el identificador indicado");
        }

    }


    @Transactional
    public Cliente getOne(String id) {
        return cr.getOne(id);
    }

    @Transactional
    public Cliente buscarPorEmail(Cliente cliente, String email) throws ErrorServicio {
        cliente = cr.buscarPorEmail(email);
        return cliente;
    }

    @Transactional
    public Cliente buscarPorNombre(Cliente cliente, String nombre) throws ErrorServicio {
        cliente = cr.buscarClienteNombre(nombre);

        return cliente;
    }

    

    @Transactional
    public void eliminar(String idCliente) throws ErrorServicio {
        Optional<Cliente> respuesta = cr.findById(idCliente);
        if (respuesta.isPresent()) {
            Cliente cliente = respuesta.get();
            if (cliente.getId().equals(idCliente)) {

                cr.delete(cliente);
            } else {
                throw new ErrorServicio("No tiene permisos necesarios para realizar la operación.");
            }

        } else {
            throw new ErrorServicio("No existe un Autor con el identificador indicado");
        }
    }

    

    @Transactional()
    public List<Cliente> listarTodos() {
        return cr.findAll();
    }
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = cr.findAll();
        return clientes;
    }
    
    private void validar(String nombre, String calle, int numero, String codPostal, String ciudad, String pais, String email) throws ErrorServicio {
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del Cliente no puede ser nulo");

        }
        if (calle == null || calle.isEmpty()) {
            throw new ErrorServicio("El e-mail del Cliente no puede ser nulo");
        }
        if (numero <= 0) {
            throw new ErrorServicio("El número de la dirección del Cliente no puede ser nulo");
        }
        if (codPostal == null || codPostal.isEmpty() || codPostal.length() < 6) {
            throw new ErrorServicio("El código postal del cliente no puede ser nulo y debe contener menos de 7 dígitos");
        }
        if (ciudad == null || ciudad.isEmpty()) {
            throw new ErrorServicio("La ciudad del cliente no puede ser nulo");
        }
        if (pais == null || pais.isEmpty()) {
            throw new ErrorServicio("El país del cliente no puede ser nulo");
        }
    }

}
