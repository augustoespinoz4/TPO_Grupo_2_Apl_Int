package dao;

import java.util.List;
import java.util.Optional;

import modelo.Edificio;

public class EdificioDAO {
	
	private static EdificioDAO instancia;
	
	private EdificioDAO() {}
	
	public static EdificioDAO getInstancia() {
		if (instancia == null)
			instancia = new EdificioDAO();
		return instancia;
	}
	
	public List<Edificio> obtenerEdificios(EdificioRepository edificioRepository) {
		return edificioRepository.findAll();
	}
	
    public Edificio obtenerPorCodigo(EdificioRepository edificioRepository, int codigo) {
        Optional<Edificio> edificio = edificioRepository.findById(codigo);
        return edificio.orElse(null); // Retorna null si no se encuentra el edificio
    }

    public Edificio guardarEdificio(EdificioRepository edificioRepository, Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public void eliminarEdificio(EdificioRepository edificioRepository, int codigo) {
        // Verifica si el edificio existe antes de eliminar
        if (edificioRepository.existsById(codigo)) {
            edificioRepository.deleteById(codigo);
        }
    }
	
}
