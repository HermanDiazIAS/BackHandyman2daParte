package com.ias.omega.BackHandyman.servicesdetail.aplication.domain;

import com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs.*;

public class ServicesDetail {
    private final IdServDetail idServDetail;
    private final IdTechnicalServDetail idTechnicalServDetail;
    private final IdServiceClientServDetail idServiceClientServDetail;
    private final StartDateServDetail startDateServDetail;
    private final EndDateServDetail endDateServDetail;

    public ServicesDetail(IdServDetail idServDetail, IdTechnicalServDetail idTechnicalServDetail, IdServiceClientServDetail idServiceClientServDetail, StartDateServDetail startDateServDetail, EndDateServDetail endDateServDetail) {
        this.idServDetail = idServDetail;
        this.idTechnicalServDetail = idTechnicalServDetail;
        this.idServiceClientServDetail = idServiceClientServDetail;
        this.startDateServDetail = startDateServDetail;
        this.endDateServDetail = endDateServDetail;
    }

    public IdServDetail getIdServDetail() {
        return idServDetail;
    }

    public IdTechnicalServDetail getIdTechnicalServDetail() {
        return idTechnicalServDetail;
    }

    public IdServiceClientServDetail getIdServiceClientServDetail() {
        return idServiceClientServDetail;
    }

    public StartDateServDetail getStartDateServDetail() {
        return startDateServDetail;
    }

    public EndDateServDetail getEndDateServDetail() {
        return endDateServDetail;
    }

    @Override
    public String toString() {
        return "ServicesDetail{" +
                "idServDetail=" + idServDetail +
                ", idTechnicalServDetail=" + idTechnicalServDetail +
                ", idServiceClientServDetail=" + idServiceClientServDetail +
                ", startDateServDetail=" + startDateServDetail +
                ", endDateServDetail=" + endDateServDetail +
                '}';
    }
}
