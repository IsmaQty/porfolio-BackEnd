package demo.backend.Controller;

import demo.backend.Model.Persona;
import demo.backend.Service.Interface.IPersonaService;
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
public class PersonaController {
    @Autowired IPersonaService personaServi;
    
    @GetMapping ("/persona/traer")
    public List<Persona> getPersonas(){
        return personaServi.getPersonas();
    }
    
    @GetMapping ("/persona/traer/{dni}")
    public Persona getPersona(@PathVariable Integer dni){
        return personaServi.findPersona(dni);
    }
    
    @PostMapping ("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        personaServi.createPersona(persona);
        return efectuoCreacion(persona.getDni());
    }

    @DeleteMapping ("/persona/eliminar/{dni}")
    public String deletePersona(@PathVariable Integer dni){
        personaServi.deletePersona(dni);
        return efectuoEliminacion(dni);
    }

    @PutMapping ("/persona/editar/{dni}")
    public Persona editPersona(@PathVariable Integer dni,
            @RequestParam ("nombre") String nuevo_nombre,
            @RequestParam ("apellido") String nuevo_apellido){
        Persona persona = personaServi.findPersona(dni);
        
        persona.setNombre(nuevo_nombre);
        persona.setApellido(nuevo_apellido);
        
        personaServi.createPersona(persona);
        return persona;
    }

    private String efectuoCreacion(Integer dni) {
        String mensaje = "La operacion de creacion resulto: ";
        if(personaServi.findPersona(dni)!=null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
    
    private String efectuoEliminacion(Integer dni) {
        String mensaje = "La operacion de eliminacion resulto: ";
        if(personaServi.findPersona(dni)==null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
}
