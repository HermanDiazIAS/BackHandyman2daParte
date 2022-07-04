package com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class IdTechnical implements Serializable {

    @Column(name="id",length = 11)
    private String IdTechnical;

    public IdTechnical(String idTechnical) {
        Validate.notNull(idTechnical,"The id technical field cannot be empty or null.");
        Validate.isTrue(idTechnical.length() > 10,"The maximum id technical size is 11 characters.");
        this.IdTechnical = idTechnical;
    }

    public String getIdTechnical() {
        return IdTechnical;
    }

    @Override
    public String toString() {
        return IdTechnical.toString();
    }

    protected IdTechnical(){
    }
}
