package phonedirectory.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import phonedirectory.model.Contact;
import phonedirectory.service.ContactService;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model){
        return "index";
    }



}

