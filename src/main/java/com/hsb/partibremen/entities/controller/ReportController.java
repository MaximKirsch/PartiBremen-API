package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.report.Report;
import com.hsb.partibremen.entities.model.report.ReportDto;
import com.hsb.partibremen.entities.service.ReportService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReportController extends BaseController {

    public ReportService reportService = new ReportService();

    @PostMapping("report")
    public Report create(@RequestBody ReportDto reportDto) {
        return reportService.create(reportDto);

    }

    @GetMapping("/report")
    public List<Report> findAll() {
        return this.reportService.findAll();
    }

    @GetMapping("/report/{id}")
    public Optional<Report> findOne(@PathVariable String id) {
        return this.reportService.findOne(id);
    }

    @DeleteMapping("/report/{id}")
    public void delete(@PathVariable String id) { this.reportService.delete(id);}


}
