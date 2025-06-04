package mx.tecnm.cdmadero.api.dtos

import mx.tecnm.cdmadero.api.entities.PersonalMedico
import java.time.LocalDate
import java.util.*

data class DtoMedico(
    val id: UUID? = null,
    val curp: String = "",
    val nombre: String = "",
    val apellidoPaterno: String = "",
    val apellidoMaterno: String = "",
    val sexo: String = "",
    val fechaNacimiento: LocalDate? = null,
    val rol: String = "",
    val contrasena: String = "",
    val medico: PersonalMedico = PersonalMedico()
)
