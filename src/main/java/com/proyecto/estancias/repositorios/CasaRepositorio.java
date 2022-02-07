
package com.proyecto.estancias.repositorios;

import com.proyecto.estancias.entidades.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepositorio extends JpaRepository<Casa, String>{
    @Query("SELECT c FROM Casa c WHERE c.ciudad = :ciudad")
    public Casa buscarPorCiudad(@Param("ciudad") String ciudad);
    
    @Query("SELECT c FROM Casa c WHERE c.pais = :pais")
    public Casa buscarPorPais(@Param("pais") String pais);
    
    @Query("SELECT c FROM Casa c WHERE c.precio = :precio")
    public Casa buscarPorPrecio(@Param("precio") String precio); 
    
    @Query("SELECT c FROM Casa c WHERE c.tipoVivienda = :tipoVivienda")
    public Casa buscarPorTipoVivienda(@Param("tipoVivienda") String tipoVivienda);
    
}
