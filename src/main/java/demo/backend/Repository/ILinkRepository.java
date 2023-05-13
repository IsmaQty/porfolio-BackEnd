package demo.backend.Repository;

import demo.backend.Model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ismael
 */
@Repository
public interface ILinkRepository extends JpaRepository<Link,Integer>{
    
}
