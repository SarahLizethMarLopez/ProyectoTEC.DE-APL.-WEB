package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.NotaDeEvolucionService
    import mx.tecnm.cdmadero.api.entities.NotaDeEvolucion
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("notaDeEvolucion")
    class NotaDeEvolucionController(val service: NotaDeEvolucionService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllNotaDeEvolucion())
            return "/views/NotaDeEvolucionView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", NotaDeEvolucion())
            return "/formularies/NotaDeEvolucionForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: NotaDeEvolucion, model: Model): String {
            service.saveNotaDeEvolucion(entity)
            return "redirect:/notaDeEvolucion/list"
        }
    }
    