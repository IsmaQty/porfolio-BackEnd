package demo.backend.Service.Interface;

import demo.backend.Model.Historial;
import java.util.List;

/**
 *
 * @author Ismael
 */
public interface IHistorialService {
    public List<Historial> getHistoriales();
    public void createHistorial(Historial historia);
    public void deleteHistorial(Integer id_historial);
    public Historial findHistorial(Integer id_historial);
}
