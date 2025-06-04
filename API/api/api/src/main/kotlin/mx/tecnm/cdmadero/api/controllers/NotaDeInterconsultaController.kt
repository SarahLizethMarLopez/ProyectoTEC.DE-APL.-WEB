package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.NotaDeInterconsultaService
    import mx.tecnm.cdmadero.api.entities.NotaDeInterconsulta
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("notaDeInterconsulta")
    class NotaDeInterconsultaController(val service: NotaDeInterconsultaService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllNotaDeInterconsulta())
            return "/views/NotaDeInterconsultaView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", NotaDeInterconsulta())
            return "/formularies/NotaDeInterconsultaForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: NotaDeInterconsulta, model: Model): String {
            service.saveNotaDeInterconsulta(entity)
            return "redirect:/notaDeInterconsulta/list"
        }
    }
    