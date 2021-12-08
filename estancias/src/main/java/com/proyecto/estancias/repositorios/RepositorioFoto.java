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
    
    
    @Query("SELECT c FROM foto c")
    public List<Foto> ListarFotos();
    
    
    @Query("SELECT c FROM foto c WHERE c.id = :id")
    public Foto buscarPorId(@Param("id")String id);
}
