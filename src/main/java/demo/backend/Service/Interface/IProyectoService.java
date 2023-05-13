package demo.backend.Service.Interface;

import demo.backend.Model.Proyecto;
import java.util.List;

/**
 *
 * @author Ismael
 */
public interface IProyectoService {
    public List<Proyecto> getProyectos();
    public void createProyecto(Proyecto proyecto);
    public void deleteProyecto(Integer id_proyecto);
    public Proyecto findProyecto(Integer id_proyecto);
}
