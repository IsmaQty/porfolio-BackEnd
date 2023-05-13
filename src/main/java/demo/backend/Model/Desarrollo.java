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
public class Desarrollo {
    @Id
    private Integer dni;
    private String titulo;
    private String acercaDe;
    private String ubicacion;
    
    @OneToOne
    @MapsId
    private Persona persona;
}
