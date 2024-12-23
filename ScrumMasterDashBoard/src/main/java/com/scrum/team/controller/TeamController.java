package com.scrum.team.controller;

import com.scrum.team.dto.TeamMemberDTO;
import com.scrum.team.entity.Team;
import com.scrum.team.entity.TeamMember;
import com.scrum.team.service.TeamMemberService;
import com.scrum.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamMemberService teamMemberService;

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping
    public List<Team> getAllTeam() {
        return teamService.getAllTeam();
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable long id, @RequestBody Team team) {
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable long id) {
        teamService.deleteTeam(id);
    }

    /*@PostMapping("/{id}/members")
    public TeamMember addMemberToTeam(@PathVariable long id, @RequestBody TeamMember member) {
        return teamMemberService.addMemberToTeam(id, member);
    }*/

    @PutMapping("/members/{id}")
    public TeamMember updateMember(@PathVariable long id, @RequestBody TeamMember member) {
        return teamMemberService.updateMember(id, member);
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable long id) {

        teamMemberService.deleteMember(id);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<TeamMemberDTO> getTeamMemberById(@PathVariable long id) {
        TeamMemberDTO teamMember = teamMemberService.findById(id);
        return ResponseEntity.ok(teamMember);
    }
}
