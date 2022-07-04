package com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;

public class StatusServDetail {
    @Column(name = "status")
    private Integer statusServDetail;

    public StatusServDetail(Integer statusServDetail) {
        Validate.notNull(statusServDetail,"The status field cannot be empty or null.");
        this.statusServDetail = statusServDetail;
    }

    public Integer getStatusServDetail() {
        return statusServDetail;
    }

    @Override
    public String toString() {
        return statusServDetail.toString();
    }

    private StatusServDetail() {
    }
}
