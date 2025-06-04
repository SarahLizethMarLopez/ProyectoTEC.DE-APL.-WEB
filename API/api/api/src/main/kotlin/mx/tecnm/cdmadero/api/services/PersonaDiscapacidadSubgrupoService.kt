package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.PersonaDiscapacidadSubgrupo
    import mx.tecnm.cdmadero.api.repositories.PersonaDiscapacidadSubgrupoRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class PersonaDiscapacidadSubgrupoService(private val personaDiscapacidadSubgrupoRepository: PersonaDiscapacidadSubgrupoRepository) {
    
        fun findAllPersonaDiscapacidadSubgrupo(): List<PersonaDiscapacidadSubgrupo> = personaDiscapacidadSubgrupoRepository.findAll()
    
        fun findPersonaDiscapacidadSubgrupoById(id: UUID): Optional<PersonaDiscapacidadSubgrupo> = personaDiscapacidadSubgrupoRepository.findById(id)
    
        fun savePersonaDiscapacidadSubgrupo(personaDiscapacidadSubgrupo: PersonaDiscapacidadSubgrupo): PersonaDiscapacidadSubgrupo = personaDiscapacidadSubgrupoRepository.save(personaDiscapacidadSubgrupo)
    
        fun deletePersonaDiscapacidadSubgrupo(id: UUID) = personaDiscapacidadSubgrupoRepository.deleteById(id)
    }
    