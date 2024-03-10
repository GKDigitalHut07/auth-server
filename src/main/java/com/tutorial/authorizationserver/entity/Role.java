package com.tutorial.authorizationserver.entity;

import com.tutorial.authorizationserver.enums.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private String role;
    @Column(name = "role_desc")
    private String roleDesc;
    @Column(name = "is_active")
    private Boolean isActive;

    @Override
    public String getAuthority() {
        return role;
    }
}
