package mx.tecnm.cdmadero.api.controllers

import jakarta.servlet.http.HttpSession
import mx.tecnm.cdmadero.api.entities.LoginData
import mx.tecnm.cdmadero.api.services.PersonalMedicoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class LoginController {

    @Autowired
    lateinit var personalMedicoService: PersonalMedicoService

    @GetMapping("/login")
    fun mostrarLogin(model: Model): String {
        model.addAttribute("loginData", LoginData())
        return "pages/login"
    }

    @PostMapping("/loginform")
    fun procesarLogin(
        @ModelAttribute("loginData") loginData: LoginData,
        model: Model,
        session: HttpSession
    ): String {
        val medico = personalMedicoService.login(loginData.cedula, loginData.contrasena)
        return if (medico != null) {
            session.setAttribute("usuario", medico)
            session.setAttribute("rol", medico.rol) // <-- Aquí se guarda el rol ("ADMIN" o "Medico") -->
            "redirect:/home"
        } else {
            model.addAttribute("loginData", LoginData())
            model.addAttribute("errorCode", "1")
            model.addAttribute("errorMessage", "Cédula o contraseña incorrectos")
            "pages/login"
        }
    }
}