package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
	public Optional<Edificio> findByNombre(String nombre);
}
