/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.estancias.controladores;

import com.proyecto.estancias.entidades.Cliente;
import com.proyecto.estancias.servicios.ClienteServicio;
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
@RequestMapping("/cliente")
public class ClienteControlador {
    @Autowired
    private ClienteServicio clienteService;

    @GetMapping("/nuevoCliente")
    public String formulario() {
        return ".....html";
    }

    
    @PostMapping("/nuevoCliente")
    public String guardar(ModelMap modelo, @RequestParam String nombre, @RequestParam String calle, @RequestParam int numero, @RequestParam String codPostal, @RequestParam String ciudad, @RequestParam String pais, @RequestParam String email) {
        try {
            clienteService.agregarCliente(nombre, calle, numero, codPostal, ciudad, pais, email);
            modelo.put("exito", "Carga exitosa");
            return "......html";
        } catch (Exception e) {
            modelo.put("error", "Faltó algún dato");
            return ".......html";
        }
    }
    
    
    @PostMapping("/confirmarModificacion/{id}")
    public String confirmarModificacion(ModelMap modelo, @PathVariable String nombre, @PathVariable String calle, @PathVariable int numero, @PathVariable String codPostal, @PathVariable String ciudad, @PathVariable String pais, @PathVariable String email) {
        try {
            clienteService.modificar(nombre, calle, numero, codPostal, ciudad, pais, email);
            modelo.put("exito", "Modificación exitosa");
            return "redirect:/..../.......";
        } catch (Exception e) {
            modelo.put("error", "Falto algun dato");
            return ".........";
        }
    }
    
    
    
    @GetMapping("/modificar/{id}") //PATHVARIABLE
    public String modificar(@PathVariable String id, ModelMap modelo) {

        modelo.put("cliente", clienteService.getOne(id));

        return ".........html";
    }

  
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        try {
            clienteService.eliminar(id);
            return "redirect:/..../....";
        } catch (Exception e) {
            return ".....";
        }
    }

  
    @GetMapping("/listar")
    public String lista(ModelMap modelo) {
        List<Cliente> clientes = clienteService.listarClientes();
        modelo.addAttribute("clientes", clientes);
        return ".....html";
    }
    @GetMapping("/listarParaReserva")
    public String listaParaPrestamo(ModelMap modelo) {
        List<Cliente> clientes = clienteService.listarClientes();
        modelo.addAttribute("clientes", clientes);
        return ".......html";
    }
    
}
