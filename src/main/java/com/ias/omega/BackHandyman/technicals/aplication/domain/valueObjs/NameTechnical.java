package com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;

public class NameTechnical {

    @Column(name="nameTechnical",length = 50)
    private String NameTechnical;

    public NameTechnical(String nameTechnical) {
        Validate.notNull(nameTechnical,"The technical name field cannot be empty or null.");
        Validate.isTrue(nameTechnical.toString().length() <= 50,"The maximum technical name size is 50 characters.");
        NameTechnical = nameTechnical;
    }

    public String getNameTechnical() {
        return NameTechnical;
    }

    @Override
    public String toString() {
        return NameTechnical;
    }

    protected NameTechnical() {
    }
}
