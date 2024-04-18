package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.petition.Petition;
import com.hsb.partibremen.entities.model.petition.PetitionDto;
import com.hsb.partibremen.entities.service.PetitionService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PetitionController extends BaseController {
    private PetitionService petitionService = new PetitionService();

    @PostMapping("/petition")
    public Petition create(@RequestBody PetitionDto petitionDto) {
        Petition petition = new Petition();
        petition.setTitel(petitionDto.getTitel());
        petition.setDescription(petitionDto.getDescription());
        petition.setExpireAt(petitionDto.getExpireAt());
        petition.setGoal(petitionDto.getGoal());
        petitionService.petionsList.add(petition);
        return petition;
    }

    @GetMapping("/petition")
    public ArrayList<Petition> findAll() {
        return petitionService.findAll();
    }

    @GetMapping("/petition/{id}")
    public Petition findOne(@PathVariable String id) {
        return petitionService.findOne(id);
    }

    @PutMapping("/petition/{id}")
    public Petition update(@PathVariable String id, @RequestBody PetitionDto petitionDto) {
        Petition petition = petitionService.findOne(id);
        if (petition != null) {
            petition.setTitel(petitionDto.getTitel());
            petition.setDescription(petitionDto.getDescription());
            petition.setExpireAt(petitionDto.getExpireAt());
            petition.setGoal(petitionDto.getGoal());
        }
        return petition;
    }

    @DeleteMapping("/petition/{id}")
    public void delete(@PathVariable String id) {
        petitionService.delete(id);
    }
}
