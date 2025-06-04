package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.ExploracionFisica
    import mx.tecnm.cdmadero.api.repositories.ExploracionFisicaRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class ExploracionFisicaService(private val exploracionFisicaRepository: ExploracionFisicaRepository) {
    
        fun findAllExploracionFisica(): List<ExploracionFisica> = exploracionFisicaRepository.findAll()
    
        fun findExploracionFisicaById(id: UUID): Optional<ExploracionFisica> = exploracionFisicaRepository.findById(id)
    
        fun saveExploracionFisica(exploracionFisica: ExploracionFisica): ExploracionFisica = exploracionFisicaRepository.save(exploracionFisica)
    
        fun deleteExploracionFisica(id: UUID) = exploracionFisicaRepository.deleteById(id)
    }
    