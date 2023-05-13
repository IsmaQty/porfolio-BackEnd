package demo.backend.Controller;

import demo.backend.Model.Proyecto;
import demo.backend.Service.Interface.IProyectoService;
import java.util.Date;
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
public class ProyectoController {
    @Autowired IProyectoService proyectoServi;
    
    @GetMapping ("/proyecto/traer")
    public List<Proyecto> getProyectos(){
        return proyectoServi.getProyectos();
    }
    
    @GetMapping ("/proyecto/traer/{id_proyecto}")
    public Proyecto getProyecto(@PathVariable Integer id_proyecto){
            return proyectoServi.findProyecto(id_proyecto);
    }
    
    @PostMapping ("/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto proyecto){
        proyectoServi.createProyecto(proyecto);
        return efectuoCreacion(proyecto.getId_proyecto());
    }
    
    @DeleteMapping ("/proyecto/eliminar/{id_proyecto}")
    public String deleteProyecto(@PathVariable Integer id_proyecto){
        proyectoServi.deleteProyecto(id_proyecto);
        return efectuoEliminacion(id_proyecto);
    }

    @PutMapping ("/proyecto/editar/{id_proyecto}")
    public Proyecto editProyecto(@PathVariable Integer id_proyecto,
            @RequestParam ("nombre") String nuevo_nombre,
            @RequestParam ("descripcion") String nuevo_descripcion,
            @RequestParam ("fecha") Date nuevo_fecha,
            @RequestParam ("link") String nuevo_link,
            @RequestParam ("github") String nuevo_github){
        Proyecto proyecto = proyectoServi.findProyecto(id_proyecto);
        
        proyecto.setNombre(nuevo_nombre);
        proyecto.setDescripcion(nuevo_descripcion);
        proyecto.setFecha(nuevo_fecha);
        proyecto.setLink(nuevo_link);
        proyecto.setGithub(nuevo_github);
        
        proyectoServi.createProyecto(proyecto);
        return proyecto;
    }

    private String efectuoCreacion(Integer id_proyecto) {
        String mensaje = "La operacion de creacion resulto: ";
        if(proyectoServi.findProyecto(id_proyecto)!=null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
    
    private String efectuoEliminacion(Integer id_proyecto) {
        String mensaje = "La operacion de eliminacion resulto: ";
        if(proyectoServi.findProyecto(id_proyecto)==null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
}
