package com.hsb.partibremen.entities.service;
import com.hsb.partibremen.entities.model.comment.Comment;
import com.hsb.partibremen.entities.model.comment.CommentDto;
import com.hsb.partibremen.entities.repo.CommentRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService extends BaseService {
    @Autowired
    public CommentRepo commentRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private PoIService poIService;

    public Comment create(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setActualcomment(commentDto.getActualComment());

        if(!(userService.findOne(commentDto.getCommenterId())).isPresent()){
            throw new RuntimeException();
        }
        comment.setCommenter((userService.findOne(commentDto.getCommenterId())).get());

        if (commentDto.getPoiId() != null && commentDto.getCommentId() != null){
            throw new RuntimeException();
        }

        if(commentDto.getPoiId() != null){
            comment.setPoI(this.poIService.findOne(commentDto.getPoiId() != null ? commentDto.getPoiId() : "").get());        
        }
        if(commentDto.getCommentId() != null){
            comment.setCommentComment(this.findOne(commentDto.getCommentId() != null ? commentDto.getCommentId() : "").get());        
        }
        return commentRepo.save(comment);
    }

    public List<Comment> findPoiComments(String poiId) {
        return this.commentRepo.findAllByPoI_id(UUID.fromString(poiId));
    }

    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    public Optional<Comment> findOne(String id) {
        return commentRepo.findById(UUID.fromString(id));
    }

    public void delete(String id) {
        commentRepo.deleteById(UUID.fromString(id));
    }
}
