package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.NotaDeReferenciaTraslado
    import mx.tecnm.cdmadero.api.repositories.NotaDeReferenciaTrasladoRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class NotaDeReferenciaTrasladoService(private val notaDeReferenciaTrasladoRepository: NotaDeReferenciaTrasladoRepository) {
    
        fun findAllNotaDeReferenciaTraslado(): List<NotaDeReferenciaTraslado> = notaDeReferenciaTrasladoRepository.findAll()
    
        fun findNotaDeReferenciaTrasladoById(id: UUID): Optional<NotaDeReferenciaTraslado> = notaDeReferenciaTrasladoRepository.findById(id)
    
        fun saveNotaDeReferenciaTraslado(notaDeReferenciaTraslado: NotaDeReferenciaTraslado): NotaDeReferenciaTraslado = notaDeReferenciaTrasladoRepository.save(notaDeReferenciaTraslado)
    
        fun deleteNotaDeReferenciaTraslado(id: UUID) = notaDeReferenciaTrasladoRepository.deleteById(id)
    }
    