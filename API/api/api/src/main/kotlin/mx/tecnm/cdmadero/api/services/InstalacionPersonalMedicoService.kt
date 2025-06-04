package mx.tecnm.cdmadero.api.services

    import mx.tecnm.cdmadero.api.entities.InstalacionPersonalMedico
    import mx.tecnm.cdmadero.api.repositories.InstalacionPersonalMedicoRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class InstalacionPersonalMedicoService(private val instalacionPersonalMedicoRepository: InstalacionPersonalMedicoRepository) {
    
        fun findAllInstalacionPersonalMedico(): List<InstalacionPersonalMedico> = instalacionPersonalMedicoRepository.findAll()
    
        fun findInstalacionPersonalMedicoById(id: UUID): Optional<InstalacionPersonalMedico> = instalacionPersonalMedicoRepository.findById(id)
    
        fun saveInstalacionPersonalMedico(instalacionPersonalMedico: InstalacionPersonalMedico): InstalacionPersonalMedico = instalacionPersonalMedicoRepository.save(instalacionPersonalMedico)
    
        fun deleteInstalacionPersonalMedico(id: UUID) = instalacionPersonalMedicoRepository.deleteById(id)
    }
    