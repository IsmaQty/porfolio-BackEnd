package demo.backend.Controller;

import demo.backend.Model.Historial;
import demo.backend.Service.Interface.IHistorialService;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ismael
 */
@RestController
public class HistorialController {
    @Autowired IHistorialService historialService;
    
    @GetMapping ("/historial/traer")
    public List<Historial> getHistoriales(){
        return historialService.getHistoriales();
    }

    @GetMapping ("/historial/traer/{id_historial}")
    public Historial findHistorial(@PathVariable Integer id_historial){
        return historialService.findHistorial(id_historial);
    }
    
    @PostMapping ("/historial/crear")
    public String createHistorial(@RequestBody Historial historial){
        historialService.createHistorial(historial);
        return efectuoCreacion(historial.getId_historial());
    }
    
    @DeleteMapping ("/historial/eliminar/{id_historial}")
    public String deleteHistorail(@PathVariable Integer id_historial){
        historialService.deleteHistorial(id_historial);
        return efectuoEliminacion(id_historial);
    }
    
    @PutMapping ("/historial/editar/{id_historial}")
    public Historial editHistorial(@PathVariable Integer id_historial,
            @RequestParam ("nombre") String nuevo_nombre,
            @RequestParam ("experiencia_educacion") boolean nuevo_exp_edu,
            @RequestParam ("titulo") String nuevo_titulo,
            @RequestParam ("ubicacion") String nuevo_ubicacion,
            @RequestParam ("fecha_ini") LocalDate nuevo_fecha_ini,
            @RequestParam ("fecha_fin") LocalDate nuevo_fecha_fin){
        Historial historial = historialService.findHistorial(id_historial);
        
        historial.setNombre(nuevo_nombre);
        historial.setExperiencia_educacion(nuevo_exp_edu);
        historial.setTitulo(nuevo_titulo);
        historial.setUbicacion(nuevo_ubicacion);
        historial.setFecha_inicio(nuevo_fecha_ini);
        historial.setFecha_fin(nuevo_fecha_fin);
        historial.setDuracion_meses(Period.between(nuevo_fecha_ini, nuevo_fecha_fin).getMonths());
        
        historialService.createHistorial(historial);
        return historial;
    }
    
    private String efectuoCreacion(Integer id_historial) {
        String mensaje = "La operacion de creacion resulto: ";
        if(historialService.findHistorial(id_historial)!=null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
    
    private String efectuoEliminacion(Integer id_historial) {
        String mensaje = "La operacion de eliminacion resulto: ";
        if(historialService.findHistorial(id_historial)==null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
}

