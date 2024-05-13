package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.exceptions.CommentNotFoundException;
import com.hsb.partibremen.entities.exceptions.PoINotFoundException;
import com.hsb.partibremen.entities.exceptions.ReportNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.report.Report;
import com.hsb.partibremen.entities.model.report.ReportDto;
import com.hsb.partibremen.entities.service.ReportService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ReportController extends BaseController {

    @Autowired
    public ReportService reportService;

    @PostMapping("report")
    public Report create(@RequestBody ReportDto reportDto) throws UserNotFoundException, PoINotFoundException, CommentNotFoundException {
        System.out.println(reportDto.getReportedCommentId());
        System.out.println(reportDto.getReporterId());
        System.out.println(reportDto.getReportedPoiId());
        System.out.println(reportDto.getTitle());

        return reportService.create(reportDto);

    }

    @GetMapping("/report")
    public List<Report> findAll() {
        return this.reportService.findAll();
    }

    @GetMapping("/report/{id}")
    public Optional<Report> findOne(@PathVariable String id) {
        try{
            return this.reportService.findOne(id);
        } catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Report not found", ex);
        }

    }

    @DeleteMapping("/report/{id}")
    public void delete(@PathVariable String id) { this.reportService.delete(id);}


}
