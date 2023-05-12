package demo.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ismael
 */
@Entity @Getter @Setter
public class Skill {
    public static final boolean HARDSKILL = true;
    public static final boolean SOFTSKILL = false;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_skill;
    private String nombre;
    private Integer cantidad;
    private boolean hard_soft; //hardskill sera true, softskill sera false
    
    @ManyToMany(mappedBy = "skills")
    private List<Persona> personas = new ArrayList<>();
}
