package com.hsb.partibremen.entities.controller;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.hsb.partibremen.entities.enums.VoteType;
import com.hsb.partibremen.entities.model.servey.Survey;
import com.hsb.partibremen.entities.model.servey.SurveyDto;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.service.SurveyService;


import com.hsb.partibremen.entities.util.BaseController;

@RestController()

public class SurveyController extends BaseController {
    public SurveyService ServeyService = new SurveyService();

    @PostMapping("servey")
    public Survey create(@RequestBody SurveyDto serveyDto) {
        Survey servey = new Survey();

        servey.setTitel(serveyDto.getTitel());
        servey.setBeschreibung(serveyDto.getBeschreibung());
        servey.setExpiresAt(serveyDto.getExpiresAt());
        servey.setUserId(serveyDto.getUserId());
        ServeyService.serveyList.add(servey);
        return servey;

    }

    @GetMapping("/servey")
    public ArrayList<Survey> findAll() {
        return this.ServeyService.findAll();
    }

    @GetMapping("/servey/{id}")
    public Survey findOne(@PathVariable String id) {
        return this.ServeyService.findOne(id);
    }

    // ToDO: Add absolvieren (Medium noch nicht vorhanden)

    // ToDo: Add bewerten (Bewertung gibt es als eigenes Objekt)
    @PostMapping("/servey/{id}/bewerten{type}/{userid}")
    public void bewerten(@PathVariable String id, @PathVariable VoteType type, @PathVariable UUID userid) {
        this.ServeyService.bewerten(id, type, userid);
    }
}
