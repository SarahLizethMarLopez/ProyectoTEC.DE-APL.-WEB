package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.Medicamento
    import mx.tecnm.cdmadero.api.repositories.MedicamentoRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class MedicamentoService(private val medicamentoRepository: MedicamentoRepository) {
    
        fun findAllMedicamento(): List<Medicamento> = medicamentoRepository.findAll()
    
        fun findMedicamentoById(id: UUID): Optional<Medicamento> = medicamentoRepository.findById(id)
    
        fun saveMedicamento(medicamento: Medicamento): Medicamento = medicamentoRepository.save(medicamento)
    
        fun deleteMedicamento(id: UUID) = medicamentoRepository.deleteById(id)
    }
    