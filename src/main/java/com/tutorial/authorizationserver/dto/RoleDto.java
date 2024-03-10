package com.tutorial.authorizationserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

	private Long id;
	private String roleName;
	private String status;
	private String roleDesc;
	
	public RoleDto(String roleName, String status, String roleDesc) {
		super();
		this.roleName = roleName;
		this.status = status;
		this.roleDesc = roleDesc;
	}
	
	
}
