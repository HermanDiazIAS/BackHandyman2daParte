package com.ias.omega.BackHandyman.servicesdetail.aplication.services;
import com.ias.omega.BackHandyman.infrastructure.models.servicesDetail.ServiceDetailDTO;
import com.ias.omega.BackHandyman.infrastructure.validations.ServiceDetailValidations;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.input.CreatedServiceDetailUseCase;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output.ServiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatedServiceDetail implements CreatedServiceDetailUseCase {
    @Autowired
    private ServiceDetailRepository serviceDetailRepository;

    @Autowired
    private ServiceDetailValidations serviceDetailValidations;

    @Override
    public ServiceDetailDTO execute(ServiceDetailDTO serviceDetailDTO) {
        serviceDetailValidations.validationsRulesServiceDetail(serviceDetailDTO);
        ServicesDetail servicesDetail = serviceDetailDTO.toUnsaveDomain();
        return ServiceDetailDTO.fromToDomain(serviceDetailRepository.save(servicesDetail));
    }
}
