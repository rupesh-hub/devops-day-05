package com.alfarays.message.controller;

import com.alfarays.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MessageService messageService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", messageService.messageById(1L));
        return "home";
    }
}