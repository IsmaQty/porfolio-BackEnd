package demo.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ismael
 */
@Entity @Getter @Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proyecto;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String link;
    private String github;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen")
    private Imagen imagen;
    
    @ManyToMany(mappedBy = "proyectos")
    private List<Persona> personas = new ArrayList<>();
}
