package demo.backend.Service.Interface;

import demo.backend.Model.Imagen;
import java.util.List;

/**
 *
 * @author Ismael
 */
public interface IImagenService {
    public List<Imagen> getImagenes();
    public void createImagen(Imagen imagen);
    public void deleteImagen(Integer id_imagen);
    public Imagen findImagen(Integer id_imagen);
}
