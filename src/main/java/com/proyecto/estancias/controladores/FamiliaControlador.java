/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.controladores;

import com.proyecto.estancias.entidades.Familia;
import com.proyecto.estancias.servicios.FamiliaServicio;
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
@RequestMapping("/familia")
public class FamiliaControlador {
    
        @Autowired
    private FamiliaServicio familiaServicio;

    @GetMapping("/nuevaFamilia")
    public String formulario() {
        return "nuevaFamilia.html";
    }

    
    @PostMapping("/nuevaFamilia")
    public String guardar(ModelMap modelo, @RequestParam String nombre,@RequestParam Integer edadMin,@RequestParam Integer edadMax,@RequestParam Integer numHijos, @RequestParam String email) {
        try {
            familiaServicio.crearFamilia(nombre, edadMin, edadMax, numHijos, email);
            modelo.put("exito", "Carga exitosa");
            return "nuevaFamilia.html";
        } catch (Exception e) {
            modelo.put("error", "Faltó algún dato");
            return "nuevaFamilia.html";
        }
    }
    
    

    
    
    
    @GetMapping("/modificar/{id}") 
    public String modificar(@PathVariable String id, ModelMap modelo) {

       modelo.put("familia", familiaServicio.getOne(id));//no me dejo getOne
       //Familia familia= familiaServicio.listarFamiliasId(id)
      // modelo.addAllAttributes("familia",familia);
        return "modificar_familia.html";
    }

      @PostMapping("/confirmarModificacion/{id}")
    public String confirmarModificacion(ModelMap modelo, @RequestParam String id, @RequestParam String nombre,@RequestParam Integer edadMin,@RequestParam Integer edadMax,@RequestParam Integer numHijos, @RequestParam String email) {
        try {
            familiaServicio.modificarFamilia(id,nombre, edadMin, edadMax, numHijos, email);
            modelo.put("exito", "Modificación exitosa");
            return "redirect:familia_modificada.html";
        } catch (Exception e) {
            modelo.put("error", "Falto algun dato");
            return "familia_modificada.html";
        }
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        try {
            familiaServicio.eliminarFamilia(id);
            return "redirect:/familia.html";
        } catch (Exception e) {
            return ".html";
        }
    }

  
    @GetMapping("/listar")
    public String lista(ModelMap modelo) { 
        List<Familia> familia = familiaServicio.listarFamilias();
                modelo.addAttribute("familia", familia);
        return "familia.html";
    }
    @GetMapping("/listarReserva")
    public String listaParaPrestamo(ModelMap modelo) {
        List<Familia> familia = familiaServicio.listarFamilias();
        modelo.addAttribute("familia", familia);
        return "listaFamilia.html";
    }
    
}
    

