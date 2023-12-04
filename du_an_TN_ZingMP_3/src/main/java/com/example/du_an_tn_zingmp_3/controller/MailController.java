package com.example.du_an_tn_zingmp_3.controller;

import com.example.du_an_tn_zingmp_3.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin("*")
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private IMailService mailService;
    @GetMapping("/active/{email}")
    public RedirectView active(@PathVariable String email) {
        if (mailService.activeAccount(email)) {
            return new RedirectView("http://localhost:3000/login");
        }
        return new RedirectView("http://localhost:3000/404");
    }
}
