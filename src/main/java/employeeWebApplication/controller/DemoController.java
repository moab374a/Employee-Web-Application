package employeeWebApplication.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;


@Controller
public class DemoController {
    // Creat a maping for "/hello"

    @GetMapping("/hello")
    public String sayHello(Model model)
    {
        model.addAttribute("theDate" , new java.util.Date());
        return "helloworld";
    }
}
