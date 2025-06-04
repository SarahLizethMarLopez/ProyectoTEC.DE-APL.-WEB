package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.PersonaAlergia
    import mx.tecnm.cdmadero.api.repositories.PersonaAlergiaRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class PersonaAlergiaService(private val personaAlergiaRepository: PersonaAlergiaRepository) {
    
        fun findAllPersonaAlergia(): List<PersonaAlergia> = personaAlergiaRepository.findAll()
    
        fun findPersonaAlergiaById(id: UUID): Optional<PersonaAlergia> = personaAlergiaRepository.findById(id)
    
        fun savePersonaAlergia(personaAlergia: PersonaAlergia): PersonaAlergia = personaAlergiaRepository.save(personaAlergia)
    
        fun deletePersonaAlergia(id: UUID) = personaAlergiaRepository.deleteById(id)
    }
    