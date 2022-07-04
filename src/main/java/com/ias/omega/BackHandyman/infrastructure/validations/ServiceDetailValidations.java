package com.ias.omega.BackHandyman.infrastructure.validations;
import com.ias.omega.BackHandyman.infrastructure.models.servicesDetail.ServiceDetailDTO;
import com.ias.omega.BackHandyman.servicesdetail.aplication.validations.ValidateEstatusService;
import com.ias.omega.BackHandyman.servicesdetail.aplication.validations.ValidateExistIdService;
import com.ias.omega.BackHandyman.servicesdetail.aplication.validations.ValidateExistTechnical;
import com.ias.omega.BackHandyman.servicesdetail.aplication.validations.ValidateTechnicalExistInRangeDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class ServiceDetailValidations {
    @Autowired
    ValidateExistIdService validateExistIdService;
    @Autowired
    ValidateExistTechnical validateExistTechnical;
    @Autowired
    ValidateTechnicalExistInRangeDateService validateTechnicalExistInRangeDateService;

    @Autowired
    ValidateEstatusService validateEstatusService;

    public void validationsRulesServiceDetail(ServiceDetailDTO serviceDetailDTO){
        String idTechnical = serviceDetailDTO.getIdTechnicalServDetail();
        Date startDate = serviceDetailDTO.getStartDateServDetail();
        Date endDate = serviceDetailDTO.getEndDateServDetail();
        Integer idService = Integer.parseInt(serviceDetailDTO.getIdServiceClientServDetail().toString());

        if(!validateExistIdService.execute(serviceDetailDTO.getIdServiceClientServDetail())){
            throw new RuntimeException("Not found service with id : "+serviceDetailDTO.getIdServiceClientServDetail());
        }

        if(!validateExistTechnical.execute(serviceDetailDTO.getIdTechnicalServDetail())){
            throw new RuntimeException("The technician does not exist in the database with Id:"+serviceDetailDTO.getIdTechnicalServDetail());
        }

        if(!validateEstatusService.execute(idService)){
            throw new RuntimeException("The service has been completed con id : "+serviceDetailDTO.getIdServiceClientServDetail());
        }

        if(!validateTechnicalExistInRangeDateService.execute(idTechnical,startDate,endDate)){
            throw new RuntimeException("You already have a registered service in that date and time range ");
        }

        if(startDate.after(new Date()) || endDate.after(new Date())){
            throw new RuntimeException("You cannot register a service on a date later than the current date. ");
        }

        if(endDate.before(startDate)){
            throw new RuntimeException("The end date cannot be less than the start date.");
        }

        if(endDate.equals(startDate)){
            throw new RuntimeException("End date cannot be equal to start date");
        }

        if(calculateDifDays(new Date(),startDate) > 7){
            throw new RuntimeException("You cannot register a service with a previous rank greater than 7 days. ");
        }
    }

    public Integer calculateDifDays(Date startDate,Date endDate){
        Calendar dateOptional = Calendar.getInstance();
        dateOptional.setTime(startDate);
        dateOptional.add(Calendar.DAY_OF_YEAR, -7);
        Date dateRangeAllowed = new Date(dateOptional.getTimeInMillis());

        Date dt = dateRangeAllowed;
        String dateRanged = new SimpleDateFormat("yyyy/MM/dd").format(dt);
        String[] arrayCurrentDate = dateRanged.split("/");
        Integer yearValid = Integer.parseInt(arrayCurrentDate[0]);
        Integer monthValid = Integer.parseInt(arrayCurrentDate[1]);
        Integer dayValid = Integer.parseInt(arrayCurrentDate[2]);

        Date dtInput = endDate;
        String dateStart= new SimpleDateFormat("yyyy/MM/dd").format(endDate);
        String[] arrDateEntry = dateStart.split("/");
        Integer yearEntry = Integer.parseInt(arrDateEntry[0]);
        Integer monthEntry = Integer.parseInt(arrDateEntry[1]);
        Integer dayEntry= Integer.parseInt(arrDateEntry[2]);

        LocalDate dateAfter = LocalDate.of( yearValid ,monthValid,dayValid);
        LocalDate dateBefore = LocalDate.of( yearEntry ,monthEntry,dayEntry);
        Long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore,dateAfter);

        return Integer.parseInt(noOfDaysBetween.toString());
    }


}
