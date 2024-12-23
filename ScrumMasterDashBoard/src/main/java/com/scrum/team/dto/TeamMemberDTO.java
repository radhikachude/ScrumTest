package com.scrum.team.dto;

import com.scrum.team.entity.Team;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;
public class TeamMemberDTO {
    private String name;
    private String role;
    private String email;

    public TeamMemberDTO() {
    }
    // Parameterized constructor
    public TeamMemberDTO(String name, String role, String email)
    {
      this.name = name; this.role = role; this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
