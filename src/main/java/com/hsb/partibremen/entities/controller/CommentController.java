package com.hsb.partibremen.entities.controller;
import com.hsb.partibremen.entities.exceptions.CommentNotFoundException;
import com.hsb.partibremen.entities.exceptions.PoINotFoundException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.comment.Comment;
import com.hsb.partibremen.entities.model.comment.CommentDto;
import com.hsb.partibremen.entities.service.CommentService;
import com.hsb.partibremen.entities.service.PoIService;
import com.hsb.partibremen.entities.service.UserService;
import com.hsb.partibremen.entities.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public Comment create(@RequestBody CommentDto commentDto) throws UserNotFoundException, PoINotFoundException, CommentNotFoundException {
        return commentService.create(commentDto);
    }

    @GetMapping("/comment")
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @GetMapping("/comment/{id}")
    public Optional<Comment> findOne(@PathVariable String id) {
        try{
            return commentService.findOne(id);
        } catch(Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Comment not found", ex);
        }

    }

    @PutMapping("/comment/{id}")
    public Comment update(@PathVariable String id, @RequestBody CommentDto commentDto) throws UserNotFoundException, PoINotFoundException, CommentNotFoundException {
        Optional<Comment> optionalComment = commentService.findOne(id);
        if(optionalComment.isPresent()){
            Comment comment = optionalComment.get();
            comment.setActualcomment(commentDto.getActualComment());

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
