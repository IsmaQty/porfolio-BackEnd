package demo.backend.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ismael
 */
@Entity @Getter @Setter
public class Persona {
    @Id
    private Integer dni;
    private String nombre;
    private String apellido;
    
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Link link;
    
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Desarrollo desarrollo;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="SkillPersona",
        joinColumns = @JoinColumn(name = "dni", referencedColumnName="dni"),
        inverseJoinColumns = @JoinColumn(name = "id_skill", referencedColumnName="id_skill"))
    private List<Skill> skills = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
        name="HistorialPersona",
        joinColumns = @JoinColumn(name = "dni", referencedColumnName="dni"),
        inverseJoinColumns = @JoinColumn(name = "id_historial", referencedColumnName="id_historial"))
    private List<Historial> historiales = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
        name="ProyectoPersona",
        joinColumns = @JoinColumn(name = "dni", referencedColumnName="dni"),
        inverseJoinColumns = @JoinColumn(name = "id_proyecto", referencedColumnName="id_proyecto"))
    private List<Proyecto> proyectos = new ArrayList<>();
}
