package com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs;

import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.services.aplication.ports.output.ServicesRespository;
import org.apache.commons.lang3.Validate;

import javax.persistence.Column;
import java.util.Optional;

public class IdServiceClientServDetail {
    @Column(name = "id_service",length = 11)
    private Long idServiceClientServDetail;

    public IdServiceClientServDetail(Long idServiceClientServDetail) {
        Validate.notNull(idServiceClientServDetail,"The id_service field cannot be empty or null.");
        Validate.isTrue(idServiceClientServDetail.toString().length() <= 11,"The maximum id_service size is 11 characters.");
        this.idServiceClientServDetail = idServiceClientServDetail;
    }

    public Long getIdServiceClientServDetail() {
        return idServiceClientServDetail;
    }

    @Override
    public String toString() {
        return idServiceClientServDetail.toString();
    }

    protected IdServiceClientServDetail(){}
}
