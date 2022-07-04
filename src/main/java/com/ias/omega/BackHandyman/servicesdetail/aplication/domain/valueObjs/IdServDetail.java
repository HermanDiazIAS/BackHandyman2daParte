package com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable
public class IdServDetail implements Serializable{
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServDetail;

    public IdServDetail(Long idServDetail) {
        this.idServDetail = idServDetail;
    }

    public Long getIdServDetail() {
        return idServDetail;
    }

    @Override
    public String toString() {
        return idServDetail.toString();
    }

    protected IdServDetail(){}
}
