package com.ias.omega.BackHandyman.services.aplication.services;

import com.ias.omega.BackHandyman.infrastructure.exceptions.ResourceNotFoundException;
import com.ias.omega.BackHandyman.infrastructure.models.services.ServiceDTO;
import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.services.aplication.ports.input.QueryByIdUseCase;
import com.ias.omega.BackHandyman.services.aplication.ports.output.ServicesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryByIdService implements QueryByIdUseCase {
    @Autowired
    private ServicesRespository servicesRespository;

    @Override
    public Optional<ServiceDTO> execute(Long idService) {
        Optional<ServicesClient> response = servicesRespository.queryById(idService);
        if(response.isPresent()){
            return response.map(serv->{
                ServiceDTO serviceDTO = ServiceDTO.fromToDomain(serv);
                return serviceDTO;
            });
        }
        return null;
    }

}
