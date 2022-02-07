
package com.proyecto.estancias.controladores;

import com.proyecto.estancias.entidades.Comentario;
import com.proyecto.estancias.servicios.ComentarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comentario")
public class ComentarioControlador {
    @Autowired
    private ComentarioServicio comentarioService;

    @GetMapping("/nuevoComentario")
    public String formulario() {
        return ".....html";
    }

    
    @PostMapping("/nuevoComentario")
    public String guardar(ModelMap modelo, @RequestParam String descripcion) {
        try {
            comentarioService.agregarComentario(descripcion);
            modelo.put("exito", "Carga exitosa");
            return "......html";
        } catch (Exception e) {
            modelo.put("error", "Faltó algún dato");
            return ".......html";
        }
    }
    
    
    @PostMapping("/confirmarModificacion/{id}")
    public String confirmarModificacion(ModelMap modelo, @PathVariable String descripcion) {
        try {
            comentarioService.modificar(descripcion);
            modelo.put("exito", "Modificación exitosa");
            return "redirect:/..../.......";
        } catch (Exception e) {
            modelo.put("error", "Falto algun dato");
            return ".........";
        }
    }
        
    
    @GetMapping("/modificar/{id}") //PATHVARIABLE
    public String modificar(@PathVariable String id, ModelMap modelo) {

        modelo.put("comentario", comentarioService.getOne(id));

        return ".........html";
    }
  
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        try {
            comentarioService.eliminar(id);
            return "redirect:/..../....";
        } catch (Exception e) {
            return ".....";
        }
    }
  
    @GetMapping("/listar")
    public String lista(ModelMap modelo) {
        List<Comentario> comentarios = comentarioService.listarComentarios();
        modelo.addAttribute("comentarios", comentarios);
        return ".....html";
    }
    @GetMapping("/listarParaReserva")
    public String listaParaPrestamo(ModelMap modelo) {
        List<Comentario> comentarios = comentarioService.listarComentarios();
        modelo.addAttribute("comentarios", comentarios);
        return ".......html";
    }
    
}
