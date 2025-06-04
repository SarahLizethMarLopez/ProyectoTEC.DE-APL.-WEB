package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.Tratamiento
    import mx.tecnm.cdmadero.api.repositories.TratamientoRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class TratamientoService(private val tratamientoRepository: TratamientoRepository) {
    
        fun findAllTratamiento(): List<Tratamiento> = tratamientoRepository.findAll()
    
        fun findTratamientoById(id: UUID): Optional<Tratamiento> = tratamientoRepository.findById(id)
    
        fun saveTratamiento(tratamiento: Tratamiento): Tratamiento = tratamientoRepository.save(tratamiento)
    
        fun deleteTratamiento(id: UUID) = tratamientoRepository.deleteById(id)
    }
    