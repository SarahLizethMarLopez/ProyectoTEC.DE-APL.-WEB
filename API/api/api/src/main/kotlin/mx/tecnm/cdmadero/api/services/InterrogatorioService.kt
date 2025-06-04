package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.Interrogatorio
    import mx.tecnm.cdmadero.api.repositories.InterrogatorioRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class InterrogatorioService(private val interrogatorioRepository: InterrogatorioRepository) {
    
        fun findAllInterrogatorio(): List<Interrogatorio> = interrogatorioRepository.findAll()
    
        fun findInterrogatorioById(id: UUID): Optional<Interrogatorio> = interrogatorioRepository.findById(id)
    
        fun saveInterrogatorio(interrogatorio: Interrogatorio): Interrogatorio = interrogatorioRepository.save(interrogatorio)
    
        fun deleteInterrogatorio(id: UUID) = interrogatorioRepository.deleteById(id)
    }
    