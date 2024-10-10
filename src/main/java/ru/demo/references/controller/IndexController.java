package ru.demo.references.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.demo.references.service.EmployeeService;

@Controller
@AllArgsConstructor
public class IndexController {

    private final EmployeeService referenceService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("employees", referenceService.findAll());
        return "index";
    }
}
