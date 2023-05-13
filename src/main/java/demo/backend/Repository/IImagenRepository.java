package demo.backend.Repository;

import demo.backend.Model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ismael
 */
@Repository
public interface IImagenRepository extends JpaRepository<Imagen,Integer>{
    
}
