package com.tutorial.authorizationserver.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tutorial.authorizationserver.dto.RoleDto;
import com.tutorial.authorizationserver.service.AdminService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class SignupController {
	
	private final AdminService adminService;
	
	
	@GetMapping("/auth/signup")
    public String showSignupPage(Model model) {
		List<RoleDto> roles = adminService.getRoles();
		model.addAttribute("roles",roles);
        return "signup";
    }
	
	@GetMapping("/auth/login")
    public String redirectLoginPage() {
        return "redirect:/login";
    }
}
