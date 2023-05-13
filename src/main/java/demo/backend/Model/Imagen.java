package demo.backend.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ismael
 */
@Entity @Getter @Setter
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_imagen;
    private String link;
    
    @OneToMany(mappedBy = "imagen", cascade = CascadeType.ALL)
    private List<Proyecto> proyectos = new ArrayList<>();
    
    @OneToMany(mappedBy = "imagen", cascade = CascadeType.ALL)
    private List<Historial> historiales = new ArrayList<>();
}
