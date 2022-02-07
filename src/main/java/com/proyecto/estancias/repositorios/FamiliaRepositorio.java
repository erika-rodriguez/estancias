/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.repositorios;
import com.proyecto.estancias.entidades.Familia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FamiliaRepositorio extends JpaRepository<Familia, String> {    
    /*
     @Query("SELECT c FROM familia c")
    public List<Familia> ListarFamilias();

    
    
    @Query("SELECT c FROM familia c WHERE c.id = :id")
    public Familia buscarPorId(@Param("id")String id);
*/
}
