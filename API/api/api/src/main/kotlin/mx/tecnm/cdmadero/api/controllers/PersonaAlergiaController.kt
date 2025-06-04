package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.PersonaAlergiaService
    import mx.tecnm.cdmadero.api.entities.PersonaAlergia
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("personaAlergia")
    class PersonaAlergiaController(val service: PersonaAlergiaService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllPersonaAlergia())
            return "/views/PersonaAlergiaView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", PersonaAlergia())
            return "/formularies/PersonaAlergiaForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: PersonaAlergia, model: Model): String {
            service.savePersonaAlergia(entity)
            return "redirect:/personaAlergia/list"
        }
    }
    