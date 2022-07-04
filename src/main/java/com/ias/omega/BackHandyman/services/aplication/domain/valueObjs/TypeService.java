package com.ias.omega.BackHandyman.services.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;

public class TypeService {
    @Column(name="service_type",length = 20)
    private String typeService;

    public TypeService(String typeService) {
        Validate.notNull(typeService,"The type service field cannot be empty or null.");
        Validate.isTrue(typeService.toString().length() < 20,"The maximum type service size is 20 characters.");
        this.typeService = typeService;
    }

    public String getValue() {
        return typeService;
    }

    @Override
    public String toString() {
        return typeService.toString();
    }

    private TypeService() {
    }
}
