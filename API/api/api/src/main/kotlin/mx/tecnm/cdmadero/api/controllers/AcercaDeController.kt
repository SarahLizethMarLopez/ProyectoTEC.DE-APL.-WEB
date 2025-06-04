package mx.tecnm.cdmadero.api.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/acerca-de")
class AcercaDeController {

    @GetMapping
    fun mostrarAcerdaDe(): String {
        return "pages/acerca-de"
    }
}
