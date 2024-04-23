package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.model.report.Report;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ReportService extends BaseService {

    public ArrayList<Report> reportList = new ArrayList<>(); //.

    public ArrayList<Report> findAll(){
        return this.reportList;
    }

    public Report findOne(String id){
        for (Report report : this.reportList){
            if(report.id.toString().equals(id)){
                return report;
            }
        }
        return null;
    }

}
