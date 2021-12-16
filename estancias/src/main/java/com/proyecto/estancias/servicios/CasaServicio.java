
package com.proyecto.estancias.servicios;

import com.proyecto.estancias.entidades.Casa;
import com.proyecto.estancias.repositorios.CasaRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CasaServicio {
    
    @Autowired
    private CasaServicio casaServicio;
    
    @Autowired
    private CasaRepositorio casaRepositorio;
    /**
     * String id
     * private String calle;
    private int numero;
    private String codPostal;
    private String ciudad;
    private String pais;
    private Date fechaDesde;
    private Date fechaHasta;
    private int minDias;
    private int maxDias;
    private double precio;
    private String tipoVivienda;
     */
    @Transactional
   public void agregarCasa(String calle,int numero,String codPostal,String ciudad,String pais,Date fechaDesde,Date fechaHasta, int minDias,int maxDias,double precio, String tipoVivienda){
       
       validarCasa(calle,numero,codPostal,ciudad,pais,fechaDesde,fechaHasta,minDias,maxDias,precio, tipoVivienda);
       
       Casa casa=new Casa();
       
       casa.setCalle(calle);
       casa.setNumero(numero);
       casa.setCodPostal(codPostal);
       casa.setCiudad(ciudad);
       casa.setPais(pais);
       casa.setFechaDesde(fechaDesde);
       casa.setFechaHasta(fechaHasta);
       casa.setMinDias(minDias);
       casa.setMaxDias(maxDias);
       casa.setPrecio(precio);
       casa.setTipoVivienda(tipoVivienda);
       
       casaRepositorio.save(casa);
   }
   
      @Transactional
   public void modificarCasa(String calle,int numero,String codPostal,String ciudad,String pais,Date fechaDesde,Date fechaHasta, int minDias,int maxDias,double precio, String tipoVivienda){
       
       validarCasa(calle,numero,codPostal,ciudad,pais,fechaDesde,fechaHasta,minDias,maxDias,precio, tipoVivienda);
       
       Casa casa=new Casa();
       
       casa.setCalle(calle);
       casa.setNumero(numero);
       casa.setCodPostal(codPostal);
       casa.setCiudad(ciudad);
       casa.setPais(pais);
       casa.setFechaDesde(fechaDesde);
       casa.setFechaHasta(fechaHasta);
       casa.setMinDias(minDias);
       casa.setMaxDias(maxDias);
       casa.setPrecio(precio);
       casa.setTipoVivienda(tipoVivienda);
       
       casaRepositorio.save(casa);
   }
   
  @Transactional
  public void bajaCasa(String id){
      Optional<Casa>respuesta=casaRepositorio.findById(id);
      if(respuesta.isPresent()){
          Casa casa=respuesta.get();
       //falta defindir por fecha que se va a dar de baja
          casaRepositorio.save(casa);
      }
  }
    @Transactional
  public void altaCasa(String id){
      Optional<Casa>respuesta=casaRepositorio.findById(id);
      if(respuesta.isPresent()){
          Casa casa=respuesta.get();
       //falta defindir por fecha que se va a dar de baja
          casaRepositorio.save(casa);
      }
  }
  
  @Transactional
  public void eliminarCasa(String id){
      Optional<Casa>respuesta=casaRepositorio.findById(id);
      if(respuesta.isPresent()){
          Casa casa=respuesta.get();
          casaRepositorio.deleteById(id);
      }
  }
  
  @Transactional(readOnly = true)
  public List<Casa>listarCasas(){
        return casaRepositorio.findAll();
     
  }
   public void validarCasa(String calle,int numero,String codPostal,String ciudad,String pais,Date fechaDesde,Date fechaHasta, int minDias,int maxDias,double precio, String tipoVivienda) throws Exception{
      
       if (calle.isEmpty() || calle == null || calle.contains("     ")) {
            throw new Exception("La calle ingresada no es valida");
        }
       if(numero < 0){ //null no me deja validar ya que el valor es int en lugar de integer
            throw new Exception("El numero ingresado no es valido");
        }
       if (codPostal.isEmpty() || codPostal == null || codPostal.contains("     ")) {
            throw new Exception("El codPostal ingresado no es valida");
        }
       if (ciudad.isEmpty() || ciudad == null || ciudad.contains("     ")) {
            throw new Exception("La ciudad ingresada no es valida");
        }
       if (pais.isEmpty() || pais == null || pais.contains("     ")) {
            throw new Exception("El pais ingresada no es valida");
        }
       //falta terminar de validar
   }
}
