package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.Institucion
    import mx.tecnm.cdmadero.api.repositories.InstitucionRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class InstitucionService(private val institucionRepository: InstitucionRepository) {
    
        fun findAllInstitucion(): List<Institucion> = institucionRepository.findAll()
    
        fun findInstitucionById(id: UUID): Optional<Institucion> = institucionRepository.findById(id)
    
        fun saveInstitucion(institucion: Institucion): Institucion = institucionRepository.save(institucion)
    
        fun deleteInstitucion(id: UUID) = institucionRepository.deleteById(id)
    }
    