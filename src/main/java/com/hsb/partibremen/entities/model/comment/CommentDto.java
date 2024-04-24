package com.hsb.partibremen.entities.model.comment;

public class CommentDto {
    private String comment;

    private String commenterId;

    private String poiId;


    public String getComment() {
        return comment;
    }
    public void setComment(String titel) {
        this.comment = comment;
    }
    public String getCommenterId() {
        return commenterId;
    }
    public void setCommenterId(String commenterId) {
        this.commenterId = commenterId;
    }
    public String getPoiId() {
        return poiId;
    }
    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }
    
}
