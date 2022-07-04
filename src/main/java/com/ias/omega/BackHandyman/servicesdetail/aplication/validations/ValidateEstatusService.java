package com.ias.omega.BackHandyman.servicesdetail.aplication.validations;

import com.ias.omega.BackHandyman.commons.UseCase;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output.ServiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ValidateEstatusService implements UseCase<Integer,Boolean> {
    @Autowired
    ServiceDetailRepository serviceDetailRepository;

    @Override
    public Boolean execute(Integer idService){
        List<ServicesDetail> validateServiceStatus = serviceDetailRepository.validateServiceCompleted(idService);
        return !validateServiceStatus.isEmpty() ? false : true;
    }
}
