package com.ias.omega.BackHandyman.services.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;

public class JourneyTypeService {
    @Column(name="journey_type",length = 20)
    private String journeyType;

    public JourneyTypeService(String journeyType) {
        Validate.notNull(journeyType,"The Journey Type field cannot be empty or null.");
        Validate.isTrue(journeyType.toString().length() < 20,"The maximum Journey Type size is 11 characters.");
        this.journeyType = journeyType;
    }

    public String getValue() {
        return journeyType;
    }

    @Override
    public String toString() {
        return journeyType.toString();
    }

    protected JourneyTypeService() {
    }
}
