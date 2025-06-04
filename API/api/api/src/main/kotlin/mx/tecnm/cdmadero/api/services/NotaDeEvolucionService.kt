package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.NotaDeEvolucion
    import mx.tecnm.cdmadero.api.repositories.NotaDeEvolucionRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class NotaDeEvolucionService(private val notaDeEvolucionRepository: NotaDeEvolucionRepository) {
    
        fun findAllNotaDeEvolucion(): List<NotaDeEvolucion> = notaDeEvolucionRepository.findAll()
    
        fun findNotaDeEvolucionById(id: UUID): Optional<NotaDeEvolucion> = notaDeEvolucionRepository.findById(id)
    
        fun saveNotaDeEvolucion(notaDeEvolucion: NotaDeEvolucion): NotaDeEvolucion = notaDeEvolucionRepository.save(notaDeEvolucion)
    
        fun deleteNotaDeEvolucion(id: UUID) = notaDeEvolucionRepository.deleteById(id)
    }
    