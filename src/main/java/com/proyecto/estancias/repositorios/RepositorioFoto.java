/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.repositorios;

import com.proyecto.estancias.entidades.Foto;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Erika92
 */

@Repository
public interface RepositorioFoto extends JpaRepository<Foto, String>{
<<<<<<< HEAD:estancias/src/main/java/com/proyecto/estancias/repositorios/RepositorioFoto.java
/*
=======
<<<<<<< HEAD
  /*
=======
  
>>>>>>> df7ac4c3501f2425b302f07f940816f76f04462c
>>>>>>> e047d9aec34f7a298ed337a0e11c109d999568a1:src/main/java/com/proyecto/estancias/repositorios/RepositorioFoto.java
    @Query("SELECT c FROM foto c")
    public List<Foto> ListarFotos();
    
    
    @Query("SELECT c FROM foto c WHERE c.id = :id")
    public Foto buscarPorId(@Param("id")String id);
*/
    
<<<<<<< HEAD:estancias/src/main/java/com/proyecto/estancias/repositorios/RepositorioFoto.java
   
=======
<<<<<<< HEAD
   */ 
=======
   
>>>>>>> df7ac4c3501f2425b302f07f940816f76f04462c
>>>>>>> e047d9aec34f7a298ed337a0e11c109d999568a1:src/main/java/com/proyecto/estancias/repositorios/RepositorioFoto.java
}
