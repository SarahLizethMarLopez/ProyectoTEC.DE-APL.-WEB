package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.PersonalMedicoEspecialidadService
    import mx.tecnm.cdmadero.api.entities.PersonalMedicoEspecialidad
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("personalMedicoEspecialidad")
    class PersonalMedicoEspecialidadController(val service: PersonalMedicoEspecialidadService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllPersonalMedicoEspecialidad())
            return "/views/PersonalMedicoEspecialidadView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", PersonalMedicoEspecialidad())
            return "/formularies/PersonalMedicoEspecialidadForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: PersonalMedicoEspecialidad, model: Model): String {
            service.savePersonalMedicoEspecialidad(entity)
            return "redirect:/personalMedicoEspecialidad/list"
        }
    }
    