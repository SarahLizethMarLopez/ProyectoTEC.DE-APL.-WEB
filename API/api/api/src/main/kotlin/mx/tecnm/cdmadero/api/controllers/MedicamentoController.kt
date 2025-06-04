package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.MedicamentoService
    import mx.tecnm.cdmadero.api.entities.Medicamento
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("medicamento")
    class MedicamentoController(val service: MedicamentoService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllMedicamento())
            return "/views/MedicamentoView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", Medicamento())
            return "/formularies/MedicamentoForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: Medicamento, model: Model): String {
            service.saveMedicamento(entity)
            return "redirect:/medicamento/list"
        }
    }
    