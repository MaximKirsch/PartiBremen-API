package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.exceptions.PetitionNotFoundException;
import com.hsb.partibremen.entities.exceptions.PoINotFoundException;
import com.hsb.partibremen.entities.model.petition.Petition;
import com.hsb.partibremen.entities.model.petition.PetitionDto;
import com.hsb.partibremen.entities.service.PetitionService;
import com.hsb.partibremen.entities.service.PoIService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class PetitionController extends BaseController {
    @Autowired
    private PetitionService petitionService;
    @Autowired
    public PoIService poiService;

    @PostMapping("/petition")
    public Petition create(@RequestBody PetitionDto petitionDto) throws PoINotFoundException {;
        return petitionService.create(petitionDto);
    }

    @GetMapping("/petition")
    public List<Petition> findAll() {
        return petitionService.findAll();
    }

    @GetMapping("/petition/{id}")
    public Optional<Petition> findOne(@PathVariable String id) {
        try{
            return petitionService.findOne(id);
        } catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Petition not found", ex);
        }

    }

    @PutMapping("/petition/{id}")
    public Petition update(@PathVariable String id, @RequestBody PetitionDto petitionDto) throws PoINotFoundException, PetitionNotFoundException {
        if (!this.petitionService.findOne(id).isPresent()) {
            Petition petition = this.petitionService.findOne(id).get();
            petition.setTitel(petitionDto.getTitel());
            petition.setDescription(petitionDto.getDescription());
            petition.setExpireAt(petitionDto.getExpireAt());
            petition.setGoal(petitionDto.getGoal());
            if(!this.poiService.findOne(petitionDto.getPoiId()).isPresent()){
                throw new RuntimeException();
            }
            petition.setPoi(this.poiService.findOne(petitionDto.getPoiId()).get());
            return petitionService.petitionRepo.save(petition);
        }
        return new Petition();
    }

    @DeleteMapping("/petition/{id}")
    public void delete(@PathVariable String id) {
        petitionService.delete(id);
    }

    @GetMapping("/petition/poi/{poiId}")
    public List<Petition> findByPOIId(@PathVariable String poiId) {
        return petitionService.findByPoiId(poiId);
    }
}
