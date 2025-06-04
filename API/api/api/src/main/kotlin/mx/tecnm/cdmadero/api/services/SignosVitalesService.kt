package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.SignosVitales
    import mx.tecnm.cdmadero.api.repositories.SignosVitalesRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class SignosVitalesService(private val signosVitalesRepository: SignosVitalesRepository) {
    
        fun findAllSignosVitales(): List<SignosVitales> = signosVitalesRepository.findAll()
    
        fun findSignosVitalesById(id: UUID): Optional<SignosVitales> = signosVitalesRepository.findById(id)
    
        fun saveSignosVitales(signosVitales: SignosVitales): SignosVitales = signosVitalesRepository.save(signosVitales)
    
        fun deleteSignosVitales(id: UUID) = signosVitalesRepository.deleteById(id)
    }
    