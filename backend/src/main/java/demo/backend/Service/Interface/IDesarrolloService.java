package demo.backend.Service.Interface;

import demo.backend.Model.Desarrollo;
import java.util.List;

/**
 *
 * @author Ismael
 */
public interface IDesarrolloService {
    public List<Desarrollo> getDesarrollos();
    public void createDesarrollo(Desarrollo desarrollo);
    public void deleteDesarrollo(Integer dni);
    public Desarrollo findDesarrollo(Integer dni);
}
