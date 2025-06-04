package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.PersonaTipoSanguineoService
    import mx.tecnm.cdmadero.api.entities.PersonaTipoSanguineo
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("personaTipoSanguineo")
    class PersonaTipoSanguineoController(val service: PersonaTipoSanguineoService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllPersonaTipoSanguineo())
            return "/views/PersonaTipoSanguineoView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", PersonaTipoSanguineo())
            return "/formularies/PersonaTipoSanguineoForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: PersonaTipoSanguineo, model: Model): String {
            service.savePersonaTipoSanguineo(entity)
            return "redirect:/personaTipoSanguineo/list"
        }
    }
    