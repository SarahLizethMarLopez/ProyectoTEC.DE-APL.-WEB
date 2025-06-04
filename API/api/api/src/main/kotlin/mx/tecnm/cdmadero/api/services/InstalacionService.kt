package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.Instalacion
    import mx.tecnm.cdmadero.api.repositories.InstalacionRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class InstalacionService(private val instalacionRepository: InstalacionRepository) {
    
        fun findAllInstalacion(): List<Instalacion> = instalacionRepository.findAll()
    
        fun findInstalacionById(id: UUID): Optional<Instalacion> = instalacionRepository.findById(id)
    
        fun saveInstalacion(instalacion: Instalacion): Instalacion = instalacionRepository.save(instalacion)
    
        fun deleteInstalacion(id: UUID) = instalacionRepository.deleteById(id)
    }
    