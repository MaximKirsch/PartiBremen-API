package com.hsb.partibremen.entities.model.comment;

import com.hsb.partibremen.entities.model.poi.PoI;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.voting.Voting;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {
    @Column
    private String comment;

    @ManyToOne
    private User commenter;

    @ManyToOne
    private PoI poI;

    @OneToMany
    private List<Voting> votings;

    @OneToMany
    private List<Comment> comments;

    public String getComment(){
        return this.comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
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

}
