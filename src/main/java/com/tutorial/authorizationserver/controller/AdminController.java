package com.tutorial.authorizationserver.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tutorial.authorizationserver.dto.MessageDto;
import com.tutorial.authorizationserver.dto.RoleDto;
import com.tutorial.authorizationserver.service.AdminService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminService;
	
	private boolean showElement = false;

	@GetMapping("/getRoles")
    public String example(Model model) {
        // Retrieve your data (replace this with your actual data retrieval logic)
//        List<RoleDto> myObjects = Arrays.asList(
//                new RoleDto("ROLE_ADMIN", "Active"),
//                new RoleDto("ROLE_USER", "Active"),
//                new RoleDto("ROLE_AUTHOR", "Active")
//        );
		List<RoleDto> myObjects = adminService.getRoles();
        // Add the data to the model
        model.addAttribute("myObjects", myObjects);
        model.addAttribute("showElement", showElement);
        // Return the Thymeleaf template name
        return "admin";
    }
	
	@PostMapping("/toggleElement")
    @ResponseBody
    public String toggleElement() {
        showElement = !showElement;
        return String.valueOf(showElement);
    }
	
	@PostMapping("/addRole")
    @ResponseBody
    public ResponseEntity<MessageDto> addRole(@RequestBody RoleDto dto) {
        adminService.addRole(dto);
        return new ResponseEntity<>(new MessageDto("success"),HttpStatus.OK);
    }
}

