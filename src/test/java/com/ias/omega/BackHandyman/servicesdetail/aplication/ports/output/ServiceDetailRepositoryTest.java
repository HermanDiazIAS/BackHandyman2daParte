package com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output;

import com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs.*;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@DataJpaTest
public class ServiceDetailRepositoryTest {

    @Autowired
    ServiceDetailRepository serviceDetailRepository;
    List<ServicesDetail> servicesDetailList = new ArrayList<>();

    @Test
    void queryServices() throws ParseException {

        var listQueryServices = serviceDetailRepository.queryServices("1152669883", "2022-08-08 00:00:00", "2022-08-14 24:00:00");



//        verify(serviceDetailRepository, times(1)).findAll();

    }

    public List<ServicesDetail> ListServiceDetail() throws ParseException {

        ServicesDetail servicesDetail1 = new ServicesDetail();
        servicesDetail1.setIdServDetail(new IdServDetail(1L));
        servicesDetail1.setIdTechnicalServDetail(new IdTechnicalServDetail("1152669883"));
        servicesDetail1.setIdServiceClientServDetail(new IdServiceClientServDetail(1L));
        servicesDetail1.setStartDateServDetail(new StartDateServDetail(converterDate("2022-08-12 08:00:33.000000")));
        servicesDetail1.setEndDateServDetail(new EndDateServDetail(converterDate("2022-08-13 08:00:40.000000")));
        servicesDetail1.setStatusServDetail(new StatusServDetail(1));

        servicesDetailList.add(servicesDetail1);


        return servicesDetailList;
    }

    public Date converterDate(String date) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        Date fecha = formato.parse(date);
        return fecha;
    }
}
