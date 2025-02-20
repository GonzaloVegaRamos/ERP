package com.empresa.erp.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashboardController {

    @GetMapping
    public String mostrarDashboard(Model model) {
        model.addAttribute("mensaje", "Bienvenido al Panel de Control");
        return "dashboard";
    }
}

