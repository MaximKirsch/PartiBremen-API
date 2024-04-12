package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.report.Report;
import com.hsb.partibremen.entities.model.report.ReportDto;
import com.hsb.partibremen.entities.model.servey.Servey;
import com.hsb.partibremen.entities.service.ReportService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ReportController extends BaseController {

    public ReportService reportService = new ReportService();

    @PostMapping("report")
    public Report create(@RequestBody ReportDto reportDto) {
        Report report = new Report();

        report.setKommentar(reportDto.getKommentar());
        report.setTitle(reportDto.getTitle());
        reportService.reportList.add(report);
        return report;

    }

    @GetMapping("/report")
    public ArrayList<Report> findAll() {
        return this.reportService.findAll();
    }

    @GetMapping("/report/{id}")
    public Report findOne(@PathVariable String id) {
        return this.reportService.findOne(id);
    }


}
