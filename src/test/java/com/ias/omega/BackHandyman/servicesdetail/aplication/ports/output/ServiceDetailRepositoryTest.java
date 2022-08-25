package com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output;

import com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs.*;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.utils.DateHours;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@DataJpaTest
@SpringBootTest
public class ServiceDetailRepositoryTest {

    @MockBean
    ServiceDetailRepository serviceDetailRepository;
    List<ServicesDetail> servicesDetailList = new ArrayList<>();

    @Test
    void queryServices() throws ParseException {

      //  var listQueryServices = serviceDetailRepository.queryServices("1152669883", "2022-08-08 00:00:00", "2022-08-14 24:00:00");
        when(serviceDetailRepository.queryServices(anyString(),anyString(),anyString()))
                .thenReturn(DateHours.days_worked());

        List<ServicesDetail> servicesDetails = serviceDetailRepository
                .queryServices("1152669883","2022-07-25 00:00:00","2022-07-31 24:00:00");

        assertNotNull(servicesDetails);
        verify(serviceDetailRepository).queryServices(anyString(),anyString(), anyString());

    }


}
