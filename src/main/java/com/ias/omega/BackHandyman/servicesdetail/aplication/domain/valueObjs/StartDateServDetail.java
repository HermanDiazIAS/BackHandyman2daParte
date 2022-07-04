package com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;
import java.util.Date;

public class StartDateServDetail {

    @Column(name="start_date",nullable = false)
    private Date startDateServDetail;

    public StartDateServDetail(Date startDateServDetail) {
        Validate.notNull(startDateServDetail,"The start_date field cannot be empty or null.");
        this.startDateServDetail = startDateServDetail;
    }

    public Date getStartDateServDetail() {
        return startDateServDetail;
    }

    @Override
    public String toString() {
        return startDateServDetail.toString();
    }

    private StartDateServDetail() {
    }
}
