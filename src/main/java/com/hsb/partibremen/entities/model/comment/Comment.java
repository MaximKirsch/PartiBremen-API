package com.hsb.partibremen.entities.model.comment;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.report.Report;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "comment")
@SQLDelete(sql = "UPDATE comment SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=0")
public class Comment extends BaseEntity {
    @Column
    private String actualComment;

    @ManyToOne
    @JsonBackReference
    private Comment commentComment;

    @ManyToOne
    private User commenter;

    @ManyToOne
    @JsonBackReference
    private PoI poI;

    @OneToMany(mappedBy = "votedComment")
    @JsonManagedReference
    private List<Voting> votings;

    @OneToMany(mappedBy = "commentComment")
    @JsonManagedReference
    private List<Comment> comments;

    @OneToMany(mappedBy = "reportedComment")
    @JsonManagedReference
    private List<Report> reports;

    public Comment getCommentComment() {
        return commentComment;
    }
    public void setCommentComment(Comment commentComment) {
        this.commentComment = commentComment;
    }

    public String getActualcomment(){
        return this.actualComment;
    }
    public void setActualcomment(String actualComment) {
        this.actualComment = actualComment;
    }
    public User getCommenter(){
        return this.commenter;
    }
    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }
    public PoI getPoI(){
        return this.poI;
    }
    public void setPoI(PoI poI) {
        this.poI = poI;
    }
    public List<Voting> getVoting(){
        return this.votings;
    }
    public List<Comment> getComments(){
        return this.comments;
    }

    public List<Report> getReports(){
        return this.reports;
    }

}
