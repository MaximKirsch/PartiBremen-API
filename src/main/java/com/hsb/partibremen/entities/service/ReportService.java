package com.hsb.partibremen.entities.service;

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

    public Optional<Report> findOne(String id) throws ReportNotFoundException{
        if(reportRepo.findById(UUID.fromString(id)) != null){
            return reportRepo.findById(UUID.fromString(id));
        }
        throw new ReportNotFoundException();
    }

    public void delete(String id){
        reportRepo.deleteById(UUID.fromString(id));
    }

}
