package com.ias.omega.BackHandyman.servicesdetail.aplication.services;
import com.ias.omega.BackHandyman.infrastructure.models.servicesDetail.ServiceDetailDTO;
import com.ias.omega.BackHandyman.infrastructure.validations.ServiceDetailValidations;
import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.services.aplication.ports.output.ServicesRespository;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.input.CreatedServiceDetailUseCase;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output.ServiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CreatedServiceDetail implements CreatedServiceDetailUseCase {
    @Autowired
    private ServiceDetailRepository serviceDetailRepository;

    @Autowired
    private ServicesRespository servicesRespository;

    @Autowired
    private ServiceDetailValidations serviceDetailValidations;

    @Override
    public ServiceDetailDTO execute(ServiceDetailDTO serviceDetailDTO) {
        serviceDetailValidations.validationsRulesServiceDetail(serviceDetailDTO);
        ServicesDetail servicesDetail = serviceDetailDTO.toUnsaveDomain();
        return ServiceDetailDTO.fromToDomain(serviceDetailRepository.save(servicesDetail));
    }
}
