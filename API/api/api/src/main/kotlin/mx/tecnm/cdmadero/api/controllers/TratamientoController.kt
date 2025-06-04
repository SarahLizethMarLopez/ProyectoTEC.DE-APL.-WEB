package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.TratamientoService
    import mx.tecnm.cdmadero.api.entities.Tratamiento
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("tratamiento")
    class TratamientoController(val service: TratamientoService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllTratamiento())
            return "/views/TratamientoView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", Tratamiento())
            return "/formularies/TratamientoForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: Tratamiento, model: Model): String {
            service.saveTratamiento(entity)
            return "redirect:/tratamiento/list"
        }
    }
    