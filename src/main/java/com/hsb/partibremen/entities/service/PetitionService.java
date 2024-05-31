package com.hsb.partibremen.entities.service;
import com.hsb.partibremen.entities.exceptions.PetitionNotFoundException;
import com.hsb.partibremen.entities.exceptions.PoINotFoundException;
import com.hsb.partibremen.entities.model.petition.Petition;
import com.hsb.partibremen.entities.model.petition.PetitionDto;
import com.hsb.partibremen.entities.repo.PetitionRepo;
import com.hsb.partibremen.entities.repo.PoIRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PetitionService extends BaseService {
    @Autowired
    public PoIRepo poiRepo;
    @Autowired
    public PetitionRepo petitionRepo;
    @Autowired
    public PoIService poiService;

    public Petition create(PetitionDto petitionDto) throws PoINotFoundException {
        Petition petition = new Petition();
        petition.setTitel(petitionDto.getTitel());
        petition.setDescription(petitionDto.getDescription());
        petition.setExpireAt(petitionDto.getExpireAt());
        petition.setGoal(petitionDto.getGoal());

        if(!this.poiService.findOne(petitionDto.getPoiId()).isPresent()){
            throw new RuntimeException();
        }
        petition.setPoi(this.poiService.findOne(petitionDto.getPoiId()).get());

        return this.petitionRepo.save(petition);
    }

    public List<Petition> findAll(){
        return this.petitionRepo.findAll();
    }

    public Optional<Petition> findOne(String id) throws PetitionNotFoundException {
        if(this.petitionRepo.findById(UUID.fromString(id)) != null){
            return this.petitionRepo.findById(UUID.fromString(id));
        }
        throw new PetitionNotFoundException("Petiton not found with ID: " + id);
    }

    public void delete(String id) {
        this.petitionRepo.deleteById(UUID.fromString(id));
    }

    public List<Petition> findByPoiId(String poiId) throws PetitionNotFoundException, PoINotFoundException {
        UUID poiUUID = UUID.fromString(poiId);
        if(!poiRepo.existsById(poiUUID))
        {
            throw new PoINotFoundException("No Poi found for poi Id: " + poiId);
        }
        List<Petition> petitions = petitionRepo.findByPoiId(poiUUID);
        if(petitions.isEmpty())
        {
            throw new PetitionNotFoundException("No Petiton found for poi Id: " + poiId);
        }
        return petitions;
    }
}
