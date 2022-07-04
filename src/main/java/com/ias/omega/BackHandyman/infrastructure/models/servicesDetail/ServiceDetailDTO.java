package com.ias.omega.BackHandyman.infrastructure.models.servicesDetail;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs.*;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;

import java.util.Date;

public class ServiceDetailDTO {

    private Long idServDetail;

    private String idTechnicalServDetail;

    private Long idServiceClientServDetail;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDateServDetail;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDateServDetail;

    private Integer statusServDetail;

    public ServiceDetailDTO() {
    }

    public ServiceDetailDTO(Long idServDetail, String idTechnicalServDetail, Long idServiceClientServDetail, Date startDateServDetail, Date endDateServDetail, Integer statusServDetail) {
        this.idServDetail = idServDetail;
        this.idTechnicalServDetail = idTechnicalServDetail;
        this.idServiceClientServDetail = idServiceClientServDetail;
        this.startDateServDetail = startDateServDetail;
        this.endDateServDetail = endDateServDetail;
        this.statusServDetail = statusServDetail;
    }

    public static ServiceDetailDTO fromToDomain(ServicesDetail serviceDetail){
        ServiceDetailDTO serviceDetailDTO = new ServiceDetailDTO();
        serviceDetailDTO.setIdServDetail(serviceDetail.getIdServDetail().getIdServDetail());
        serviceDetailDTO.setIdServiceClientServDetail(serviceDetail.getIdServiceClientServDetail().getIdServiceClientServDetail());
        serviceDetailDTO.setIdTechnicalServDetail(serviceDetail.getIdTechnicalServDetail().getIdTechnicalServDetail());
        serviceDetailDTO.setStartDateServDetail(serviceDetail.getStartDateServDetail().getStartDateServDetail());
        serviceDetailDTO.setEndDateServDetail(serviceDetail.getEndDateServDetail().getEndDateServDetail());
        serviceDetailDTO.setStatusServDetail(serviceDetail.getStatusServDetail().getStatusServDetail());
        return serviceDetailDTO;
    }

    public ServicesDetail toUnsaveDomain(){
        ServicesDetail servicesDetail = new ServicesDetail();
        servicesDetail.setIdServDetail(new IdServDetail(null));
        servicesDetail.setIdTechnicalServDetail(new IdTechnicalServDetail(idTechnicalServDetail));
        servicesDetail.setIdServiceClientServDetail(new IdServiceClientServDetail(idServiceClientServDetail));
        servicesDetail.setStartDateServDetail(new StartDateServDetail(startDateServDetail));
        servicesDetail.setEndDateServDetail(new EndDateServDetail(endDateServDetail));
        servicesDetail.setStatusServDetail(new StatusServDetail(statusServDetail));
        return servicesDetail;
    }

    public Long getIdServDetail() {
        return idServDetail;
    }

    public void setIdServDetail(Long idServDetail) {
        this.idServDetail = idServDetail;
    }

    public String getIdTechnicalServDetail() {
        return idTechnicalServDetail;
    }

    public void setIdTechnicalServDetail(String idTechnicalServDetail) {
        this.idTechnicalServDetail = idTechnicalServDetail;
    }

    public Long getIdServiceClientServDetail() {
        return idServiceClientServDetail;
    }

    public void setIdServiceClientServDetail(Long idServiceClientServDetail) {
        this.idServiceClientServDetail = idServiceClientServDetail;
    }

    public Date getStartDateServDetail() {
        return startDateServDetail;
    }

    public void setStartDateServDetail(Date startDateServDetail) {
        this.startDateServDetail = startDateServDetail;
    }

    public Date getEndDateServDetail() {
        return endDateServDetail;
    }

    public void setEndDateServDetail(Date endDateServDetail) {
        this.endDateServDetail = endDateServDetail;
    }

    public Integer getStatusServDetail() {
        return statusServDetail;
    }

    public void setStatusServDetail(Integer statusServDetail) {
        this.statusServDetail = statusServDetail;
    }

    @Override
    public String toString() {
        return "ServiceDetailDTO{" +
                "idServDetail=" + idServDetail +
                ", idTechnicalServDetail='" + idTechnicalServDetail + '\'' +
                ", idServiceClientServDetail=" + idServiceClientServDetail +
                ", startDateServDetail=" + startDateServDetail +
                ", endDateServDetail=" + endDateServDetail +
                ", statusServDetail=" + statusServDetail +
                '}';
    }
}
