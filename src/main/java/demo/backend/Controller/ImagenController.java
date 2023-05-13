package demo.backend.Controller;

import demo.backend.Model.Imagen;
import demo.backend.Service.Interface.IImagenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ismael
 */
@RestController
public class ImagenController {
    @Autowired IImagenService imagenServi;
    
    @GetMapping ("/imagen/traer")
    public List<Imagen> getImagenes(){
        return imagenServi.getImagenes();
    }

    @GetMapping ("/imagen/traer/{id_imagen}")
    public Imagen findImagen(@PathVariable Integer id_imagen){
        return imagenServi.findImagen(id_imagen);
    }
    
    @PostMapping ("/imagen/crear")
    public String createImagen(@RequestBody Imagen imagen){
        imagenServi.createImagen(imagen);
        return efectuoCreacion(imagen.getId_imagen());
    }
    
    @DeleteMapping ("/imagen/eliminar/{id_imagen}")
    public String deleteImagen(@PathVariable Integer id_imagen){
        imagenServi.deleteImagen(id_imagen);
        return efectuoEliminacion(id_imagen);
    }
    
    @PutMapping ("/imagen/editar/{id_imagen}")
    public Imagen editImagen(@PathVariable Integer id_imagen,
            @RequestParam ("link") String link){
        Imagen imagen = imagenServi.findImagen(id_imagen);
        
        imagen.setLink(link);
        
        imagenServi.createImagen(imagen);
        return imagen;
    }
    
    private String efectuoCreacion(Integer id_imagen) {
        String mensaje = "La operacion de creacion resulto: ";
        if(imagenServi.findImagen(id_imagen)!=null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
    
    private String efectuoEliminacion(Integer id_imagen) {
        String mensaje = "La operacion de eliminacion resulto: ";
        if(imagenServi.findImagen(id_imagen)==null){
            mensaje+="exitosa";
        }else{
            mensaje+="fallida";
        }
        return mensaje;
    }
}
