package demo.backend.Controller;

import demo.backend.Model.Skill;
import demo.backend.Service.Interface.ISkillService;
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
public class SkillController {
    @Autowired ISkillService skillServi;
    
    @GetMapping ("/skill/traer")
    public List<Skill> getSkills(){
        return skillServi.getSkills();
    }
    
    @GetMapping ("/skill/traer/{id_skill}")
    public Skill getSkill(@PathVariable Integer id_skill){
        return skillServi.findSkill(id_skill);
    }
    
    @PostMapping ("/skill/crear")
    public String createSkill(@RequestBody Skill skill){
        skillServi.createSkills(skill);
        return efectuoCreacion(skill.getId_skill());
    }
    
    @DeleteMapping ("/skill/eliminar/{id_skill}")
    public String deleteSkill(@PathVariable Integer id_skill){
        skillServi.deleteSkills(id_skill);
        return efectuoEliminacion(id_skill);
    }
    
    @PutMapping ("/skill/editar/{id_skill}")
    public Skill editSkill(@PathVariable Integer id_skill,
            @RequestParam ("nombre") String nuevo_nombre,
            @RequestParam ("cantidad") Integer nuevo_cantidad,
            @RequestParam ("hard_soft") Boolean nuevo_hs){
        Skill skill = skillServi.findSkill(id_skill);
        
        skill.setNombre(nuevo_nombre);
        skill.setCantidad(nuevo_cantidad);
        skill.setHard_soft(nuevo_hs);
        
        skillServi.createSkills(skill);
        return skill;
    }

    private String efectuoCreacion(Integer id_skill) {
        String mensaje = "La operacion de creacion resulto: ";
        if(skillServi.findSkill(id_skill)!=null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
    
    private String efectuoEliminacion(Integer id_skill) {
        String mensaje = "La operacion de eliminacion resulto: ";
        if(skillServi.findSkill(id_skill)==null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
}
