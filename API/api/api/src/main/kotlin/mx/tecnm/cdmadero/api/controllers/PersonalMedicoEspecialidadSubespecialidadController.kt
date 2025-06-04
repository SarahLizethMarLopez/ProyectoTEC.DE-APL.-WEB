package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.PersonalMedicoEspecialidadSubespecialidadService
    import mx.tecnm.cdmadero.api.entities.PersonalMedicoEspecialidadSubespecialidad
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("personalMedicoEspecialidadSubespecialidad")
    class PersonalMedicoEspecialidadSubespecialidadController(val service: PersonalMedicoEspecialidadSubespecialidadService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllPersonalMedicoEspecialidadSubespecialidad())
            return "/views/PersonalMedicoEspecialidadSubespecialidadView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", PersonalMedicoEspecialidadSubespecialidad())
            return "/formularies/PersonalMedicoEspecialidadSubespecialidadForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: PersonalMedicoEspecialidadSubespecialidad, model: Model): String {
            service.savePersonalMedicoEspecialidadSubespecialidad(entity)
            return "redirect:/personalMedicoEspecialidadSubespecialidad/list"
        }
    }
    