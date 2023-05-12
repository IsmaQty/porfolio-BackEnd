package demo.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ismael
 */
@Entity @Getter @Setter
public class Historial {
    public static final boolean EXPERIENCIA = true;
    public static final boolean EDUCACION = false;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_historial;
    private String nombre;
    private boolean experiencia_educacion; // experiencia sera true, educacion sera false
    private String  titulo;
    private String ubicacion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private int duracion_meses;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_imagen", referencedColumnName = "id_imagen")
    private Imagen imagen;
    
    @ManyToMany(mappedBy = "historiales")
    private List<Persona> personas = new ArrayList<>();
}
