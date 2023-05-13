package demo.backend.Service;

import demo.backend.Model.Desarrollo;
import demo.backend.Repository.IDesarrolloRepository;
import demo.backend.Service.Interface.IDesarrolloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ismael
 */
@Service
public class DesarrolloService implements IDesarrolloService{
    @Autowired IDesarrolloRepository desarrolloRepos; 

    @Override
    public List<Desarrollo> getDesarrollos() {
        List<Desarrollo> listaDesarrollos = desarrolloRepos.findAll();
        return listaDesarrollos;
    }

    @Override
    public void createDesarrollo(Desarrollo desarrollo) {
        desarrolloRepos.save(desarrollo);
    }

    @Override
    public void deleteDesarrollo(Integer dni) {
        desarrolloRepos.deleteById(dni);
    }

    @Override
    public Desarrollo findDesarrollo(Integer dni) {
        return desarrolloRepos.findById(dni).orElse(null);
    }
    
}
