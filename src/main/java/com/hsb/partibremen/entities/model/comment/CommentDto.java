package com.hsb.partibremen.entities.model.comment;

public class CommentDto {
    private String actualComment;

    private String commenterId;

    private String poiId;


    public String getActualComment() {
        return actualComment;
    }
    public void setActualComment(String actualComment) {
        this.actualComment = actualComment;
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
