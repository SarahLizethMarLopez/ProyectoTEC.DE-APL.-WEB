package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.PersonaPersonaAlergia
    import mx.tecnm.cdmadero.api.entities.keys.PersonaPersonaAlergiaId
    import mx.tecnm.cdmadero.api.repositories.PersonaPersonaAlergiaRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class PersonaPersonaAlergiaService(private val personaPersonaAlergiaRepository: PersonaPersonaAlergiaRepository) {
    
        fun findAllPersonaPersonaAlergia(): List<PersonaPersonaAlergia> = personaPersonaAlergiaRepository.findAll()
    
        fun findPersonaPersonaAlergiaById(id: PersonaPersonaAlergiaId): Optional<PersonaPersonaAlergia> = personaPersonaAlergiaRepository.findById(id)
    
        fun savePersonaPersonaAlergia(personaPersonaAlergia: PersonaPersonaAlergia): PersonaPersonaAlergia = personaPersonaAlergiaRepository.save(personaPersonaAlergia)
    
        fun deletePersonaPersonaAlergia(id: PersonaPersonaAlergiaId) = personaPersonaAlergiaRepository.deleteById(id)
    }
    