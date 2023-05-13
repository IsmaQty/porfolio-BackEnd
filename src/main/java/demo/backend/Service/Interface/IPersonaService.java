package demo.backend.Service.Interface;

import demo.backend.Model.Persona;
import java.util.List;

/**
 *
 * @author Ismael
 */
public interface IPersonaService {
    public List<Persona> getPersonas();
    public void createPersona(Persona persona);
    public void deletePersona(Integer dni);
    public Persona findPersona(Integer dni);
}
