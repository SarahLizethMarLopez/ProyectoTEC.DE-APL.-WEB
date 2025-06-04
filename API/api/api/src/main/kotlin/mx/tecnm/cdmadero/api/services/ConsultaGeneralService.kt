package mx.tecnm.cdmadero.api.services

import mx.tecnm.cdmadero.api.dtos.DtoConsulta
import mx.tecnm.cdmadero.api.dtos.DtoHistorialConsulta
import mx.tecnm.cdmadero.api.entities.ConsultaGeneral
import mx.tecnm.cdmadero.api.repositories.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.util.*

@Service
@Transactional
class ConsultaGeneralService(
    private val consultaGeneralRepository: ConsultaGeneralRepository,
    private val personaRepository: PersonaRepository,
    private val personalMedicoRepository: PersonalMedicoRepository,
    private val historiaClinicaRepository: HistoriaClinicaRepository,
    private val notaDeEvolucionRepository: NotaDeEvolucionRepository,
    private val notaDeReferenciaTrasladoRepository: NotaDeReferenciaTrasladoRepository,
    private val notaDeInterconsultaRepository: NotaDeInterconsultaRepository,
    private val exploracionFisicaService: ExploracionFisicaService,
    private val signosVitalesRepository: SignosVitalesRepository,
    private val interrogatorioRepository: InterrogatorioRepository,
    private val tratamientoRepository: TratamientoRepository,
) {

    fun findAll(): List<ConsultaGeneral> = consultaGeneralRepository.findAll()

    fun findById(id: UUID): Optional<ConsultaGeneral> =
        consultaGeneralRepository.findById(id)

    @Transactional
    fun save(consultaGeneral: DtoConsulta): ConsultaGeneral {
        val paciente = personaRepository.findByCurp(consultaGeneral.curpPaciente)
        val medico = personalMedicoRepository.findByCedula(consultaGeneral.cedulaMedico)
        //crear verificacion de que un doctor no se automedique

        val consulta = consultaGeneral.consulta
        consulta.apply {
            id = UUID.randomUUID()
            idPersona = paciente
            idPersonalMedico = medico
            fechaHora = Instant.now()
        }

        // guardado de historia clinica
        consulta.idHistoriaClinica!!.id = UUID.randomUUID()
        consulta.idHistoriaClinica!!.idInterrogatorio!!.id = UUID.randomUUID()
        consulta.idHistoriaClinica!!.idExploracionFisica!!.id = UUID.randomUUID()
        consulta.idHistoriaClinica!!.idExploracionFisica!!.idSignosVitales!!.id = UUID.randomUUID()

        consulta.idHistoriaClinica!!.idPersona = paciente

        signosVitalesRepository.save(consulta.idHistoriaClinica!!.idExploracionFisica!!.idSignosVitales!!)
        exploracionFisicaService.saveExploracionFisica(consulta.idHistoriaClinica!!.idExploracionFisica!!)
        interrogatorioRepository.save(consulta.idHistoriaClinica!!.idInterrogatorio!!)
        historiaClinicaRepository.save(consulta.idHistoriaClinica!!)

        // guardado de nota de evolucion
        consulta.idNotaDeEvolucion!!.id = UUID.randomUUID()
        consulta.idNotaDeEvolucion!!.idSignosVitales!!.id = UUID.randomUUID()
        consulta.idNotaDeEvolucion!!.idTratamiento!!.id = UUID.randomUUID()

        signosVitalesRepository.save(consulta.idNotaDeEvolucion!!.idSignosVitales!!)
        tratamientoRepository.save(consulta.idNotaDeEvolucion!!.idTratamiento!!)
        notaDeEvolucionRepository.save(consulta.idNotaDeEvolucion!!)

        // guardado de interconsulta
        consulta.idNotaDeInterconsulta!!.id = UUID.randomUUID()
        consulta.idNotaDeInterconsulta!!.idTratamiento = consulta.idNotaDeEvolucion!!.idTratamiento!!
        consulta.idNotaDeInterconsulta!!.idSignosVitales = consulta.idNotaDeEvolucion!!.idSignosVitales!!
        consulta.idNotaDeInterconsulta!!.idExploracionFisica = consulta.idHistoriaClinica!!.idExploracionFisica!!

        consulta.idNotaDeInterconsulta!!.fechaHora = Instant.now()

        notaDeInterconsultaRepository.save(consulta.idNotaDeInterconsulta!!)

        // guardado de nota de traslado
        consulta.idNotaDeTraslado!!.id = UUID.randomUUID()
        notaDeReferenciaTrasladoRepository.save(consulta.idNotaDeTraslado!!)
        return consultaGeneralRepository.save(consulta)
    }

    fun delete(id: UUID) =
        consultaGeneralRepository.deleteById(id)

    fun findAllAsDto(): List<DtoHistorialConsulta> {
        val consultas = consultaGeneralRepository.findAll()
        return consultas.map {
            DtoHistorialConsulta(
                cedula = it.idPersonalMedico?.cedula ?: "",
                curp = it.idPersona?.curp ?: "",
                peso = it.idHistoriaClinica?.idExploracionFisica?.pesoKg,
                altura = it.idHistoriaClinica?.idExploracionFisica?.tallaCm,
                antecedentes_heredo_familiares = it.idHistoriaClinica?.idInterrogatorio?.antecedentesHeredoFamiliares,
                consumo_de_sustancias = it.idHistoriaClinica?.idInterrogatorio?.consumoDeSustancias,
                dependencia_de_sustancias = it.idHistoriaClinica?.idInterrogatorio?.dependenciaDeSustancias,
                otros_antecedentes_personales_no_patologicos = it.idHistoriaClinica?.idInterrogatorio?.otrosAntecedentesPersonalesNoPatologicos,
                otros_antecedentes_personales_patológicos = it.idHistoriaClinica?.idInterrogatorio?.otrosAntecedentesPersonalesPatológicos
            )
        }
    }

    fun findAllAsDtoByMedico(cedulaMedico: String): List<DtoHistorialConsulta> {
        val consultas = consultaGeneralRepository.findAllByIdPersonalMedico_Cedula(cedulaMedico)
        return consultas.map {
            DtoHistorialConsulta(
                cedula = it.idPersonalMedico?.cedula ?: "",
                curp = it.idPersona?.curp ?: "",
                peso = it.idHistoriaClinica?.idExploracionFisica?.pesoKg,
                altura = it.idHistoriaClinica?.idExploracionFisica?.tallaCm,
                antecedentes_heredo_familiares = it.idHistoriaClinica?.idInterrogatorio?.antecedentesHeredoFamiliares,
                consumo_de_sustancias = it.idHistoriaClinica?.idInterrogatorio?.consumoDeSustancias,
                dependencia_de_sustancias = it.idHistoriaClinica?.idInterrogatorio?.dependenciaDeSustancias,
                otros_antecedentes_personales_no_patologicos = it.idHistoriaClinica?.idInterrogatorio?.otrosAntecedentesPersonalesNoPatologicos,
                otros_antecedentes_personales_patológicos = it.idHistoriaClinica?.idInterrogatorio?.otrosAntecedentesPersonalesPatológicos
            )
        }
    }
}
