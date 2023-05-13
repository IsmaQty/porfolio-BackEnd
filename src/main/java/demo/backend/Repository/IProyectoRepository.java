package demo.backend.Repository;

import demo.backend.Model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ismael
 */
@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer>{
    
}
