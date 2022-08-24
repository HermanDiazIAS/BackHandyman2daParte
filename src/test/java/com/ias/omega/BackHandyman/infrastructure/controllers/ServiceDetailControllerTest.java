package com.ias.omega.BackHandyman.infrastructure.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.input.QueryServicesByTechnicalUseCase;
import com.ias.omega.BackHandyman.servicesdetail.aplication.services.CreatedServiceDetail;
import com.ias.omega.BackHandyman.utils.DateHours;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;

import static org.mockito.Mockito.when;


@WebMvcTest(ServiceDetailController.class)
class ServiceDetailControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QueryServicesByTechnicalUseCase queryServicesByTechnicalUseCase;

    @MockBean
    private CreatedServiceDetail createdServiceDetail;

    @Test
    @DisplayName("Test de la clase ServiceDetailController")
    void QueryServicesByTechnicalUseCaseTest() throws Exception {
        String idTechnical = "1152669883";
        String week = "SEMANA30";

        HashMap<String, String> data = new HashMap<>();
        data.put("idTechnical", idTechnical);
        data.put("week", week);

        when(queryServicesByTechnicalUseCase.execute(data)).thenReturn(DateHours.workedHours().orElseThrow());

        mvc.perform(get("/api/servicesdetail/" + idTechnical + "/" + week + "").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.normalHours").value("39"))
                .andExpect(jsonPath("$.nightHours").value("27"))
                .andExpect(jsonPath("$.sundayHours").value("0"))
                .andExpect(jsonPath("$.extraNormalHours").value("18"))
                .andExpect(jsonPath("$.extraNightHours").value("0"))
                .andExpect(jsonPath("$.extraSundayHours").value("0"));
    }
}

