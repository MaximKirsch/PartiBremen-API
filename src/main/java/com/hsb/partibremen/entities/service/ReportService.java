package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.enums.ReportStatus;
import com.hsb.partibremen.entities.exceptions.CommentNotFoundException;
import com.hsb.partibremen.entities.exceptions.PoINotFoundException;
import com.hsb.partibremen.entities.exceptions.ReportNotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.report.Report;
import com.hsb.partibremen.entities.model.report.ReportDto;
import com.hsb.partibremen.entities.repo.ReportRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReportService extends BaseService {
    @Autowired
    public ReportRepo reportRepo;
    @Autowired
    public UserService userService;
    @Autowired
    public PoIService poIService;
    @Autowired
    public CommentService commentService;

    public Report create(ReportDto reportDto) throws UserNotFoundException, PoINotFoundException, CommentNotFoundException {
        Report report = new Report();
        report.setTitle(reportDto.getTitle());
        report.setStatus(reportDto.getStatus() != null ? reportDto.getStatus() : ReportStatus.Pending);
        report.setKommentar(reportDto.getKommentar());

        if(!this.userService.findOne(reportDto.getReporterId()).isPresent()) {
            throw new RuntimeException();
        }
        report.setReporter(this.userService.findOne(reportDto.getReporterId()).get());

        if (reportDto.getReportedPoiId() != null && reportDto.getReportedUserId() != null && reportDto.getReportedCommentId() != null){
            throw new RuntimeException();
        }

        if(reportDto.getReportedUserId() != null){
            report.setReportedUser(this.userService.findOne(reportDto.getReportedUserId() != null ? reportDto.getReportedUserId() : "").get());
        }

        if(reportDto.getReportedPoiId() != null){
            report.setReportedPoi(this.poIService.findOne(reportDto.getReportedPoiId() != null ? reportDto.getReportedPoiId() : "").get());
        }

        if(reportDto.getReportedCommentId() != null){
            report.setReportedComment(this.commentService.findOne(reportDto.getReportedCommentId() != null ? reportDto.getReportedCommentId() : "").get());
        }
        return this.reportRepo.save(report);
    }

    public List<Report> findAll(){
        return this.reportRepo.findAll();
    }

    public Report updateReport(String id, ReportDto reportDto) throws UserNotFoundException, PoINotFoundException, CommentNotFoundException {
        UUID uuid = UUID.fromString(id);
        Optional<Report> optionalReport = reportRepo.findById(uuid);
        if (!optionalReport.isPresent()) {
            throw new RuntimeException("Report not found");
        }
        Report report = optionalReport.get();
        
        // Update only fields that are not null in reportDto
        if (reportDto.getKommentar() != null) {
            report.setKommentar(reportDto.getKommentar());
        }
        if (reportDto.getTitle() != null) {
            report.setTitle(reportDto.getTitle());
        }
        if (reportDto.getStatus() != null) {
            report.setStatus(reportDto.getStatus());
        }
        if (reportDto.getReporterId() != null) {
            report.setReporter(this.userService.findOne(reportDto.getReporterId()).orElse(report.getReporter()));
        }
        if (reportDto.getReportedUserId() != null) {
            report.setReportedUser(this.userService.findOne(reportDto.getReportedUserId()).orElse(report.getReportedUser()));
        }
        if (reportDto.getReportedPoiId() != null) {
            report.setReportedPoi(this.poIService.findOne(reportDto.getReportedPoiId()).orElse(report.getReportedPoi()));
        }
        if (reportDto.getReportedCommentId() != null) {
            report.setReportedComment(this.commentService.findOne(reportDto.getReportedCommentId()).orElse(report.getReportedComment()));
        }

        return reportRepo.save(report);
    }



    public Optional<Report> findOne(String id) throws ReportNotFoundException{
        if(reportRepo.findById(UUID.fromString(id)) != null){
            return reportRepo.findById(UUID.fromString(id));
        }
        throw new ReportNotFoundException();
    }

    public void delete(String id){
        reportRepo.deleteById(UUID.fromString(id));
    }

    public List<Report> findByReportedUserId(String reportedUserId) {
        return reportRepo.findByReportedUserId(UUID.fromString(reportedUserId));
    }

    public List<Report> findByReportedCommentId(String reportedCommentId) {
        return reportRepo.findByReportedCommentId(UUID.fromString(reportedCommentId));
    }

    public List<Report> findByReportedPoiId(String reportedPoiId) {
        return reportRepo.findByReportedPoiId(UUID.fromString(reportedPoiId));
    }

}
