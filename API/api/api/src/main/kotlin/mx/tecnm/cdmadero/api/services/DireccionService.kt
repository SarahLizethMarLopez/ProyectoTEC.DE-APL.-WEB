package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.Direccion
    import mx.tecnm.cdmadero.api.repositories.DireccionRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class DireccionService(private val direccionRepository: DireccionRepository) {
    
        fun findAllDireccion(): List<Direccion> = direccionRepository.findAll()
    
        fun findDireccionById(id: UUID): Optional<Direccion> = direccionRepository.findById(id)
    
        fun saveDireccion(direccion: Direccion): Direccion = direccionRepository.save(direccion)
    
        fun deleteDireccion(id: UUID) = direccionRepository.deleteById(id)
    }
    