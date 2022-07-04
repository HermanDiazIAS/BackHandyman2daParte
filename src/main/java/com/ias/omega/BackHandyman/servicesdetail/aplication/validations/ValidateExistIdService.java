package com.ias.omega.BackHandyman.servicesdetail.aplication.validations;

import com.ias.omega.BackHandyman.commons.UseCase;
import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import com.ias.omega.BackHandyman.services.aplication.ports.output.ServicesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidateExistIdService implements UseCase<Long, Boolean> {

    @Autowired
    private ServicesRespository servicesRespository;

    @Override
    public Boolean execute(Long IdService) {
        Optional<ServicesClient> validExistService = servicesRespository.queryById(IdService);
        return !validExistService.isPresent() ? false: true;
    }
}
