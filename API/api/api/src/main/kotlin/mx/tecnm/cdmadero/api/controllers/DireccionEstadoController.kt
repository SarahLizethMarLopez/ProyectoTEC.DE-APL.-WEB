package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.DireccionEstadoService
    import mx.tecnm.cdmadero.api.entities.DireccionEstado
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("direccionEstado")
    class DireccionEstadoController(val service: DireccionEstadoService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllDireccionEstado())
            return "/views/DireccionEstadoView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", DireccionEstado())
            return "/formularies/DireccionEstadoForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: DireccionEstado, model: Model): String {
            service.saveDireccionEstado(entity)
            return "redirect:/direccionEstado/list"
        }
    }
    