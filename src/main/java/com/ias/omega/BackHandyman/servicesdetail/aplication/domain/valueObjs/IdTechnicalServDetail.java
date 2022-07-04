package com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IdTechnicalServDetail {

    @Column(name = "id_technical",length = 10, nullable = false)
    private String idTechnicalServDetail;

    public IdTechnicalServDetail(String idTechnicalServDetail) {
        String value = idTechnicalServDetail.toString();
        Validate.notNull(value.toString(),"The id_technical field cannot be empty or null.");
        Validate.isTrue(value.toString().length() <= 10,"The maximum id_technical size is 10 characters.");
        this.idTechnicalServDetail = idTechnicalServDetail;
    }

    public String getIdTechnicalServDetail() {
        return idTechnicalServDetail;
    }

    @Override
    public String toString() {
        return idTechnicalServDetail.toString();
    }

    public IdTechnicalServDetail() {}
}
