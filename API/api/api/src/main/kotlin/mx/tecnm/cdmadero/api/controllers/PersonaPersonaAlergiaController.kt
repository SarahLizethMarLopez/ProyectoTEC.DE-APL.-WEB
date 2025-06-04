package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.PersonaPersonaAlergiaService
    import mx.tecnm.cdmadero.api.entities.PersonaPersonaAlergia
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("personaPersonaAlergia")
    class PersonaPersonaAlergiaController(val service: PersonaPersonaAlergiaService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllPersonaPersonaAlergia())
            return "/views/PersonaPersonaAlergiaView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", PersonaPersonaAlergia())
            return "/formularies/PersonaPersonaAlergiaForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: PersonaPersonaAlergia, model: Model): String {
            service.savePersonaPersonaAlergia(entity)
            return "redirect:/personaPersonaAlergia/list"
        }
    }
    