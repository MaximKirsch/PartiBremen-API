package com.hsb.partibremen.entities.repo;
import com.hsb.partibremen.entities.model.comment.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepo extends BaseRepo<Comment, UUID> {
    List<Comment> findAllByPoi_id(String poi_id);
}


