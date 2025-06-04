package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.InterrogatorioService
    import mx.tecnm.cdmadero.api.entities.Interrogatorio
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("interrogatorio")
    class InterrogatorioController(val service: InterrogatorioService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllInterrogatorio())
            return "/views/InterrogatorioView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", Interrogatorio())
            return "/formularies/InterrogatorioForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: Interrogatorio, model: Model): String {
            service.saveInterrogatorio(entity)
            return "redirect:/interrogatorio/list"
        }
    }
    