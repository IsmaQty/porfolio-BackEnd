package demo.backend.Repository;

import demo.backend.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ismael
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
    
}
