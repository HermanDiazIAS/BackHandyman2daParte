package com.ias.omega.BackHandyman.servicesdetail.aplication.services;

import com.ias.omega.BackHandyman.servicesdetail.aplication.others.HoursWorked;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output.ServiceDetailRepository;
import com.ias.omega.BackHandyman.utils.DateHours;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.text.ParseException;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
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
    void executeTest() throws ParseException {

        String idTechnical = "1152669883";
        String week = "SEMANA30";

        HashMap<String, String> data = new HashMap<>();
        data.put("idTechnical",idTechnical);
        data.put("week",week);


       when(serviceDetailRepository.queryServices(idTechnical,"2022-07-25 00:00:00", "2022-07-31 24:00:00" ))
               .thenReturn(DateHours.days_worked());

        HoursWorked hoursWorked = queryServicesByTechnical.execute(data);

        assertNotNull(hoursWorked);

        assertEquals("13", hoursWorked.getNormalHours());
        assertEquals("11",hoursWorked.getNightHours());
        assertEquals("0",hoursWorked.getSundayHours());
        assertEquals("0",hoursWorked.getExtraNormalHours());
        assertEquals("0",hoursWorked.getExtraNightHours());
        assertEquals("0",hoursWorked.getExtraSundayHours());
    }

    @Test
    @DisplayName("Test de las exception")
    void executeExceptionTest() throws ParseException {

        String idTechnical = "1152669883";
        String week = "SEMANA30";

        HashMap<String, String> data = new HashMap<>();
        data.put("idTechnical",idTechnical);
        data.put("week",week);


        when(serviceDetailRepository.queryServices(idTechnical,"2022-07-25 00:00:00", "2022-07-31 24:00:00" ))
                .thenReturn(DateHours.listEmpty());

        var runtimeException = assertThrows(RuntimeException.class, () -> {
            queryServicesByTechnical.execute(data);
        });

        assertEquals(RuntimeException.class , runtimeException.getClass());
        verify(serviceDetailRepository).queryServices(any(),any(),any());
    }

}