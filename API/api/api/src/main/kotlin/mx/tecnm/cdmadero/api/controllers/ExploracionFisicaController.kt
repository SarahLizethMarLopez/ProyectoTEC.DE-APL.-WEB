package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.ExploracionFisicaService
    import mx.tecnm.cdmadero.api.entities.ExploracionFisica
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("exploracionFisica")
    class ExploracionFisicaController(val service: ExploracionFisicaService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllExploracionFisica())
            return "/views/ExploracionFisicaView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", ExploracionFisica())
            return "/formularies/ExploracionFisicaForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: ExploracionFisica, model: Model): String {
            service.saveExploracionFisica(entity)
            return "redirect:/exploracionFisica/list"
        }
    }
    