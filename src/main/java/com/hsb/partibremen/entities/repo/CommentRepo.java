package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.answer.Answer;
import com.hsb.partibremen.entities.model.comment.Comment;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepo extends BaseRepo<Comment, UUID> {

}


