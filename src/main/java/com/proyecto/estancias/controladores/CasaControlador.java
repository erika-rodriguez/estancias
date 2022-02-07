
package com.proyecto.estancias.controladores;

import com.proyecto.estancias.entidades.Casa;
import com.proyecto.estancias.servicios.CasaServicio;
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

@Controller
@RequestMapping("/casa")
public class CasaControlador {
    @Autowired
    private CasaServicio casaService;

    @GetMapping("/nuevaCasa")
    public String formulario() {
        return ".....html";
    }

    
    @PostMapping("/nuevaCasa")
    public String guardar(ModelMap modelo, @RequestParam String calle, @RequestParam int numero, @RequestParam String codPostal, @RequestParam String ciudad, @RequestParam String pais, @RequestParam Date fechaDesde, @RequestParam Date fechaHasta, @RequestParam int minDias, @RequestParam int maxDias, @RequestParam double precio, @RequestParam String tipoVivienda) {
        try {
            casaService.agregarCasa(calle, numero, codPostal, ciudad, pais, fechaDesde, fechaHasta, minDias, maxDias, precio, tipoVivienda);
            modelo.put("exito", "Carga exitosa");
            return "......html";
        } catch (Exception e) {
            modelo.put("error", "Faltó algún dato");
            return ".......html";
        }
    }
    
    
    @PostMapping("/confirmarModificacion/{id}")
    public String confirmarModificacion(ModelMap modelo, @PathVariable String calle, @PathVariable int numero, @PathVariable String codPostal, @PathVariable String ciudad, @PathVariable String pais, @PathVariable Date fechaDesde, @PathVariable Date fechaHasta, @PathVariable int minDias, @PathVariable int maxDias, @PathVariable double precio, @PathVariable String tipoVivienda) {
        try {
            casaService.modificar(calle, numero, codPostal, ciudad, pais, fechaDesde, fechaHasta, minDias, maxDias, precio, tipoVivienda);
            modelo.put("exito", "Modificación exitosa");
            return "redirect:/..../.......";
        } catch (Exception e) {
            modelo.put("error", "Falto algun dato");
            return ".........";
        }
    }
    
    
    
    @GetMapping("/modificar/{id}") //PATHVARIABLE
    public String modificar(@PathVariable String id, ModelMap modelo) {

        modelo.put("casa", casaService.getOne(id));

        return ".........html";
    }

  
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable String id) {
        try {
            casaService.eliminar(id);
            return "redirect:/..../....";
        } catch (Exception e) {
            return ".....";
        }
    }

  
    @GetMapping("/listar")
    public String lista(ModelMap modelo) {
        List<Casa> casas = casaService.listarCasas();
        modelo.addAttribute("casas", casas);
        return ".....html";
    }
    @GetMapping("/listarParaReserva")
    public String listaParaPrestamo(ModelMap modelo) {
        List<Casa> casas = casaService.listarCasas();
        modelo.addAttribute("casas", casas);
        return "form-libros-prestamo.html";
    }
    
}
