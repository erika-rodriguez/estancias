/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.repositorios;

import com.proyecto.estancias.entidades.Estancia;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Erika92
 */
@Repository
public interface RepositorioEstancia extends JpaRepository<Estancia, String>{

  
<<<<<<< HEAD
 /*
=======
 
>>>>>>> df7ac4c3501f2425b302f07f940816f76f04462c
    @Query("SELECT c FROM foto c where c.id = :id")
    public List<Estancia> ListarEstancias();
    
    
    @Query("SELECT c FROM foto c WHERE c.id = :id")
    public Estancia buscarPorId(@Param("id")String id);

<<<<<<< HEAD
*/
=======

>>>>>>> df7ac4c3501f2425b302f07f940816f76f04462c
}
