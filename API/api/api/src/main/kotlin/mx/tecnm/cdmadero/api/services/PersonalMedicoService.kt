package mx.tecnm.cdmadero.api.services

import mx.tecnm.cdmadero.api.dtos.DtoMedico
import mx.tecnm.cdmadero.api.entities.PersonalMedico
import mx.tecnm.cdmadero.api.repositories.PersonaRepository
import mx.tecnm.cdmadero.api.repositories.PersonalMedicoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*

@Service
class PersonalMedicoService(
    private val personalMedicoRepository: PersonalMedicoRepository,
    private val personaRepository: PersonaRepository
) {
    fun login(cedula: String, contrasena: String): PersonalMedico? =
        personalMedicoRepository.findByCedulaAndContrasena(cedula, contrasena)

    fun findAllPersonalMedico(): List<PersonalMedico> = personalMedicoRepository.findAll()

    fun findPersonalMedicoById(id: UUID): Optional<PersonalMedico> =
        personalMedicoRepository.findById(id)

    @Transactional
    fun savePersonalMedico(dto: DtoMedico): PersonalMedico {
        val (fechaNacimiento, sexo) = extraerDatosDesdeCurp(dto.curp)

        if (fechaNacimiento == null) {
            throw IllegalArgumentException("El CURP proporcionado no contiene una fecha válida.")
        }

        val medico = PersonalMedico().apply {
            this.curp = dto.curp
            this.nombre = dto.nombre
            this.apellidoPaterno = dto.apellidoPaterno
            this.apellidoMaterno = dto.apellidoMaterno
            this.sexo = sexo
            this.fechaNacimiento = fechaNacimiento
            this.contrasena = dto.contrasena
            this.rol = dto.rol
            this.cedula = dto.medico.cedula
            this.idEspecialidad = dto.medico.idEspecialidad
        }

        return personalMedicoRepository.save(medico)
    }

    fun deletePersonalMedico(id: UUID) =
        personalMedicoRepository.deleteById(id)

    fun findById(id: String): DtoMedico {
        val medico = personalMedicoRepository.findById(UUID.fromString(id)).orElseThrow()

        return DtoMedico(
            id = medico.id,
            curp = medico.curp ?: "",
            nombre = medico.nombre ?: "",
            apellidoPaterno = medico.apellidoPaterno ?: "",
            apellidoMaterno = medico.apellidoMaterno ?: "",
            sexo = medico.sexo?.toString() ?: "",
            fechaNacimiento = medico.fechaNacimiento,
            contrasena = medico.contrasena ?: "",
            rol = medico.rol ?: "",
            medico = PersonalMedico().apply {
                cedula = medico.cedula
                idEspecialidad = medico.idEspecialidad
            }
        )
    }

    fun update(dto: DtoMedico): PersonalMedico {
        val medico = personalMedicoRepository.findById(dto.id ?: UUID.randomUUID()).orElseThrow()
        val (fechaNacimiento, sexo) = extraerDatosDesdeCurp(dto.curp)

        if (fechaNacimiento == null) {
            throw IllegalArgumentException("El CURP proporcionado no contiene una fecha válida.")
        }

        medico.apply {
            this.curp = dto.curp
            this.nombre = dto.nombre
            this.apellidoPaterno = dto.apellidoPaterno
            this.apellidoMaterno = dto.apellidoMaterno
            this.sexo = sexo
            this.fechaNacimiento = fechaNacimiento
            this.contrasena = dto.contrasena
            this.rol = dto.rol
            this.cedula = dto.medico.cedula
            this.idEspecialidad = dto.medico.idEspecialidad
        }

        return personalMedicoRepository.save(medico)
    }

    private fun extraerDatosDesdeCurp(curp: String): Pair<LocalDate?, Char> {
        return try {
            if (curp.length < 18) throw IllegalArgumentException("CURP inválido")

            val fechaCurp = curp.substring(4, 10)
            val sexoChar = curp[10]

            val anio = fechaCurp.substring(0, 2).toInt()
            val mes = fechaCurp.substring(2, 4).toInt()
            val dia = fechaCurp.substring(4, 6).toInt()
            val siglo = if (curp[16] == '0') 1900 else 2000
            val anioCompleto = siglo + anio

            val fechaNacimiento = LocalDate.of(anioCompleto, mes, dia)
            val sexo = if (sexoChar == 'M') 'F' else 'M'

            Pair(fechaNacimiento, sexo)
        } catch (e: Exception) {
            Pair(null, 'M')
        }
    }
}