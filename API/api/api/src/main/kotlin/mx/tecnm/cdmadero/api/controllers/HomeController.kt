package mx.tecnm.cdmadero.api.controllers

import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/home")
    fun mostrarHome(model: Model, session: HttpSession): String {
        val rol = session.getAttribute("rol") as? String ?: "INVITADO"
        model.addAttribute("rol", rol)
        return "pages/home"
    }
}