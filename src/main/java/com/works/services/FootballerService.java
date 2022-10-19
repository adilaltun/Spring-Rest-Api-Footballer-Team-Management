package com.works.services;

import com.works.entities.Footballer;
import com.works.repositories.FootballerRepository;
import com.works.util.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FootballerService {

    final FootballerRepository footballerRepository;

    public FootballerService(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    //footballer save
    public ResponseEntity save(Footballer footballer){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        try {
            footballerRepository.save(footballer);
            hm.put(REnum.status,true);
            hm.put(REnum.message,"Kayıt işlemi başarılıdır.");
            hm.put(REnum.result,footballer);
        }catch (Exception ex){
            hm.put(REnum.status,false);
            hm.put(REnum.message,"Bu mail ile daha önce kayıt yapılmıştır.");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //footballer allSave
    public ResponseEntity allSave(List<Footballer> footballers){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        for (Footballer  item : footballers ){
            footballerRepository.save(item);
        }
        hm.put(REnum.status,true);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //footballer list
    public ResponseEntity list (){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        List<Footballer> listFootballer = footballerRepository.findAll();
        hm.put(REnum.status,true);
        hm.put(REnum.result,listFootballer);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //footballer delete
    public ResponseEntity delete (String fid){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        try {
            int iid = Integer.parseInt(fid);
            footballerRepository.deleteById(iid);
            hm.put(REnum.status,true);
            hm.put(REnum.message,"Silme işlemi gerçekleştirildi.");
        }catch (Exception ex){
            hm.put(REnum.status,false);
            hm.put(REnum.error,ex.getMessage());
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    //footballer update
    public ResponseEntity update (Footballer footballer){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        Optional<Footballer> optionalFootballer = footballerRepository.findById(footballer.getFid());
        if (optionalFootballer.isPresent()){
            Footballer footballer1 = footballerRepository.saveAndFlush(footballer);
            hm.put(REnum.status,true);
            hm.put(REnum.result,footballer1);
        }else {
            hm.put(REnum.status,false);
            hm.put(REnum.message,"Böyle bir futbolcu yoktur.");
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
