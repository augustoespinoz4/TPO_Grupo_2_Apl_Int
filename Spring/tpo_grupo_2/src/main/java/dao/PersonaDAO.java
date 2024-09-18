package dao;

import modelo.Persona;
import java.util.List;
import java.util.Optional; 

public class PersonaDAO {
	private static PersonaDAO instancia;
    private PersonaDAO() {}

    public static synchronized PersonaDAO getInstancia() {
        if(instancia == null)
            instancia = new PersonaDAO();
        return instancia;
    }
    
    public List<Persona> obtenerPersonas(PersonaRepository personaRepository) {
        return personaRepository.findAll();
    }
    
    public Persona obtenerPorDocumento(PersonaRepository personaRepository, String documento) {
        Optional<Persona> persona = personaRepository.findById(documento);
        return persona.orElse(null); // Retorna null si no se encuentra la persona
    }

    public Persona guardarPersona(PersonaRepository personaRepository, Persona persona) {
        return personaRepository.save(persona);
    }

    public void eliminarPersona(PersonaRepository personaRepository, String documento) {
        // Verifica si la persona existe antes de eliminar
        if (personaRepository.existsById(documento)) {
            personaRepository.deleteById(documento);
        }
    }

    public List<Persona> buscarPorNombre(PersonaRepository personaRepository, String nombre) {
        return personaRepository.findByNombre(nombre);
    }
}
