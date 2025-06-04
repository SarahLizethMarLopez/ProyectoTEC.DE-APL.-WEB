package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.CitaService
    import mx.tecnm.cdmadero.api.entities.Cita
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("registrar-cita")
    class CitaController(val service: CitaService) {

        @GetMapping("")
        fun getAll(model: Model): String {
            return "/pages/consultas/registro-citas"
        }

    }
    