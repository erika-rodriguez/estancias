/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.servicios;

import com.proyecto.estancias.entidades.Foto;
import com.proyecto.estancias.errores.ErrorServicio;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.proyecto.estancias.repositorios.RepositorioFoto;

/**
 *
 * @author Erika92
 */
@Service
public class FotoServicio {
    @Autowired
    private RepositorioFoto fotoRepositorio;
    
    public Foto guardarFoto(MultipartFile archivo) throws ErrorServicio{
        if (archivo !=null) {
            try {
            Foto foto=new Foto();
            foto.setMime(archivo.getContentType());
            foto.setNombre(archivo.getName());
            foto.setContenido(archivo.getBytes());
            
            return fotoRepositorio.save(foto);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }  
    
    
    public Foto actualizarFoto(String id, MultipartFile archivo) throws ErrorServicio{
        if (archivo !=null) {
            try {
            Foto foto=new Foto();
                if (id != null) {
                    Optional <Foto> respuesta = fotoRepositorio.findById(id);
                    if(respuesta.isPresent()){
                        foto=respuesta.get();
                    }
                }
            foto.setMime(archivo.getContentType());
            foto.setNombre(archivo.getName());
            foto.setContenido(archivo.getBytes());
            
            return fotoRepositorio.save(foto);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public Foto listarFoto(String id){
        Foto foto = fotoRepositorio.buscarPorId(id);
        return foto;
    }
}
