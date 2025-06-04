package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.PersonaDiscapacidadService
    import mx.tecnm.cdmadero.api.entities.PersonaDiscapacidad
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("personaDiscapacidad")
    class PersonaDiscapacidadController(val service: PersonaDiscapacidadService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllPersonaDiscapacidad())
            return "/views/PersonaDiscapacidadView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", PersonaDiscapacidad())
            return "/formularies/PersonaDiscapacidadForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: PersonaDiscapacidad, model: Model): String {
            service.savePersonaDiscapacidad(entity)
            return "redirect:/personaDiscapacidad/list"
        }
    }
    