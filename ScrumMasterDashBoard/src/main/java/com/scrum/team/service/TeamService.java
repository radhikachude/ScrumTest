package com.scrum.team.service;

import com.scrum.team.entity.Team;

import com.scrum.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(Team team) {
        team.getTeamMembers().forEach(member -> member.setTeam(team));
        Team saveTeam= teamRepository.save(team);

       // return teamRepository.save(team);
        return saveTeam;

    }
    /*public Team updateTeam(long teamId, Team team) {
        return teamRepository.findById(teamId)
                .map(existingTeam -> {
                    existingTeam.setName(team.getName(),
                    existingTeam.setDescription(team.getDescription())
                 Team teamUpdate=   teamRepository.save(existingTeam);
                 return teamUpdate;
                    //return teamRepository.save(existingTeam);
                })
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }*/

    public Team updateTeam(long teamId, Team team) {
        return teamRepository.findById(teamId)
                .map(existingTeam -> {
                    existingTeam.setName(team.getName());
                    existingTeam.setDescription(team.getDescription());
                    Team teamUpdate= teamRepository.save(existingTeam);
                    return teamUpdate;
                    //return teamRepository.save(existingTeam);
                })
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public void deleteTeam(long teamId) {
        teamRepository.deleteById(teamId);
    }

    public List<Team> getAllTeam() {
     return teamRepository.findAll();
    }
}
