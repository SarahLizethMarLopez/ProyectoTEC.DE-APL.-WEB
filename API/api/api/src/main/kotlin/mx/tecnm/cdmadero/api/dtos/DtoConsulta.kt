package mx.tecnm.cdmadero.api.dtos

import mx.tecnm.cdmadero.api.entities.*

class DtoConsulta(
    var curpPaciente: String = "",
    var cedulaMedico: String = "",
    var consulta: ConsultaGeneral = ConsultaGeneral().apply {

        idHistoriaClinica = HistoriaClinica().apply {

            idExploracionFisica = ExploracionFisica().apply {
                idSignosVitales = SignosVitales()
            }

            idInterrogatorio = Interrogatorio()
        }

        idNotaDeEvolucion = NotaDeEvolucion().apply {
            idSignosVitales = SignosVitales()
            idTratamiento = Tratamiento()
        }

        idNotaDeTraslado = NotaDeReferenciaTraslado().apply {

        }

        idNotaDeInterconsulta = NotaDeInterconsulta().apply {
            idTratamiento = Tratamiento()
            idSignosVitales = SignosVitales()
            idExploracionFisica = ExploracionFisica()
        }
    }
)
