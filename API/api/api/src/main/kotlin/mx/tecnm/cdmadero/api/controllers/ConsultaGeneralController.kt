package mx.tecnm.cdmadero.api.controllers

import jakarta.servlet.http.HttpSession
import mx.tecnm.cdmadero.api.dtos.DtoConsulta
import mx.tecnm.cdmadero.api.services.ConsultaGeneralService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/consultas")
class ConsultaGeneralController(
    val consultaGeneralService: ConsultaGeneralService
) {

    @GetMapping("", "/registrar")
    fun mostrarFormularioRegistroConsulta(model: Model, session: HttpSession): String {
        val dto = DtoConsulta()

        val medico = session.getAttribute("usuario") as? mx.tecnm.cdmadero.api.entities.PersonalMedico
        if (medico != null) {
            dto.cedulaMedico = medico.cedula!!
        }

        model.addAttribute("datos", dto)
        return "pages/consultas/registro-consulta"
    }


    @PostMapping("/new")
    fun create(@ModelAttribute dto: DtoConsulta): String {
        consultaGeneralService.save(dto)
        return "redirect:/consultas/historial"
    }

    @GetMapping("/historial")
    fun getHistorialConsultas(model: Model, session: HttpSession): String {
        val rol = session.getAttribute("rol") as? String ?: ""
        val usuario = session.getAttribute("usuario")
        if (rol == "Medico" && usuario is mx.tecnm.cdmadero.api.entities.PersonalMedico) {
            val cedula = usuario.cedula ?: ""
            model.addAttribute("listaConsultas", consultaGeneralService.findAllAsDtoByMedico(cedula))
        } else {
            // Admin puede ver todas
            model.addAttribute("listaConsultas", consultaGeneralService.findAllAsDto())
        }
        return "pages/consultas/historial-consultas"
    }
}

