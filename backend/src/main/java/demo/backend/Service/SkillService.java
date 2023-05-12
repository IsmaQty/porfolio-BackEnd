package demo.backend.Service;

import demo.backend.Model.Skill;
import demo.backend.Repository.ISkillRepository;
import demo.backend.Service.Interface.ISkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ismael
 */
@Service
public class SkillService implements ISkillService{
    @Autowired ISkillRepository skillRepos;

    @Override
    public List<Skill> getSkills() {
        return skillRepos.findAll();
    }

    @Override
    public void createSkills(Skill skill) {
        skillRepos.save(skill);
    }

    @Override
    public void deleteSkills(Integer id_skill) {
        skillRepos.deleteById(id_skill);
    }

    @Override
    public Skill findSkill(Integer id_skill) {
        return skillRepos.findById(id_skill).orElse(null);
    }
}
