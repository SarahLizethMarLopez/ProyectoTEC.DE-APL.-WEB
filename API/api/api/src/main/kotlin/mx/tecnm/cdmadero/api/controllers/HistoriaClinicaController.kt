package mx.tecnm.cdmadero.api.controllers

    import mx.tecnm.cdmadero.api.services.HistoriaClinicaService
    import mx.tecnm.cdmadero.api.entities.HistoriaClinica
    import org.springframework.stereotype.Controller
    import org.springframework.ui.Model
    import org.springframework.web.bind.annotation.*

    @Controller
    @RequestMapping("historiaClinica")
    class HistoriaClinicaController(val service: HistoriaClinicaService) {

        @GetMapping("/list")
        fun getAll(model: Model): String {
            model.addAttribute("entities", service.findAllHistoriaClinica())
            return "/views/HistoriaClinicaView"
        }

        @GetMapping("/form")
        fun getForm(model: Model): String {
            model.addAttribute("entity", HistoriaClinica())
            return "/formularies/HistoriaClinicaForm"
        }

        @PostMapping("/new")
        fun create(@ModelAttribute entity: HistoriaClinica, model: Model): String {
            service.saveHistoriaClinica(entity)
            return "redirect:/historiaClinica/list"
        }
    }
    