package com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;
import java.util.Date;

public class EndDateServDetail {
    @Column(name="end_date",nullable = false)
    private Date endDateServDetail;

    public EndDateServDetail(Date endDateServDetail) {
        Validate.notNull(endDateServDetail,"The end_date field cannot be empty or null.");
        this.endDateServDetail = endDateServDetail;
    }

    public Date getEndDateServDetail() {
        return endDateServDetail;
    }

    private EndDateServDetail() {
    }
}
