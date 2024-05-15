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
    public PoIRepo poiRepo;
    @Autowired
    private UserService userService;

    public PoI create(PoIDto poiDto) {
        PoI poi = new PoI();
        poi.setTitel(poiDto.getTitel());
        poi.setDescription(poiDto.getDescription());
        poi.setActive(poiDto.getActive());
        poi.setLatitude(poiDto.getLatitude());
        poi.setLongitude(poiDto.getLongitude());
        if(!(userService.findOne(poiDto.getCreatorId())).isPresent()){
            throw new RuntimeException();
        }
        poi.setCreator(userService.findOne(poiDto.getCreatorId()).get());
        return poiRepo.save(poi);
    }

    public Optional<PoI> update(String id, PoIDto poiDto) {
        Optional<PoI> optionalPoI = poiRepo.findById(UUID.fromString(id));
        if (optionalPoI.isPresent()) {
            PoI poi = optionalPoI.get();
            poi.setTitel(poiDto.getTitel());
            poi.setDescription(poiDto.getDescription());
            poi.setActive(poiDto.getActive());
            poi.setLatitude(poiDto.getLatitude());
            poi.setLongitude(poiDto.getLongitude());
            if(!(userService.findOne(poiDto.getCreatorId())).isPresent()){
                throw new RuntimeException();
            }
            poi.setCreator(userService.findOne(poiDto.getCreatorId()).get());
            poiRepo.save(poi);
        }
        return optionalPoI;
    }

    public List<PoI> findAll() {
        return poiRepo.findAll();
    }

    public List<PoI> findOnlyPoIs() {
        List<PoI> allPois = this.findAll();
        for(PoI pois : allPois){
            pois.setComments(null);
            pois.setReports(null);
            pois.setSurveys(null);
            pois.setVotings(null);
        }
        return allPois;
    }

    public Optional<PoI> findOne(String id) {
        return poiRepo.findById(UUID.fromString(id));
    }

    public void delete(String id) {
        poiRepo.deleteById(UUID.fromString(id));
    }
}
