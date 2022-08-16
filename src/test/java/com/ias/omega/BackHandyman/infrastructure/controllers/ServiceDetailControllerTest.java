package com.ias.omega.BackHandyman.infrastructure.controllers;

import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.input.QueryServicesByTechnicalUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class ServiceDetailControllerTest {

    @InjectMocks
    ServiceDetailController serviceDetailController;

    @Mock
    QueryServicesByTechnicalUseCase queryServicesByTechnicalUseCase;
    @Test
    @DisplayName("Test de la clase ServiceDetailController")
    void QueryServicesByTechnicalUseCaseTest(){

        String idTechnical = "1152669883";
        String week = "SEMANA30";

        HashMap<String, String> data = new HashMap<>();
        data.put("idTechnical",idTechnical);
        data.put("week",week);

    }
}
