
package com.proyecto.estancias.repositorios;

import com.proyecto.estancias.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, String>{
    @Query("SELECT c FROM Casa c WHERE c.id = :id")
    public Comentario buscarPorCiudad(@Param("id") String id);
    
}
