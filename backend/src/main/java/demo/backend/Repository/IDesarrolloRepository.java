package demo.backend.Repository;

import demo.backend.Model.Desarrollo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ismael
 */
@Repository
public interface IDesarrolloRepository extends JpaRepository<Desarrollo, Integer>{
    
}
