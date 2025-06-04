package mx.tecnm.cdmadero.api.services

import mx.tecnm.cdmadero.api.entities.Persona
import mx.tecnm.cdmadero.api.repositories.PacienteRepository
import org.springframework.stereotype.Service

import java.util.*
@Service
class PacientesService(
    private val pacienteRepository: PacienteRepository,
) {
    fun findAll(): List<Persona> = pacienteRepository.findAll()

    fun findById(id: UUID): Optional<Persona> = pacienteRepository.findById(id)

    fun save(persona: Persona): Persona = pacienteRepository.save(persona)

    fun deleteById(id: UUID) = pacienteRepository.deleteById(id)
}