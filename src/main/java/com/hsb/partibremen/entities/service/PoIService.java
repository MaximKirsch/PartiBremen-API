package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.poi.PoIDto;
import com.hsb.partibremen.entities.repo.PoIRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PoIService extends BaseService {
    @Autowired
    private PoIRepo poiRepo;

    @Autowired
    private UserService userService;

    public PoI create(PoIDto poiDto) {
        PoI poi = new PoI();
        poi.setTitel(poiDto.getTitel());
        poi.setDescription(poiDto.getDescription());
        poi.setActive(poiDto.getActive());
        if(!(userService.findOne(poiDto.getCreatorId())).isPresent()){
            throw new RuntimeException();
        }
        poi.setAnswerer((userService.findOne(poiDto.getCreatorId())).get());

        return poiRepo.save(poi);
    }

    public List<PoI> findAll() {
        return poiRepo.findAll();
    }

    public Optional<PoI> findOne(String id) {
        return poiRepo.findById(UUID.fromString(id));
    }

    public void delete(String id) {
        poiRepo.deleteById(UUID.fromString(id));
    }
}
