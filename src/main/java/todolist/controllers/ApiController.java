package todolist.controllers;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ApiController {


    @PutMapping("/blah")
    public void foo() {
        System.out.println( "BLAHHHHHHHH");
    }

}