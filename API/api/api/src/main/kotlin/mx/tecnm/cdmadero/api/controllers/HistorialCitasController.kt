package mx.tecnm.cdmadero.api.controllers

import mx.tecnm.cdmadero.api.services.CitaService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
@Controller
@RequestMapping("historial-citas")
class HistorialCitasController {

    @GetMapping("")
    fun mostrarHistorialCitas(model: Model): String {
        return "pages/consultas/historial-citas"
    }

}
