package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.InstalacionService
    import mx.tecnm.cdmadero.api.entities.Instalacion
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("instalacion")
    class InstalacionController(val service: InstalacionService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllInstalacion())
            return "/views/InstalacionView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", Instalacion())
            return "/formularies/InstalacionForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: Instalacion, model: Model): String {
            service.saveInstalacion(entity)
            return "redirect:/instalacion/list"
        }
    }
    