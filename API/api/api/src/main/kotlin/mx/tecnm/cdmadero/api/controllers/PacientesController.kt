package mx.tecnm.cdmadero.api.controllers

import mx.tecnm.cdmadero.api.entities.Direccion
import mx.tecnm.cdmadero.api.entities.Persona
import mx.tecnm.cdmadero.api.entities.PersonaTipoSanguineo
import mx.tecnm.cdmadero.api.services.DireccionEstadoService
import mx.tecnm.cdmadero.api.services.PacientesService
import mx.tecnm.cdmadero.api.services.PersonaTipoSanguineoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
@RequestMapping("/pacientes")
class PacientesController(
    private val pacientesService: PacientesService,
    private val tipoSanguineoService: PersonaTipoSanguineoService,
    private val estadoService: DireccionEstadoService
) {

    @GetMapping("")
    fun getForm(model: Model): String {
        val persona = Persona()
        persona.idDireccion = Direccion()
        persona.idTipoSanguineo = PersonaTipoSanguineo()
        model.addAttribute("persona", persona)
        model.addAttribute("tiposSanguineos", tipoSanguineoService.findAllPersonaTipoSanguineo())
        model.addAttribute("estados", estadoService.findAllDireccionEstado())
        return "pages/pacientes/pacientes"
    }
}
