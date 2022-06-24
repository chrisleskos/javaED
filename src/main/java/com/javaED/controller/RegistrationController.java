package com.javaED.controller;

import com.javaED.model.account.RegistrationRequest;
import com.javaED.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String register(RegistrationRequest request) {
        registrationService.register(request);
        return "confirmation_sent";
    }

    @GetMapping(path = "confirm")
    public RedirectView confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return new RedirectView("http://localhost:8091/login");
    }
}
