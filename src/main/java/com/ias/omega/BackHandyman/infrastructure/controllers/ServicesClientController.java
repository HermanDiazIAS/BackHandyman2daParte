package com.ias.omega.BackHandyman.infrastructure.controllers;

import com.ias.omega.BackHandyman.infrastructure.models.services.ServiceDTO;
import com.ias.omega.BackHandyman.services.aplication.services.QueryByIdService;
import com.ias.omega.BackHandyman.services.aplication.services.QueryServicesAll;
import com.ias.omega.BackHandyman.services.aplication.services.QueryServicesByStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ServicesClientController {
    @Autowired
    private QueryServicesAll queryServicesAll;

    @Autowired
    private QueryByIdService queryByIdService;

    @Autowired
    private QueryServicesByStatusService queryServicesByStatus;

    @GetMapping("/services")
    public ResponseEntity<?> getServices(){
        List<ServiceDTO> responseData = queryServicesAll.execute(1L);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/services/{idService}")
    public ResponseEntity<?> getServiceById(@PathVariable(value = "idService") Long idService){
        Map<String,Object> response = new HashMap<>();
        response.put("service",queryByIdService.execute(idService));
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/services/status/{state}")
    public ResponseEntity<?> getServiceByStatus(@PathVariable(value = "state") Integer state){
        return new ResponseEntity<>(queryServicesByStatus.execute(state), HttpStatus.OK);
    }
}
