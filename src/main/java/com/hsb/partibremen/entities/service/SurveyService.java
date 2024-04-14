package com.hsb.partibremen.entities.service;

import java.util.ArrayList;
import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.model.servey.Survey;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.util.BaseService;

public class SurveyService extends BaseService {
    public ArrayList<Survey> serveyList = new ArrayList<>();

    public ArrayList<Survey> findAll(){
        return this.serveyList;
    }

    public Survey findOne(String id){
        for (Survey servey : this.serveyList){
            if(servey.id.toString().equals(id)){
                return servey;
            }
        }
        return null;
    }

    public void bewerten(String id, VoteType type, UUID userid) {
        Survey servey = findOne(id);
        if (servey != null) {
            servey.addVote(new Voting(userid, type));
        }
    }

}

