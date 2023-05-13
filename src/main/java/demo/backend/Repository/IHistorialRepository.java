package demo.backend.Repository;

import demo.backend.Model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ismael
 */
@Repository
public interface IHistorialRepository extends JpaRepository<Historial, Integer>{
    
}
