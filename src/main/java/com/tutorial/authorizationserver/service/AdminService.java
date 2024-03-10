package com.tutorial.authorizationserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.authorizationserver.dto.RoleDto;
import com.tutorial.authorizationserver.entity.Role;
import com.tutorial.authorizationserver.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
	
	private final RoleRepository roleRepository;
	
	public Role addRole(RoleDto dto) {
		Role role = new Role();
		role.setIsActive(dto.getStatus().equalsIgnoreCase("Active")?true:false);
		role.setRole(dto.getRoleName());
		role.setRoleDesc(dto.getRoleDesc());
		return roleRepository.save(role);
	}
	
	public List<RoleDto> getRoles(){
		List<Role> roles = roleRepository.findAll();
		return roles.stream().map(en -> new RoleDto(en.getRole(), en.getIsActive()?"Active":"Disabled",en.getRoleDesc())).toList();
	}

}
