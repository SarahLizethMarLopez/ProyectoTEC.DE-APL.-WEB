package mx.tecnm.cdmadero.api.controllers

import ch.qos.logback.core.model.Model
import mx.tecnm.cdmadero.api.services.PacientesService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/historial-paciente")
class HistorialPacienteController (val historialPacientesService: PacientesService) {

    @GetMapping("")
    fun mostrarHistorialPaciente(model:Model): String {
        return "pages/pacientes/historial-paciente"
    }
}