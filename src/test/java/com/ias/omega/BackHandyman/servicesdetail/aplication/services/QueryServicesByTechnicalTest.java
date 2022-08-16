package com.ias.omega.BackHandyman.servicesdetail.aplication.services;

import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.others.HoursWorked;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output.ServiceDetailRepository;
import com.ias.omega.BackHandyman.utils.DateHours;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class QueryServicesByTechnicalTest {

    @Autowired
    QueryServicesByTechnical queryServicesByTechnical;

    @MockBean
    ServiceDetailRepository serviceDetailRepository;

    @BeforeEach
    void init(){
//        startDate = "2022-07-25 00:00:00";
//        endDate = "2022-07-31 24:00:00";
    }

    @Test
    @DisplayName("Test de la clase buscar servicios por técnico")
    void queryHoursTest() {

        String idTechnical = "1152669883";
        String week = "SEMANA30";

        HashMap<String, String> data = new HashMap<>();
        data.put("idTechnical",idTechnical);
        data.put("week",week);

        var dateHoursWorked = DateHours.DATE_HOURS_WORKED;

        List<ServicesDetail> servicesDetails = (List<ServicesDetail>) DateHours.DAYS_WORKED;

        /**Retorna lista de dias laborados*/
       when(serviceDetailRepository.queryServices(idTechnical,"2022-07-25 00:00:00", "2022-07-31 24:00:00" )).thenReturn((List<ServicesDetail>) DateHours.DAYS_WORKED);
        queryServicesByTechnical.execute(data);
//        HoursWorked hoursWorked = queryServicesByTechnical.execute(data);

//        assertEquals("39", hoursWorked.getNormalHours());

    }
}