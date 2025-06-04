package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.MedicacionService
    import mx.tecnm.cdmadero.api.entities.Medicacion
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("medicacion")
    class MedicacionController(val service: MedicacionService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllMedicacion())
            return "/views/MedicacionView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", Medicacion())
            return "/formularies/MedicacionForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: Medicacion, model: Model): String {
            service.saveMedicacion(entity)
            return "redirect:/medicacion/list"
        }
    }
    