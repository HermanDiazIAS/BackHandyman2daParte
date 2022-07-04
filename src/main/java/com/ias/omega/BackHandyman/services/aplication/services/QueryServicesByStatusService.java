package com.ias.omega.BackHandyman.services.aplication.services;

import com.ias.omega.BackHandyman.infrastructure.models.services.ServiceDTO;
import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.services.aplication.ports.input.QueryServicesByStatus;
import com.ias.omega.BackHandyman.services.aplication.ports.output.ServicesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueryServicesByStatusService implements QueryServicesByStatus {
    @Autowired
    private ServicesRespository servicesRespository;

    @Override
    public List<ServiceDTO> execute(Integer status){
        List<ServicesClient> listServices =  servicesRespository.queryByStatus(status);
        return  listServices.stream().map((serv)-> ServiceDTO.fromToDomain(serv)).collect(Collectors.toList());
    }
}
