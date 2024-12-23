package com.scrum.team.service;

import com.scrum.team.dto.TeamMemberDTO;
import com.scrum.team.entity.Team;
import com.scrum.team.entity.TeamMember;
import com.scrum.team.exception.TeamMemberNotFoundException;
import com.scrum.team.repository.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class TeamMemberService {
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    public TeamMember addMemberToTeam(long teamId, TeamMember member) {
        member.setId(teamId);
        TeamMember saveTeamMember = teamMemberRepository.save(member);
       // return teamMemberRepository.save(member);
        return saveTeamMember;
    }

    public TeamMember updateMember(long memberId, TeamMember member) {
        return teamMemberRepository.findById(memberId)
                .map(existingMember -> {
                    existingMember.setName(member.getName());
                    existingMember.setRole(member.getRole());
                    existingMember.setEmail(member.getEmail());
                    TeamMember updatedTeamMember=teamMemberRepository.save(existingMember);
                   // return teamMemberRepository.save(existingMember);
                   return updatedTeamMember;
                })
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public void deleteMember(long memberId) {
        teamMemberRepository.deleteById(memberId);

    }

public TeamMemberDTO findById(long id) {
    TeamMember teamMember = teamMemberRepository.findById(id)
            .orElseThrow(() -> new TeamMemberNotFoundException("Team Member with ID " + id + " not found."));
    return mapToDTO(teamMember);
}
private TeamMemberDTO mapToDTO(TeamMember teamMember) {
    return new TeamMemberDTO(teamMember.getName(),teamMember.getRole(), teamMember.getEmail() );
}

}
