
package com.proyecto.estancias.repositorios;

import com.proyecto.estancias.entidades.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepositorio extends JpaRepository<Casa, String>{
    
   
}
