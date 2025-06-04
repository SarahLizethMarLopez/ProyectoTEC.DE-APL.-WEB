package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.InstalacionPersonalMedicoService
    import mx.tecnm.cdmadero.api.entities.InstalacionPersonalMedico
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("instalacionPersonalMedico")
    class InstalacionPersonalMedicoController(val service: InstalacionPersonalMedicoService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllInstalacionPersonalMedico())
            return "/views/InstalacionPersonalMedicoView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", InstalacionPersonalMedico())
            return "/formularies/InstalacionPersonalMedicoForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: InstalacionPersonalMedico, model: Model): String {
            service.saveInstalacionPersonalMedico(entity)
            return "redirect:/instalacionPersonalMedico/list"
        }
    }
    