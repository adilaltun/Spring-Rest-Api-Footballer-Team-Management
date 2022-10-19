package com.works.restcontrollers;

import com.works.repositories.FootTeamRepository;
import com.works.util.TEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamsCreateRestController {

    final FootTeamRepository footTeamRepository;

    @GetMapping("/teamCreate")
    public ResponseEntity teamCreate (@RequestParam TEnum teams){
        /* ----- a ve b takımlarını tek ekranda görüntülemek için -----
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("A",footTeamRepository.teamsAsil(0));
        hm.put("B",footTeamRepository.teamsAsil(1));*/
        return new ResponseEntity(footTeamRepository.teamsAsil( teams.ordinal() ) ,HttpStatus.OK);
    }

    @GetMapping("/backUpCreate")
    public ResponseEntity backUpCreate (@RequestParam TEnum teams){
        return new ResponseEntity(footTeamRepository.teamsYedek( teams.ordinal() ) , HttpStatus.OK);
    }
}
