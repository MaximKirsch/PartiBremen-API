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
            dto.setId(report.getId());  // Setze die ID
            dto.setKommentar(report.getKommentar());
            dto.setTitle(report.getTitle());
            dto.setReporterId(report.getReporter().getId().toString());
            dto.setStatus(report.getStatus());
            if (report.getReportedUser() != null) {
                dto.setReportedUserId(report.getReportedUser().getId().toString());
            }
            if (report.getReportedPoi() != null) {
                dto.setReportedPoiId(report.getReportedPoi().getId().toString());
            }
            if (report.getReportedComment() != null) {
                dto.setReportedCommentId(report.getReportedComment().getId().toString());
            }
            dto.setCreatedAt(report.getCreatedAt());
            dto.setUpdatedAt(report.getUpdatedAt());
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/report/{id}")
    public ReportDto findOne(@PathVariable String id) throws ReportNotFoundException {
        Optional<Report> reportOpt = this.reportService.findOne(id);
        if (reportOpt.isPresent()) {
            Report report = reportOpt.get();
            ReportDto dto = new ReportDto();
            dto.setId(report.getId());  // Setze die ID
            dto.setKommentar(report.getKommentar());
            dto.setTitle(report.getTitle());
            dto.setReporterId(report.getReporter().getId().toString());
            dto.setStatus(report.getStatus());
            if (report.getReportedUser() != null) {
                dto.setReportedUserId(report.getReportedUser().getId().toString());
            }
            if (report.getReportedPoi() != null) {
                dto.setReportedPoiId(report.getReportedPoi().getId().toString());
            }
            if (report.getReportedComment() != null) {
                dto.setReportedCommentId(report.getReportedComment().getId().toString());
            }
            dto.setCreatedAt(report.getCreatedAt());
            dto.setUpdatedAt(report.getUpdatedAt());
            return dto;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Report not found");
        }
    }
    @PutMapping("/report/update/{id}")
    public Report updateReport(@PathVariable String id, @RequestBody ReportDto reportDto) throws UserNotFoundException, PoINotFoundException, CommentNotFoundException {
        return reportService.updateReport(id, reportDto);
    }

    @DeleteMapping("/report/{id}")
    public void delete(@PathVariable String id) {
        this.reportService.delete(id);
    }

    
    @GetMapping("/reports/user/{reportedUserId}")
    public List<Report> findByReportedUserId(@PathVariable String reportedUserId) {
        return reportService.findByReportedUserId(reportedUserId);
    }

    @GetMapping("/reports/comment/{reportedCommentId}")
    public List<Report> findByReportedCommentId(@PathVariable String reportedCommentId) {
        return reportService.findByReportedCommentId(reportedCommentId);
    }

    @GetMapping("/reports/poi/{reportedPoiId}")
    public List<Report> findByReportedPoiId(@PathVariable String reportedPoiId) {
        return reportService.findByReportedPoiId(reportedPoiId);
    }
}
