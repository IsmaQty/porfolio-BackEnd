package demo.backend.Service;

import demo.backend.Model.Persona;
import demo.backend.Repository.IPersonaRepository;
import demo.backend.Service.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ismael
 */
@Service
public class PersonaService implements IPersonaService {
    @Autowired IPersonaRepository personaRepos;

    @Override
    public List<Persona> getPersonas() {
        return personaRepos.findAll();
    }

    @Override
    public void createPersona(Persona persona) {
        personaRepos.save(persona);
    }

    @Override
    public void deletePersona(Integer dni) {
        personaRepos.deleteById(dni);
    }

    @Override
    public Persona findPersona(Integer dni) {
        return personaRepos.findById(dni).orElse(null);
    }

}
