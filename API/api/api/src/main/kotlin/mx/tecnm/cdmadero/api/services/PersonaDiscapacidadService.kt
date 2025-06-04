package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.PersonaDiscapacidad
    import mx.tecnm.cdmadero.api.repositories.PersonaDiscapacidadRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class PersonaDiscapacidadService(private val personaDiscapacidadRepository: PersonaDiscapacidadRepository) {
    
        fun findAllPersonaDiscapacidad(): List<PersonaDiscapacidad> = personaDiscapacidadRepository.findAll()
    
        fun findPersonaDiscapacidadById(id: UUID): Optional<PersonaDiscapacidad> = personaDiscapacidadRepository.findById(id)
    
        fun savePersonaDiscapacidad(personaDiscapacidad: PersonaDiscapacidad): PersonaDiscapacidad = personaDiscapacidadRepository.save(personaDiscapacidad)
    
        fun deletePersonaDiscapacidad(id: UUID) = personaDiscapacidadRepository.deleteById(id)
    }
    