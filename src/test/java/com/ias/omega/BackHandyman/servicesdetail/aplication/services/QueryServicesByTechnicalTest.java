package com.ias.omega.BackHandyman.servicesdetail.aplication.services;

import com.ias.omega.BackHandyman.servicesdetail.aplication.others.HoursWorked;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output.ServiceDetailRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.when;

@SpringBootTest
public class QueryServicesByTechnicalTest {

    @InjectMocks
    QueryServicesByTechnical queryServicesByTechnical;

    @Mock
    ServiceDetailRepository serviceDetailRepository;

    @BeforeAll
    private static void first(){
        System.out.println("Inicio de la clase Test");
    }

    @AfterAll
    private static void last() {
        System.out.println("Fin de la clase Test");
    }

    @Test
    @DisplayName("Test buscar servicios por técnico")
    public void numberHours(){

        private String normalHours;
        private String nightHours;
        private String sundayHours;
        private String extraNormalHours;
        private String extraNightHours;
        private String extraSundayHours;

        HoursWorked hoursWorked = new HoursWorked(
                normalHours, nightHours, sundayHours, extraNormalHours, extraNightHours, extraSundayHours);
        when(serviceDetailRepository.save(hoursWorked
    }
}
