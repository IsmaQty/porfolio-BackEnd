package demo.backend.Service;

import demo.backend.Model.Imagen;
import demo.backend.Repository.IImagenRepository;
import demo.backend.Service.Interface.IImagenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ismael
 */
@Service
public class ImagenService implements IImagenService{
    @Autowired IImagenRepository imagenRepos;

    @Override
    public List<Imagen> getImagenes() {
        return imagenRepos.findAll();
    }

    @Override
    public void createImagen(Imagen imagen) {
        imagenRepos.save(imagen);
    }

    @Override
    public void deleteImagen(Integer id_imagen) {
        imagenRepos.deleteById(id_imagen);
    }

    @Override
    public Imagen findImagen(Integer id_imagen) {
        return imagenRepos.findById(id_imagen).orElse(null);
    }
}
