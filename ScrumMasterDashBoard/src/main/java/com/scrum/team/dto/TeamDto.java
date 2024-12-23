package com.scrum.team.dto;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private String name;
    private String description;
    @OneToMany(mappedBy = "team")
    private List<TeamMemberDTO> teamMembersDto;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TeamMemberDTO> getTeamMembersDto() {
        return teamMembersDto;
    }

    public void setTeamMembersDto(List<TeamMemberDTO> teamMembersDto) {
        this.teamMembersDto = teamMembersDto;
    }
}