package demo.backend.Service;

import demo.backend.Model.Historial;
import demo.backend.Repository.IHistorialRepository;
import demo.backend.Service.Interface.IHistorialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ismael
 */
@Service
public class HistorialService implements IHistorialService{
    @Autowired IHistorialRepository historialRepos;
    
    @Override
    public List<Historial> getHistoriales() {
        List<Historial> listaHistorial = historialRepos.findAll();
        return listaHistorial;
    }

    @Override
    public void createHistorial(Historial historial) {
        historialRepos.save(historial);
    }

    @Override
    public void deleteHistorial(Integer id_historial) {
        historialRepos.deleteById(id_historial);
    }

    @Override
    public Historial findHistorial(Integer id_historial) {
        return historialRepos.findById(id_historial).orElse(null);
    }
    
}
