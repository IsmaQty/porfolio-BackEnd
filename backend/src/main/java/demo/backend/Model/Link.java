package demo.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ismael
 */
@Entity @Getter @Setter
public class Link {
    @Id
    private Integer dni;
    private String instagram;
    private String linkedin;
    private String github;
    
    @OneToOne
    @MapsId
    private Persona persona;
}
