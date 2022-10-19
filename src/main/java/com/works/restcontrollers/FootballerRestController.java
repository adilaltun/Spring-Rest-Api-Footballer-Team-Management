package com.works.restcontrollers;

import com.works.entities.Footballer;
import com.works.services.FootballerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/footballer")
public class FootballerRestController {

    final FootballerService footballerService;

    public FootballerRestController(FootballerService footballerService) {
        this.footballerService = footballerService;
    }

    @PostMapping("/save")
    public ResponseEntity save (@Valid @RequestBody Footballer footballer){
        return footballerService.save(footballer);
    }

    @PostMapping("/allSave")
    public ResponseEntity allSave (@Valid @RequestBody List<Footballer> footballers){
        return footballerService.allSave(footballers);
    }

    @GetMapping("/list")
    public ResponseEntity list (){
        return footballerService.list();
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete (@RequestParam String fid){
        return footballerService.delete(fid);
    }

    @PutMapping("/update")
    public ResponseEntity update (@RequestBody Footballer footballer){
        return footballerService.update(footballer);
    }
}
