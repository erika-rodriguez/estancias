
package com.proyecto.estancias.servicios;

<<<<<<< Updated upstream:estancias/src/main/java/com/proyecto/estancias/servicios/ClienteServicio.java
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio {
=======
import com.proyecto.estancias.entidades.Familia;
import com.proyecto.estancias.errores.ErrorServicio;
import com.proyecto.estancias.repositorios.FamiliaRepositorio;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamiliaServicio {
    @Autowired
    private FamiliaRepositorio familiaRepositorio;
    
    @Transactional
    public void crearFamilia(String nombre, Integer edadMin, Integer edadMax,Integer numHijos,String email)throws ErrorServicio{
        
        validar(nombre,edadMin,edadMax,numHijos,email);
        
        Familia familia=new Familia();
        familia.setNombre(nombre);
        familia.setEdadMin(edadMin);
        familia.setEdadMax(edadMax);
        familia.setNumHijos(numHijos);
        familia.setEmail(email);
        
        familiaRepositorio.save(familia);
    }

    
       @Transactional
    public void modificarFamilia(String id, String nombre, Integer edadMin, Integer edadMax,Integer numHijos,String email)throws ErrorServicio{
        
        validar(nombre,edadMin,edadMax,numHijos,email);
        
        
        Optional<Familia> respuesta= familiaRepositorio.findById(id);
        if(respuesta.isPresent()){
        Familia familia= respuesta.get();
        familia.setNombre(nombre);
        familia.setEdadMin(edadMin);
        familia.setEdadMax(edadMax);
        familia.setNumHijos(numHijos);
        familia.setEmail(email);
        
        familiaRepositorio.save(familia);
    
        }
    }
>>>>>>> Stashed changes:src/main/java/com/proyecto/estancias/servicios/FamiliaServicio.java
    
    @Transactional
    public void eliminarFamilia(String id)throws ErrorServicio{
        Optional<Familia>respuesta= familiaRepositorio.findById(id);
        if(respuesta.isPresent()){
            Familia familia= respuesta.get();
            familiaRepositorio.delete(familia);
            
        }else{
            throw  new ErrorServicio("No se encontro la familia solicitada");
        }
        
    }
    
       @Transactional(readOnly = true) //listar todo lo que esta e
    public List<Familia> listarFamilias() {
        return familiaRepositorio.findAll();

    }
        @Transactional(readOnly = true) //listar todo lo que esta e
    public Optional<Familia> listarFamiliasId(String id) {
        return familiaRepositorio.findById(id);

    }
    
    private void validar(String nombre, Integer edadMin, Integer edadMax, Integer numHijos, String email) throws  ErrorServicio{
        
   if(nombre.isEmpty()|| nombre == null || nombre.contains("     ")) {
            throw new ErrorServicio("El nombre ingresado no es valido"); 
          }   
    
     if (edadMin == null || edadMin < 0) {
         throw  new ErrorServicio("La edad minima ingresada no es valida");
     }
     
     if (edadMax == null || edadMax < 0) {
         throw  new ErrorServicio("La edad maxima ingresada no es valida");
     }
     
     if (numHijos == null ||numHijos < 0) {
         throw  new ErrorServicio("La edad minima ingresada no es valida");
    }
     
     if(email.isEmpty()|| email == null || email.contains("     ")) {
            throw new ErrorServicio("El nombre ingresado no es valido"); 
       
   }      
}
    
    @Transactional(readOnly = true)
    public Familia getOne(String id) {
        return familiaRepositorio.getOne(id);
    }
}