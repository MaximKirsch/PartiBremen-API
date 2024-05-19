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
import java.util.stream.Collectors;

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
    public List<ReportDto> findAll() {
        return this.reportService.findAll().stream().map(report -> {
            ReportDto dto = new ReportDto();
            dto.setKommentar(report.getKommentar());
            dto.setTitle(report.getTitle());
            dto.setReporterId(report.getReporter().id.toString());
            if (report.getReportedUser() != null) {
                dto.setReportedUserId(report.getReportedUser().id.toString());
            }
            if (report.getReportedPoi() != null) {
                dto.setReportedPoiId(report.getReportedPoi().id.toString());
            }
            if (report.getReportedComment() != null) {
                dto.setReportedCommentId(report.getReportedComment().id.toString());
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/report/{id}")
    public ReportDto findOne(@PathVariable String id) throws ReportNotFoundException {
        Optional<Report> reportOpt = this.reportService.findOne(id);
        if (reportOpt.isPresent()) {
            Report report = reportOpt.get();
            ReportDto dto = new ReportDto();
            dto.setKommentar(report.getKommentar());
            dto.setTitle(report.getTitle());
            dto.setReporterId(report.getReporter().id.toString());
            if (report.getReportedUser() != null) {
                dto.setReportedUserId(report.getReportedUser().id.toString());
            }
            if (report.getReportedPoi() != null) {
                dto.setReportedPoiId(report.getReportedPoi().id.toString());
            }
            if (report.getReportedComment() != null) {
                dto.setReportedCommentId(report.getReportedComment().id.toString());
            }
            return dto;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Report not found");
        }
    }

    @DeleteMapping("/report/{id}")
    public void delete(@PathVariable String id) {
        this.reportService.delete(id);
    }
}
