package com.hsb.partibremen.entities.controller;
import java.util.ArrayList;
import java.util.UUID;

import com.hsb.partibremen.entities.enums.VoteType;
import org.springframework.web.bind.annotation.*;

import com.hsb.partibremen.entities.model.servey.Servey;
import com.hsb.partibremen.entities.model.servey.ServeyDto;
import com.hsb.partibremen.entities.service.ServeyService;


import com.hsb.partibremen.entities.util.BaseController;

@RestController()

public class ServeyController extends BaseController {
    public ServeyService serveyService = new ServeyService();

    @PostMapping("servey")
    public Servey create(@RequestBody ServeyDto serveyDto) {
        Servey servey = new Servey();

        servey.setTitel(serveyDto.getTitel());
        servey.setBeschreibung(serveyDto.getBeschreibung());
        servey.setExpiresAt(serveyDto.getExpiresAt());
        servey.setUserId(serveyDto.getUserId());
        serveyService.serveyList.add(servey);
        return servey;

    }

    @GetMapping("/servey")
    public ArrayList<Servey> findAll() {
        return this.serveyService.findAll();
    }

    @GetMapping("/servey/{id}")
    public Servey findOne(@PathVariable String id) {
        return this.serveyService.findOne(id);
    }

    // ToDO: Add absolvieren (Medium noch nicht vorhanden)

    // ToDo: Add bewerten (Bewertung gibt es als eigenes Objekt)
    @PostMapping("/servey/{id}/bewerten{type}/{userid}")
    public void bewerten(@PathVariable String id, @PathVariable VoteType type, @PathVariable UUID userid) {
        this.serveyService.bewerten(id, type, userid);
    }
}
