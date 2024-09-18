package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
    List<Persona> findByNombre(String nombre);
}
