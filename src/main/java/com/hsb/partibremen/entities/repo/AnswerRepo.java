package com.hsb.partibremen.entities.repo;

import com.hsb.partibremen.entities.model.answer.Answer;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnswerRepo extends BaseRepo<Answer, UUID> {

}


