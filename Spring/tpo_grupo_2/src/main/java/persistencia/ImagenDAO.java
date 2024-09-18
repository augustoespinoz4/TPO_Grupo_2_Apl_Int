package persistencia;

import modelo.Imagen;

import java.util.List;

public class ImagenDAO {
    private static ImagenDAO instancia;

    private ImagenDAO(){}

    public static ImagenDAO getInstacia(){
        if (instancia==null){
            instancia = new ImagenDAO();
        }
        return instancia;
    }

    public List<Imagen> getAll(ImagenRepository imagenRepository){return imagenRepository.findAll();}
}
