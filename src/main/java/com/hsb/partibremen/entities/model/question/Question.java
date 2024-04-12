package com.hsb.partibremen.entities.model.question;

import com.hsb.partibremen.entities.enums.QuestionType;
import com.hsb.partibremen.entities.util.BaseEntity;

public class Question extends BaseEntity{
    private String fragestellung;
    private QuestionType type;
}
