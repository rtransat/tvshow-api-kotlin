package fr.rtransat.tvshowapp.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {
    @RequestMapping(
        value = [
            "/",
            "/{name}"
        ]
    )
    @ResponseBody
    fun hello(@PathVariable name: String?): String {
        if (name == null) {
            return "Hello world!"
        }

        return "Hello ${name}!"
    }
}