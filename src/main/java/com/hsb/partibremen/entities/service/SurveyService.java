package com.hsb.partibremen.entities.service;

import java.util.ArrayList;
import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.model.servey.Survey;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.util.BaseService;

public class SurveyService extends BaseService {
    public ArrayList<Survey> serveyList = new ArrayList<>();

    public void deleteSurvey(String id) {
        Survey surveyToDelete = findOne(id);
        if(surveyToDelete != null) {
            serveyList.remove(surveyToDelete);
        }
    }
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

   

    

    

    

}

