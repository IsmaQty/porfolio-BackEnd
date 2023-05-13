package demo.backend.Repository;

import demo.backend.Model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ismael
 */
@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer>{
    
}
