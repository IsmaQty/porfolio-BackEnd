package demo.backend.Controller;

import demo.backend.Model.Link;
import demo.backend.Service.Interface.ILinkService;
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
public class LinkController {
    @Autowired ILinkService linkServi;
    
    @GetMapping ("/link/traer")
    public List<Link> getLinks(){
        return linkServi.getLinks();
    }
    
    @GetMapping ("/link/traer/{dni}")
    public Link findLink(@PathVariable Integer dni){
        return linkServi.findLink(dni);
    }

    @PostMapping ("/link/crear")
    public String createLink(@RequestBody Link link){
        linkServi.createLink(link);
        return efectuoCreacion(link.getDni());
    }

    @DeleteMapping ("/link/eliminar/{dni}")
    public String deleteLink(@PathVariable Integer dni){
        linkServi.deleteLink(dni);
        return efectuoEliminacion(dni);
    }
    
    @PutMapping ("/link/editar/{dni}")
    public Link editLink(@PathVariable Integer dni,
            @RequestParam ("instagram") String instagram,
            @RequestParam ("linkedin") String linkedin,
            @RequestParam ("github") String github){
        Link link = linkServi.findLink(dni);
        
        link.setInstagram(instagram);
        link.setLinkedin(linkedin);
        link.setGithub(github);
        
        linkServi.createLink(link);
        
        return link;
    }
    
    private String efectuoCreacion(Integer dni) {
        String mensaje = "La operacion de creacion resulto: ";
        if(linkServi.findLink(dni)!=null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
    
    private String efectuoEliminacion(Integer dni) {
        String mensaje = "La operacion de eliminacion resulto: ";
        if(linkServi.findLink(dni)==null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
}
