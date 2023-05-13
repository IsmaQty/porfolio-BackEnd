package demo.backend.Service.Interface;

import demo.backend.Model.Skill;
import java.util.List;

/**
 *
 * @author Ismael
 */
public interface ISkillService {
    public List<Skill> getSkills();
    public void createSkills(Skill skill);
    public void deleteSkills(Integer id_skill);
    public Skill findSkill(Integer id_skill);
}
