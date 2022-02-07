/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.controladores;

import com.proyecto.estancias.entidades.Estancia;
import com.proyecto.estancias.servicios.EstanciaServicio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Erika92
 */
@Controller
@RequestMapping("/estancia")
public class EstanciaControlador {
    @Autowired
    private EstanciaServicio estanciaServicio;
    
    
    @GetMapping("/lista")
    public String lista(ModelMap modelo){
        List<Estancia> estancias = estanciaServicio.listarEstancias();
        modelo.addAttribute("estancias", estancias);
        return "lista-estancias.html";
    }
    
    
    @GetMapping("/registro")
    public String formulario(){
        return "form-estancia.html";
    }
    
    
    @PostMapping("/registro")
    public String guardar(ModelMap modelo, @RequestParam String huesped, @RequestParam Date fechaDesde, @RequestParam Date fechaHasta) {
        try{
            estanciaServicio.crearEstancia(huesped, fechaDesde, fechaHasta);
            modelo.put("exito","Registro exitoso");
            return "form-estancia.html";
        }catch(Exception e){
            modelo.put("error",e.getMessage());
            return "form-estancia.html";
        }
    }
    
    
    @GetMapping("/modificar/{id}")
    public String modificar(ModelMap modelo,@PathVariable String id ){
        Estancia estancia = estanciaServicio.listarEstancia(id);
        modelo.addAttribute("estancia", estancia);
        return "modificar-estancia.html";
    } 
    @PostMapping("/confirmarModificacion/{id}")
    public String confirmarModificacion(ModelMap modelo,@PathVariable String id, @RequestParam String huesped, @RequestParam Date fechaDesde, @RequestParam Date fechaHasta){
        try{
            estanciaServicio.modificarEstancia(id, huesped, fechaDesde, fechaHasta);
            modelo.put("exito","Modificacion exitosa");
            return "redirect:/estancia/lista";
        }catch(Exception e){
            modelo.put("error",e.getMessage());
            return "form-estancia.html";
        }
}
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id){
        try{
            estanciaServicio.eliminarEstancia(id);
            return "redirect:/estancia/lista";
        }catch(Exception e){
            return "lista-estancias.html";
        }
    }
}
