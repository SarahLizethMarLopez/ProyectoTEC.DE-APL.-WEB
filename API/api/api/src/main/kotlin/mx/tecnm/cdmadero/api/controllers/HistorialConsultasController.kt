package mx.tecnm.cdmadero.api.controllers

import mx.tecnm.cdmadero.api.services.ConsultaGeneralService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/historial-consultas")
class HistorialConsultasController(
    val consultaGeneralService: ConsultaGeneralService
) {

    @GetMapping("")
    fun mostrarHistorialConsultas(model: Model): String {
        //  enviar datos al formulario (como listas)
        model.addAttribute("consultas", consultaGeneralService.findAll())

        return "pages/consultas/historial-consultas"
    }
}