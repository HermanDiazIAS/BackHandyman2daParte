package com.ias.omega.BackHandyman.infrastructure.controllers;

import com.ias.omega.BackHandyman.infrastructure.models.servicesDetail.ServiceDetailDTO;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.input.QueryServicesByTechnicalUseCase;
import com.ias.omega.BackHandyman.servicesdetail.aplication.services.CreatedServiceDetail;
import com.ias.omega.BackHandyman.utils.WeekNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "/api/servicesdetail",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@CrossOrigin(origins = { "http://localhost:4200" })
public class ServiceDetailController {
    @Autowired
                                                                                                                                                                                                                    private CreatedServiceDetail createdServiceDetail;
    @Autowired
    private QueryServicesByTechnicalUseCase queryServicesByTechnicalUseCase;

    @PostMapping
    public ResponseEntity<?> createdServiceDetail(@RequestBody ServiceDetailDTO serviceDetailDTO){
        return new ResponseEntity<>(createdServiceDetail.execute(serviceDetailDTO), HttpStatus.OK);
    }

//    @GetMapping("/{idTechnical}/{week}")
    @RequestMapping(value = "/{idTechnical}/{week}", method = RequestMethod.GET)
    public ResponseEntity<?> getServiceByTechnical(@PathVariable String idTechnical, @PathVariable String week){
        HashMap<String, String> data = new HashMap<>();
        data.put("idTechnical",idTechnical);
        data.put("week",week);
        return ResponseEntity.ok(queryServicesByTechnicalUseCase.execute(data));
    }

    @GetMapping("/weeks")
    public ResponseEntity<?> getWeeks(){

        List<String> listWeeks = new ArrayList<>();
        for (WeekNumber week: WeekNumber.values()){
            var name = week.getName();
            listWeeks.add(name);

        }
        return ResponseEntity.status(HttpStatus.OK).body(listWeeks);
    }


}
