package com.ias.omega.BackHandyman.services.aplication.services;

import com.ias.omega.BackHandyman.infrastructure.models.services.ServiceDTO;
import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.services.aplication.ports.input.QueryAllUseCase;
import com.ias.omega.BackHandyman.services.aplication.ports.output.ServicesRespository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryServicesAll implements QueryAllUseCase {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ServicesRespository servicesRespository;

    @Override
    public List<ServiceDTO> execute(Long aLong) {
        List<ServicesClient> lisServices = servicesRespository.findAll();
        return lisServices.stream().map((serv)-> fromToDomain(serv)).collect(Collectors.toList());
    }

    public ServiceDTO fromToDomain(ServicesClient service){
        ServiceDTO serviceDTOConvert = modelMapper.map(service,ServiceDTO.class);
        return serviceDTOConvert;
    }
}
