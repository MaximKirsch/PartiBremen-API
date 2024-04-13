package com.hsb.partibremen.entities.service;

import java.util.ArrayList;
import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.model.servey.Servey;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.util.BaseService;

public class ServeyService extends BaseService {
    public ArrayList<Servey> serveyList = new ArrayList<>();

    public ArrayList<Servey> findAll(){
        return this.serveyList;
    }

    public Servey findOne(String id){
        for (Servey servey : this.serveyList){
            if(servey.id.toString().equals(id)){
                return servey;
            }
        }
        return null;
    }

    public void bewerten(String id, VoteType type, UUID userid) {
        Servey servey = findOne(id);
        if (servey != null) {
            //Throws at me a error but function with no problem i don´t know whats wron. Delete that comment if it shows at you no problem
            servey.addVote(new Voting(userid, type));
        }
    }

}

