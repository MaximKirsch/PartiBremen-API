package com.hsb.partibremen.entities.model.poi;

public class PoIDto {


    private String titel;
    private String description;
    private Boolean active;
    private String creatorId;
    private double latitude;
    private double longitude;
    private String img;

    
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String getTitel() {
        return this.titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getCreatorId() {
        return this.creatorId;
    }
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    
}
