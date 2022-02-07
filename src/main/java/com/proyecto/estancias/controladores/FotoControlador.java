/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.controladores;


import com.proyecto.estancias.entidades.Foto;
import com.proyecto.estancias.servicios.FotoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Erika92
 */
@Controller
@RequestMapping("/foto")
public class FotoControlador {
    @Autowired
    private FotoServicio fotoServicio;
    
  /**
@GetMapping("/lista")
    public String lista(ModelMap modelo){
        List<Foto> fotos = fotoServicio.listarFotos();
        modelo.addAttribute("fotos", fotos);
        return "lista-fotos.html";
    }
   */  
    
@GetMapping("/registro")
    public String formulario(){
        return "form-foto.html";
    }


@PostMapping("/registro")
    public String guardar(ModelMap modelo, @RequestParam MultipartFile archivo) {
        try{
            fotoServicio.guardarFoto(archivo);
            modelo.put("exito","Registro exitoso");
            return "form-foto.html";
        }catch(Exception e){
            modelo.put("error",e.getMessage());
            return "form-foto.html";
        }
    }


@GetMapping("/modificar/{id}")
    public String modificar(ModelMap modelo,@PathVariable String id ){
        Foto foto = fotoServicio.listarFoto(id);
        modelo.addAttribute("foto", foto);
        return "modificar-foto.html";
    } 
    @PostMapping("/confirmarModificacion/{id}")
    public String confirmarModificacion(ModelMap modelo,@PathVariable String id, @RequestParam MultipartFile archivo){
        try{
            fotoServicio.actualizarFoto(id, archivo);
            modelo.put("exito","Modificacion exitosa");
            return "redirect:/foto/lista";
        }catch(Exception e){
            modelo.put("error",e.getMessage());
            return "form-foto.html";
        }
}    
    
}
