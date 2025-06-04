package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.PersonaDiscapacidadSubgrupoService
    import mx.tecnm.cdmadero.api.entities.PersonaDiscapacidadSubgrupo
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("personaDiscapacidadSubgrupo")
    class PersonaDiscapacidadSubgrupoController(val service: PersonaDiscapacidadSubgrupoService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllPersonaDiscapacidadSubgrupo())
            return "/views/PersonaDiscapacidadSubgrupoView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", PersonaDiscapacidadSubgrupo())
            return "/formularies/PersonaDiscapacidadSubgrupoForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: PersonaDiscapacidadSubgrupo, model: Model): String {
            service.savePersonaDiscapacidadSubgrupo(entity)
            return "redirect:/personaDiscapacidadSubgrupo/list"
        }
    }
    