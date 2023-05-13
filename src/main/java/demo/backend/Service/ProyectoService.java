package demo.backend.Service;

import demo.backend.Model.Proyecto;
import demo.backend.Repository.IProyectoRepository;
import demo.backend.Service.Interface.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ismael
 */
@Service
public class ProyectoService implements IProyectoService{
    @Autowired IProyectoRepository proyectoRepos;

    @Override
    public List<Proyecto> getProyectos() {
        return proyectoRepos.findAll();
    }

    @Override
    public void createProyecto(Proyecto proyecto) {
        proyectoRepos.save(proyecto);
    }

    @Override
    public void deleteProyecto(Integer id_proyecto) {
        proyectoRepos.deleteById(id_proyecto);
    }

    @Override
    public Proyecto findProyecto(Integer id_proyecto) {
        return proyectoRepos.findById(id_proyecto).orElse(null);
    }
    
}
