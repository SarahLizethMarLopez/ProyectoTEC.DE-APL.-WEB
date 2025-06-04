package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.InstitucionService
    import mx.tecnm.cdmadero.api.entities.Institucion
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("institucion")
    class InstitucionController(val service: InstitucionService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllInstitucion())
            return "/views/InstitucionView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", Institucion())
            return "/formularies/InstitucionForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: Institucion, model: Model): String {
            service.saveInstitucion(entity)
            return "redirect:/institucion/list"
        }
    }
    