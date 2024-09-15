package persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    public Optional<Persona> findByNombre(String nombre);
}
