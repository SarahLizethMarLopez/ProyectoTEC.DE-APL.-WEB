package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.SignosVitalesService
    import mx.tecnm.cdmadero.api.entities.SignosVitales
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("signosVitales")
    class SignosVitalesController(val service: SignosVitalesService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllSignosVitales())
            return "/views/SignosVitalesView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", SignosVitales())
            return "/formularies/SignosVitalesForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: SignosVitales, model: Model): String {
            service.saveSignosVitales(entity)
            return "redirect:/signosVitales/list"
        }
    }
    