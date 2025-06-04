package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.Cita
    import mx.tecnm.cdmadero.api.repositories.CitaRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class CitaService(private val citaRepository: CitaRepository) {
    
        fun findAllCita(): List<Cita> = citaRepository.findAll()
    
        fun findCitaById(id: UUID): Optional<Cita> = citaRepository.findById(id)
    
        fun saveCita(cita: Cita): Cita = citaRepository.save(cita)
    
        fun deleteCita(id: UUID) = citaRepository.deleteById(id)
    }
    