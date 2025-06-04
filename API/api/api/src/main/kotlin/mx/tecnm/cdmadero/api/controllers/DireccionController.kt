package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.DireccionService
    import mx.tecnm.cdmadero.api.entities.Direccion
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("direccion")
    class DireccionController(val service: DireccionService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllDireccion())
            return "/views/DireccionView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", Direccion())
            return "/formularies/DireccionForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: Direccion, model: Model): String {
            service.saveDireccion(entity)
            return "redirect:/direccion/list"
        }
    }
    