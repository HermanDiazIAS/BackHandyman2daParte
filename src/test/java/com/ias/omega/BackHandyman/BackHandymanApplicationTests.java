package com.ias.omega.BackHandyman;

import com.ias.omega.BackHandyman.services.aplication.domain.valueObjs.IdService;
import com.ias.omega.BackHandyman.services.aplication.domain.valueObjs.JourneyTypeService;
import com.ias.omega.BackHandyman.services.aplication.domain.valueObjs.TypeService;
import com.ias.omega.BackHandyman.services.aplication.domain.valueObjs.UserService;
import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackHandymanApplicationTests {

	@Test
	void contextLoads() {
		ServicesClient servicesClient = new ServicesClient();
		servicesClient.setIdService(new IdService(1L));
		servicesClient.setTypeService(new TypeService("Repair"));
		servicesClient.setJourneyTypeService(new JourneyTypeService("Tarde"));
		servicesClient.setUserService(new UserService(123));
		System.out.println(servicesClient.getTypeService());
		Assertions.assertTrue(servicesClient.getIdService().getValue() == 1L);
	}

}
