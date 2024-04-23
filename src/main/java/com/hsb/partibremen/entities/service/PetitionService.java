package com.hsb.partibremen.entities.service;
import com.hsb.partibremen.entities.model.petition.Petition;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.Iterator;


@Service
public class PetitionService extends BaseService {

    public ArrayList<Petition> petionsList = new ArrayList<>();

    public ArrayList<Petition> findAll(){
        return this.petionsList;
    }

    public Petition findOne(String id) {
        for (Petition petition : this.petionsList) {
            if (petition.id.toString().equals(id)) {
                return petition;
            }
        }
        return null;
    }

    public void delete(String id) {
        Iterator<Petition> iterator = petionsList.iterator();
        while (iterator.hasNext()) {
            Petition petition = iterator.next();
            if (petition.id.toString().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
}
