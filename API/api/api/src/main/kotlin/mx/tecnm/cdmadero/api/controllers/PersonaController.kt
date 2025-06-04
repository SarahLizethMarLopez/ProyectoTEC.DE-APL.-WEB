package mx.tecnm.cdmadero.api.controllers

import jakarta.servlet.http.HttpSession
import mx.tecnm.cdmadero.api.entities.Direccion
import mx.tecnm.cdmadero.api.entities.Persona
import mx.tecnm.cdmadero.api.entities.PersonaTipoSanguineo
import mx.tecnm.cdmadero.api.services.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
@RequestMapping("persona")
class PersonaController(
    val personaService: PersonaService,
    val tipoSanguineoService: PersonaTipoSanguineoService,
    val estadoService: DireccionEstadoService
) {

    @GetMapping("/list")
    fun getAll(): ResponseEntity<List<Persona>> {
        return ResponseEntity.ok(personaService.findAllPersona()) // cambiar por interfaz de vista de pacientes
    }

    @GetMapping("/form")
    fun getFormPaciente(model: Model): String {
        val persona = Persona()
//            persona.idDireccion = Direccion()
//            persona.idReligion = PersonaReligion()
        persona.idTipoSanguineo = PersonaTipoSanguineo()
        model.addAttribute("persona", persona)
        model.addAttribute("tiposSanguineos", tipoSanguineoService.findAllPersonaTipoSanguineo())
        model.addAttribute("estados", estadoService.findAllDireccionEstado())
        return "pages/register"
    }

    @GetMapping("/medico/form")
    fun getFormMedico(model: Model): String {
        model.addAttribute("pacientes", personaService.findAllPersona())
        return "pages/registerMedico"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute paciente: Persona): String {
        paciente.id = null;
        val save = personaService.savePersona(paciente)
        return  "redirect:/persona/lista-pacientes" //cambiar por la interfaz que corresponda (mostrar el registro del paciente)
    }

    @PostMapping("/newAside")
    fun createAside(@ModelAttribute paciente: Persona): String {
        paciente.id = null
        val save = personaService.savePersona(paciente)
        return  "redirect:/"
    }

    @GetMapping("/lista-pacientes")
    fun getAllPacientes(model: Model, session: HttpSession): String {
        val paciente = personaService.findAllPersona()
        val rol = session.getAttribute("rol") as? String ?: "INVITADO"
        model.addAttribute("listaPacientes", paciente)
        model.addAttribute("rol", rol) // <-- aquí agregamos el rol
        return "pages/pacientes/historial-paciente"
    }


    @GetMapping("/detalles-pacientes/{nss}")
    fun getDetallesPaciente(@PathVariable nss: String, model: Model): String {
        val paciente = personaService.findByNss(nss)
        model.addAttribute("paciente", paciente)
        return "pages/pacientes/detalles-pacientes"
    }



//        @PostMapping("/medico/new")

    @GetMapping("/editar/{id}")
    fun getEditFormPaciente(@PathVariable id: UUID, model: Model): String {
        val paciente = personaService.findById(id)
        model.addAttribute("persona", paciente)
        model.addAttribute("tiposSanguineos", tipoSanguineoService.findAllPersonaTipoSanguineo())
        model.addAttribute("estados", estadoService.findAllDireccionEstado())
        return "pages/pacientes/editar-paciente"
    }

    @PostMapping("/editar")
    fun updatePaciente(@ModelAttribute persona: Persona): String {
        personaService.updatePersona(persona)
        return "redirect:/persona/lista-pacientes"
    }

    @PostMapping("/eliminar/{id}")
    fun eliminarPaciente(@PathVariable id: UUID): String {
        personaService.deletePersona(id)
        return "redirect:/persona/lista-pacientes"
    }


}
