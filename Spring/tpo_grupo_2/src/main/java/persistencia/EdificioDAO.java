package persistencia;

import java.util.List;

import modelo.Edificio;

public class EdificioDAO {
	
	private static EdificioDAO instancia;
	
	private EdificioDAO() {}
	
	public static EdificioDAO getInstancia() {
		if (instancia == null)
			instancia = new EdificioDAO();
		return instancia;
	}
	
	public List<Edificio> getAll(EdificioRepository edificioRepository) {
		return edificioRepository.findAll();
	}
}
