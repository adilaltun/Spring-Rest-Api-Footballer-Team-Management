package com.works.restcontrollers;

import com.works.entities.Footballer;
import com.works.entities.Team;
import com.works.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamRestController {

    final TeamService teamService;

    @PostMapping("/save")
    public ResponseEntity save (@Valid @RequestBody Team team){
        return teamService.save(team);
    }

    @GetMapping("/list")
    public ResponseEntity list (){
        return teamService.list();
    }

}
