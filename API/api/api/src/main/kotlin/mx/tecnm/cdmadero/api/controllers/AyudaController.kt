package mx.tecnm.cdmadero.api.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AyudaController {

    @GetMapping("/ayuda")
    fun mostrarAyuda(): String {
        return "pages/help"
    }
}
