package com.hsb.partibremen.entities.service;

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

    public Report create(ReportDto reportDto) {
        Report report = new Report();
        report.setTitle(reportDto.getTitle());
        report.setKommentar(reportDto.getKommentar());

        if(!this.userService.findOne(reportDto.getReporterId()).isPresent()) {
            throw new RuntimeException();
        }
        report.setReporter(this.userService.findOne(reportDto.getReporterId()).get());

        if ((!this.userService.findOne(reportDto.getReportedUserId()).isPresent() && !this.poIService.findOne(reportDto.getReportedPoiId()).isPresent())
                 ||
                (this.userService.findOne(reportDto.getReportedUserId()).isPresent() && this.poIService.findOne(reportDto.getReportedPoiId()).isPresent())
        ) {
            throw new RuntimeException();
        }

        if(this.userService.findOne(reportDto.getReportedUserId()).isPresent()){
            report.setReportedUser(this.userService.findOne(reportDto.getReportedUserId()).get());
        }

        if(this.poIService.findOne(reportDto.getReportedPoiId()).isPresent()){
            report.setReportedPoi(this.poIService.findOne(reportDto.getReportedPoiId()).get());
        }
        return this.reportRepo.save(report);
    }

    public List<Report> findAll(){
        return this.reportRepo.findAll();
    }

    public Optional<Report> findOne(String id){
        return reportRepo.findById(UUID.fromString(id));
    }

    public void delete(String id){
        reportRepo.deleteById(UUID.fromString(id));
    }

}
