package com.hsb.partibremen.entities.controller;

import com.hsb.partibremen.entities.model.answer.Answer;
import com.hsb.partibremen.entities.model.answer.AnswerDto;
import com.hsb.partibremen.entities.model.comment.Comment;
import com.hsb.partibremen.entities.model.comment.CommentDto;
import com.hsb.partibremen.entities.service.AnswerService;
import com.hsb.partibremen.entities.service.CommentService;
import com.hsb.partibremen.entities.service.PoIService;
import com.hsb.partibremen.entities.service.UserService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController extends BaseController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private PoIService poIService;

    @PostMapping("/comment")
    public Comment create(@RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @GetMapping("/comment")
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @GetMapping("/comment/{id}")
    public Optional<Comment> findOne(@PathVariable String id) {
        return commentService.findOne(id);
    }

    @PutMapping("/comment/{id}")
    public Comment update(@PathVariable String id, @RequestBody CommentDto commentDto) {
        Optional<Comment> optionalComment = commentService.findOne(id);
        if(optionalComment.isPresent()){
            Comment comment = optionalComment.get();
            comment.setComment(commentDto.getComment());

            if(!(userService.findOne(commentDto.getCommenterId())).isPresent()){
                throw new RuntimeException();
            }
            comment.setCommenter((userService.findOne(commentDto.getCommenterId())).get());

            if(!(poIService.findOne(commentDto.getPoiId())).isPresent()){
                throw new RuntimeException();
            }
            comment.setPoI((poIService.findOne(commentDto.getPoiId())).get());
            return this.commentService.commentRepo.save(comment);
        }
        return new Comment();
    }

    @DeleteMapping("/comment/{id}")
    public void delete(@PathVariable String id) {
        commentService.delete(id);
    }
}
