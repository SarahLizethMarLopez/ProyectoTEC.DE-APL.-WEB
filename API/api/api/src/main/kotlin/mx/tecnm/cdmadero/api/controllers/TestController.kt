package mx.tecnm.cdmadero.api.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("test")
class TestController() {

    @GetMapping
    fun getXModel(model: Model): String { // borrar
        return "/pages/acerca-de"
    }
//
//    @GetMapping("/aside-layout")
//    fun getX2Model(model: Model): String { // borrar
////        model.addAttribute("items",  Items )
//        return "layouts/asideLayout"
//    }


/*
    @GetMapping("/historial-recetas")
    fun getX3Model(model: Model): String { // borrar
        return "pages/pacientes/historial-de-recetas"
    }

    @GetMapping("/casos-notificables")
    fun getX4Model(model: Model): String { // borrar
        return "pages/pacientes/casos-notificables"
    }
    @GetMapping("/historial-auxiliar")
    fun getX5Model(model: Model): String { // borrar
        return "pages/pacientes/historial-auxiliar"
    }
     @GetMapping("/home")
   fun getHomeModel(model: Model): String { // borrar
       return "pages/home"
   }
   @GetMapping("/historial-de-alerta-sanitaria")
    fun getX6Model(model: Model): String { // borrar
        return "pages/pacientes/historial-de-alerta-sanitaria"
    }

    */





//    @GetMapping("/acerca")
//    fun getYModel(model: Model): String { // borrar
//
//        return "pages/acerca-de"
//    }
//
//    @GetMapping("/login")
//    fun getLogModel(model: Model): String { // borrar
//        return "pages/login"
//    }
//
//    @GetMapping("/register")
//    fun getRegModel(model: Model): String { // borrar
//        return "pages/register"
//    }
}