package com.hsb.partibremen.entities.model.report;

import com.hsb.partibremen.entities.util.BaseEntity;
import com.hsb.partibremen.entities.util.BaseService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "report")
public class Report extends BaseEntity {

    @Column
    private String kommentar;
    @Column
    private String title; //.

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
