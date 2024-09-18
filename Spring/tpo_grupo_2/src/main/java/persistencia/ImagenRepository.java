package persistencia;

import modelo.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
    public Optional<Imagen> findByDireccion(String direccion);
}
