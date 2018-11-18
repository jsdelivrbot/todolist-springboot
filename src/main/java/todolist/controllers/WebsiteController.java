package todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebsiteController {

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", "AS:LDFKMSDF:LKSDFJ");
        return "home";
    }

    @RequestMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("appName", "AS:LDFKMSDF:LKSDFJ");
        return "login";
    }

    @RequestMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("appName", "AS:LDFKMSDF:LKSDFJ");
        return "signup";
    }
}