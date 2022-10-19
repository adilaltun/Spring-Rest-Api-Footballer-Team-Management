package com.works.services;

import com.works.entities.Team;
import com.works.repositories.FootballerRepository;
import com.works.repositories.TeamRepository;
import com.works.util.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamService {

    final TeamRepository teamRepository;
    final FootballerRepository footballerRepository;
    public TeamService(TeamRepository teamRepository, FootballerRepository footballerRepository) {
        this.teamRepository = teamRepository;
        this.footballerRepository = footballerRepository;
    }

    //team save
    public ResponseEntity save(Team team){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        try {
            boolean status = footballerRepository.existsByFidEquals(team.getFid());
            if (!status){
                hm.put(REnum.status,false);
                hm.put(REnum.message,"Böyle bir futbolcu yok.");
                hm.put(REnum.result,team);
            }else {
                teamRepository.save(team);
                hm.put(REnum.status,true);
                hm.put(REnum.message,"Kayıt işlemi başarılıdır.");
                hm.put(REnum.result,team);
            }

        }catch (Exception ex){
            hm.put(REnum.status,false);
            hm.put(REnum.message,"Bu futbolcu daha önce bir takıma atanmıştır.");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //team list
    public ResponseEntity list (){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        List<Team> findTeams = teamRepository.findAll();
        hm.put(REnum.status,true);
        hm.put(REnum.result,findTeams);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
