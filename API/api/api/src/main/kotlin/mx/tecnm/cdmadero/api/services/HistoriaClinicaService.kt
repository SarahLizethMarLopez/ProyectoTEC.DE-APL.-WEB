package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.HistoriaClinica
    import mx.tecnm.cdmadero.api.repositories.HistoriaClinicaRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class HistoriaClinicaService(private val historiaClinicaRepository: HistoriaClinicaRepository) {
    
        fun findAllHistoriaClinica(): List<HistoriaClinica> = historiaClinicaRepository.findAll()
    
        fun findHistoriaClinicaById(id: UUID): Optional<HistoriaClinica> = historiaClinicaRepository.findById(id)
    
        fun saveHistoriaClinica(historiaClinica: HistoriaClinica): HistoriaClinica = historiaClinicaRepository.save(historiaClinica)
    
        fun deleteHistoriaClinica(id: UUID) = historiaClinicaRepository.deleteById(id)
    }
    