package todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsiteController {

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", "AS:LDFKMSDF:LKSDFJ");
        return "home";
    }
}