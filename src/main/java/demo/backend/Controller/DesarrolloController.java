package demo.backend.Controller;

import demo.backend.Model.Desarrollo;
import demo.backend.Service.Interface.IDesarrolloService;
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
public class DesarrolloController {
    @Autowired IDesarrolloService desarrolloService;
    
    @GetMapping ("/desarrollo/traer")
    public List<Desarrollo> getDesarrollos(){
        return desarrolloService.getDesarrollos();
    }
    
    @GetMapping ("/desarrollo/traer/{dni}")
    public Desarrollo findDesarrollo(@PathVariable Integer dni){
        return desarrolloService.findDesarrollo(dni);
    }
    
    @PostMapping ("/desarrollo/crear")
    public String createDesarrollo(@RequestBody Desarrollo desar){
        desarrolloService.createDesarrollo(desar);
        return efectuoCreacion(desar.getDni());
    }
    
    @DeleteMapping ("/desarrollo/eliminar/{dni}")
    public String deleteDesarrollo(@PathVariable Integer dni){
        desarrolloService.deleteDesarrollo(dni);
        return efectuoEliminacion(dni);
    }
    
    @PutMapping ("/desarrollo/editar/{dni}")
    public Desarrollo editDesarrollo(@PathVariable Integer dni,
            @RequestParam ("nombre") String nuevo_titulo,
            @RequestParam ("acerca_de") String nuevo_acerca_de,
            @RequestParam ("ubicacion") String nueva_ubicacion){
        Desarrollo desa = desarrolloService.findDesarrollo(dni);
        
        desa.setTitulo(nuevo_titulo);
        desa.setAcercaDe(nuevo_acerca_de);
        desa.setUbicacion(nueva_ubicacion);
        
        desarrolloService.createDesarrollo(desa);
        return desa;
    }
    
    private String efectuoCreacion(Integer dni) {
        String mensaje = "La operacion de creacion resulto: ";
        if(desarrolloService.findDesarrollo(dni)!=null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
    
    private String efectuoEliminacion(Integer dni) {
        String mensaje = "La operacion de eliminacion resulto: ";
        if(desarrolloService.findDesarrollo(dni)==null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
}
