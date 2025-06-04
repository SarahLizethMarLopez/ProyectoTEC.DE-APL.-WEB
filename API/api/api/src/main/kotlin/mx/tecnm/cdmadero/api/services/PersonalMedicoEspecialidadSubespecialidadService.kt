package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.PersonalMedicoEspecialidadSubespecialidad
    import mx.tecnm.cdmadero.api.repositories.PersonalMedicoEspecialidadSubespecialidadRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class PersonalMedicoEspecialidadSubespecialidadService(private val personalMedicoEspecialidadSubespecialidadRepository: PersonalMedicoEspecialidadSubespecialidadRepository) {
    
        fun findAllPersonalMedicoEspecialidadSubespecialidad(): List<PersonalMedicoEspecialidadSubespecialidad> = personalMedicoEspecialidadSubespecialidadRepository.findAll()
    
        fun findPersonalMedicoEspecialidadSubespecialidadById(id: UUID): Optional<PersonalMedicoEspecialidadSubespecialidad> = personalMedicoEspecialidadSubespecialidadRepository.findById(id)
    
        fun savePersonalMedicoEspecialidadSubespecialidad(personalMedicoEspecialidadSubespecialidad: PersonalMedicoEspecialidadSubespecialidad): PersonalMedicoEspecialidadSubespecialidad = personalMedicoEspecialidadSubespecialidadRepository.save(personalMedicoEspecialidadSubespecialidad)
    
        fun deletePersonalMedicoEspecialidadSubespecialidad(id: UUID) = personalMedicoEspecialidadSubespecialidadRepository.deleteById(id)
    }
    