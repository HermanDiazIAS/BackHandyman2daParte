package com.ias.omega.BackHandyman.servicesdetail.aplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ias.omega.BackHandyman.services.aplication.domain.Services;
import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs.*;
import com.ias.omega.BackHandyman.technicals.aplication.models.Technicals;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "register_service")
public class ServicesDetail {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private IdServDetail idServDetail;

    @Embedded
    private IdTechnicalServDetail idTechnicalServDetail;

    @Embedded
    private IdServiceClientServDetail idServiceClientServDetail;

    @Embedded
    private StartDateServDetail startDateServDetail;

    @Embedded
    private EndDateServDetail endDateServDetail;

    @Embedded
    private StatusServDetail statusServDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service",insertable=false, updatable=false)
    private ServicesClient servicesClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_technical",insertable=false, updatable=false)
    private Technicals technicals;


    public ServicesClient getServicesClient() {
        return servicesClient;
    }

    public void setServicesClient(ServicesClient servicesClient) {
        this.servicesClient = servicesClient;
    }

    public ServicesDetail() {
    }

    public ServicesDetail(IdServDetail idServDetail, IdTechnicalServDetail idTechnicalServDetail, IdServiceClientServDetail idServiceClientServDetail, StartDateServDetail startDateServDetail, EndDateServDetail endDateServDetail, StatusServDetail statusServDetail) {
        this.idServDetail = idServDetail;
        this.idTechnicalServDetail = idTechnicalServDetail;
        this.idServiceClientServDetail = idServiceClientServDetail;
        this.startDateServDetail = startDateServDetail;
        this.endDateServDetail = endDateServDetail;
        this.statusServDetail = statusServDetail;
    }

    public IdServDetail getIdServDetail() {
        return idServDetail;
    }

    public void setIdServDetail(IdServDetail idServDetail) {
        this.idServDetail = idServDetail;
    }

    public IdTechnicalServDetail getIdTechnicalServDetail() {
        return idTechnicalServDetail;
    }

    public void setIdTechnicalServDetail(IdTechnicalServDetail idTechnicalServDetail) {
        this.idTechnicalServDetail = idTechnicalServDetail;
    }

    public IdServiceClientServDetail getIdServiceClientServDetail() {
        return idServiceClientServDetail;
    }

    public void setIdServiceClientServDetail(IdServiceClientServDetail idServiceClientServDetail) {
        this.idServiceClientServDetail = idServiceClientServDetail;
    }

    public StartDateServDetail getStartDateServDetail() {
        return startDateServDetail;
    }

    public void setStartDateServDetail(StartDateServDetail startDateServDetail) {
        this.startDateServDetail = startDateServDetail;
    }

    public EndDateServDetail getEndDateServDetail() {
        return endDateServDetail;
    }

    public void setEndDateServDetail(EndDateServDetail endDateServDetail) {
        this.endDateServDetail = endDateServDetail;
    }

    public StatusServDetail getStatusServDetail() {
        return statusServDetail;
    }

    public void setStatusServDetail(StatusServDetail statusServDetail) {
        this.statusServDetail = statusServDetail;
    }
}
