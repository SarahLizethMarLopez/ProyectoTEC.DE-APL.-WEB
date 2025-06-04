package mx.tecnm.cdmadero.api.controllers

import mx.tecnm.cdmadero.api.dtos.DtoMedico
import mx.tecnm.cdmadero.api.services.PersonalMedicoService
import mx.tecnm.cdmadero.api.services.PersonalMedicoEspecialidadService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
@RequestMapping("personalMedico")
class PersonalMedicoController(
    val service: PersonalMedicoService,
    val serviceEspecialidadController: PersonalMedicoEspecialidadService
) {

    @GetMapping("/lista-medicos")
    fun getAllMedicosView(model: Model): String {
        model.addAttribute("listaMedicos", service.findAllPersonalMedico())
        return "pages/medicos/historial-medicos"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        val especialidades = serviceEspecialidadController.findAllPersonalMedicoEspecialidad()
        model.addAttribute("dtoMedico", DtoMedico())
        model.addAttribute("especialidades", especialidades)
        return "pages/registerMedico"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: DtoMedico): String {
        val savePersonalMedico = service.savePersonalMedico(entity)
        return "redirect:/personalMedico/lista-medicos"
    }

    @GetMapping("/editar/{id}")
    fun getEditForm(@PathVariable id: String, model: Model): String {
        val medico = service.findById(id)
        val especialidades = serviceEspecialidadController.findAllPersonalMedicoEspecialidad()
        model.addAttribute("dtoMedico", medico)
        model.addAttribute("especialidades", especialidades)
        return "pages/medicos/editar-medico"
    }

    @PostMapping("/editar")
    fun updateMedico(@ModelAttribute dtoMedico: DtoMedico): String {
        service.update(dtoMedico)
        return "redirect:/personalMedico/lista-medicos"
    }

    @PostMapping("/eliminar/{id}")
    fun eliminarMedico(@PathVariable id: UUID): String {
        service.deletePersonalMedico(id)
        return "redirect:/personalMedico/lista-medicos"
    }
}
