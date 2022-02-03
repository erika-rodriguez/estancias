
package com.proyecto.estancias.repositorios;

import com.proyecto.estancias.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, String>{
    
    
}
