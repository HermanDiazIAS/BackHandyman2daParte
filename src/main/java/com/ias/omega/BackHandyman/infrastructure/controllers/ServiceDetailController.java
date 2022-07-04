package com.ias.omega.BackHandyman.infrastructure.controllers;

import com.ias.omega.BackHandyman.infrastructure.models.servicesDetail.ServiceDetailDTO;
import com.ias.omega.BackHandyman.servicesdetail.aplication.services.CreatedServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/servicesdetail")
@CrossOrigin(origins = { "http://localhost:4200" })
public class ServiceDetailController {
    @Autowired
    private CreatedServiceDetail createdServiceDetail;

    @PostMapping
    public ResponseEntity<?> createdServiceDetail(@RequestBody ServiceDetailDTO serviceDetailDTO){
        return new ResponseEntity<>(createdServiceDetail.execute(serviceDetailDTO), HttpStatus.OK);
    }
}
