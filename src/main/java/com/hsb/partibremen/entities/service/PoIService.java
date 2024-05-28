package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.exceptions.PoINotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.comment.Comment;
import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.poi.PoIDto;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.repo.PoIRepo;
import com.hsb.partibremen.entities.repo.UserRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PoIService extends BaseService {
    @Autowired
    public PoIRepo poiRepo;
    @Autowired
    public UserRepo userRepo;
    @Autowired
    private UserService userService;

    public List<PoI> findByUserId(String userId) throws UserNotFoundException {
        UUID userUUID = UUID.fromString(userId);
        if (!userRepo.existsById(userUUID)) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
        List<PoI> pois = poiRepo.findByCreatorId(userUUID);
        if (pois.isEmpty()) {
            throw new UserNotFoundException("No POIs found for user ID: " + userId);
        }
        // Sortiere Kommentare für jeden POI
        for (PoI poi : pois) {
            if (poi.getComments() != null) {
                poi.getComments().sort(Comparator.comparing(Comment::getCreatedAt).reversed());
            }
        }
        return pois;
    }


    public PoI create(PoIDto poiDto) throws UserNotFoundException {
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
        poi.setImg(poiDto.getImg());
        return poiRepo.save(poi);
    }

    public Optional<PoI> update(String id, PoIDto poiDto) throws UserNotFoundException {
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
            if (poiDto.getImg() != null) {
                poi.setImg(poiDto.getImg());
            }
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

    public Optional<PoI> findOne(String id) throws PoINotFoundException {
        if(poiRepo.findById(UUID.fromString(id)) != null){
            return poiRepo.findById(UUID.fromString(id));
        }
        throw new PoINotFoundException(id);
    }

    public void delete(String id) {
        poiRepo.deleteById(UUID.fromString(id));
    }
}
