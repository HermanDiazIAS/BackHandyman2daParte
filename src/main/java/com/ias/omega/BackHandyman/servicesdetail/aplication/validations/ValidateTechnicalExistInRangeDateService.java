package com.ias.omega.BackHandyman.servicesdetail.aplication.validations;

import com.ias.omega.BackHandyman.commons.UseCase;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output.ServiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ValidateTechnicalExistInRangeDateService{

    @Autowired
    private ServiceDetailRepository serviceDetailRepository;

    public Boolean execute(String idTechnical,Date startDate,Date endDate) {
        List<ServicesDetail> validTechnicalExistenceInDates = serviceDetailRepository.queryAllServicesByTechinicalAndDate(idTechnical, startDate, endDate);
        System.out.println(validTechnicalExistenceInDates.isEmpty());
        return !validTechnicalExistenceInDates.isEmpty() ? false : true;
    }
}
