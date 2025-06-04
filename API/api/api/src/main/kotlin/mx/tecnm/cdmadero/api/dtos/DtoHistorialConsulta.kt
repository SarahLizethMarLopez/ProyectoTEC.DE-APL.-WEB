package mx.tecnm.cdmadero.api.dtos

data class DtoHistorialConsulta(
    val cedula: String = "",
    val curp: String = "",
    val peso: Double? = null,
    val altura: Double? = null,
    val antecedentes_heredo_familiares: String? = null,
    val consumo_de_sustancias: String? = null,
    val dependencia_de_sustancias: String? = null,
    val otros_antecedentes_personales_no_patologicos: String? = null,
    val otros_antecedentes_personales_patológicos: String? = null
)