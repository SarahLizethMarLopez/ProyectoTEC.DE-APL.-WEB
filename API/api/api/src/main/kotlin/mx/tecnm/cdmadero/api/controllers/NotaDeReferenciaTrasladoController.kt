package mx.tecnm.cdmadero.api.controllers

import mx.tecnm.cdmadero.api.services.NotaDeReferenciaTrasladoService
import mx.tecnm.cdmadero.api.entities.NotaDeReferenciaTraslado
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("notaDeReferenciaTraslado")
class NotaDeReferenciaTrasladoController(val service: NotaDeReferenciaTrasladoService) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllNotaDeReferenciaTraslado())
        return "/views/NotaDeReferenciaTrasladoView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", NotaDeReferenciaTraslado())
        return "/formularies/NotaDeReferenciaTrasladoForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: NotaDeReferenciaTraslado, model: Model): String {
        service.saveNotaDeReferenciaTraslado(entity)
        return "redirect:/notaDeReferenciaTraslado/list"
    }
}
    