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
            //fixed it for you :) also it's "survey" (you forgot the second bracket in the if statement body)
            servey.addVote(new Voting(userid, type));
        }
    }

}

