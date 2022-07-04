package com.ias.omega.BackHandyman.services.aplication.services;

import com.ias.omega.BackHandyman.infrastructure.models.services.ServiceDTO;
import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.services.aplication.ports.input.CreatedServiceUseCase;
import com.ias.omega.BackHandyman.services.aplication.ports.output.ServicesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatedService implements CreatedServiceUseCase {
    @Autowired
    private ServicesRespository servicesRespository;

    @Override
    public ServiceDTO execute(ServiceDTO serviceDTO) {
        //ServicesClient servicesClient = servicesRespository.save(serviceDTO.withoutSaveDomain());
        //return ServiceDTO.fromToDomain(servicesClient);
        return null;
    }
}
