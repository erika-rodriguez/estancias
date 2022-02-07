/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.servicios;

import com.proyecto.estancias.entidades.Estancia;
import com.proyecto.estancias.errores.ErrorServicio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.estancias.repositorios.RepositorioEstancia;

/**
 *
 * @author Erika92
 */
@Service
public class EstanciaServicio {

    @Autowired
    private RepositorioEstancia estanciaRepositorio;

    @Transactional
    public void crearEstancia(String huesped, Date fechaDesde, Date fechaHasta) throws ErrorServicio {
        validar(fechaDesde, fechaHasta, huesped);
        Estancia estancia = new Estancia();
        estancia.setHuesped(huesped);
        estancia.setFechaDesde(fechaDesde);
        estancia.setFechaHasta(fechaHasta);

        estanciaRepositorio.save(estancia);
    }

    @Transactional
    public void modificarEstancia(String id, String huesped, Date fechaDesde, Date fechaHasta) throws ErrorServicio {
        validar(fechaDesde, fechaHasta, huesped);

        Optional<Estancia> respuesta = estanciaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Estancia estancia = respuesta.get();
            estancia.setHuesped(huesped);
            estancia.setFechaDesde(fechaDesde);
            estancia.setFechaHasta(fechaHasta);
            estanciaRepositorio.save(estancia);
        }

        
    }

    @Transactional
    public void eliminarEstancia(String id) throws ErrorServicio {
        Optional<Estancia> respuesta = estanciaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Estancia estancia = respuesta.get();
            estanciaRepositorio.delete(estancia);
        } else {
            throw new ErrorServicio("No se encontro la estancia solicitada");
        }
    }

    private void validar(Date fechaDesde, Date fechaHasta, String huesped) throws ErrorServicio {
        Date fechaActual = new Date(System.currentTimeMillis());
        /*
        if (fechaDesde.compareTo(fechaActual)<0) {
            throw new ErrorService("La fecha de check-in no puede ser anterior a la fecha actual");
        }
         */

        if (fechaDesde.after(fechaHasta)) {
            throw new ErrorServicio("La fecha de check-in no puede ser posterior a la fecha de check-out");
        }

        if (huesped == null || huesped.isEmpty()) {
            throw new ErrorServicio("El huesped no puede estar vacio");
        }

    }

    public List<Estancia> listarEstancias() {
        List<Estancia> estanciaS = estanciaRepositorio.findAll();
        return estanciaS;
    }

    public Optional<Estancia> listarEstancia(String id) {
        Optional<Estancia> estancia = estanciaRepositorio.findById(id);
        if(estancia.isPresent()){
              return estancia;
        }
        return null;
      
    }
}
