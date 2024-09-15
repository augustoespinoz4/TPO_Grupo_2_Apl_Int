package persistencia;

import modelo.Persona;
import java.util.List; 

public class PersonaDAO {
	 private static PersonaDAO instancia;
    private PersonaDAO() {}

    public static synchronized PersonaDAO getInstancia() {
        if(instancia == null)
            instancia = new PersonaDAO();
        return instancia;
    }
    
    public List<Persona> getAll(PersonaRepository personaRepository) {
        return personaRepository.findAll();
    }
    
    public Persona getById(PersonaRepository personaRepository, int id) {
    	return personaRepository.getById(id);
    }
}
