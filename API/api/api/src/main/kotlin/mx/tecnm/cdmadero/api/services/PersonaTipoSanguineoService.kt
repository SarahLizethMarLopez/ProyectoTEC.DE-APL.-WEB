package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.PersonaTipoSanguineo
    import mx.tecnm.cdmadero.api.repositories.PersonaTipoSanguineoRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class PersonaTipoSanguineoService(private val personaTipoSanguineoRepository: PersonaTipoSanguineoRepository) {
    
        fun findAllPersonaTipoSanguineo(): List<PersonaTipoSanguineo> = personaTipoSanguineoRepository.findAll()
    
        fun findPersonaTipoSanguineoById(id: UUID): Optional<PersonaTipoSanguineo> = personaTipoSanguineoRepository.findById(id)
    
        fun savePersonaTipoSanguineo(personaTipoSanguineo: PersonaTipoSanguineo): PersonaTipoSanguineo = personaTipoSanguineoRepository.save(personaTipoSanguineo)
    
        fun deletePersonaTipoSanguineo(id: UUID) = personaTipoSanguineoRepository.deleteById(id)
    }
    