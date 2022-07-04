package com.ias.omega.BackHandyman.technicals.aplication.models;

import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs.IdTechnical;
import com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs.NameTechnical;
import com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs.TypeDocumentTechnical;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="technicals")
public class Technicals {


    @Id
    @Embedded
    private IdTechnical idTechnical;

    @Embedded
    private NameTechnical nameTechnical;

    @Embedded
    private TypeDocumentTechnical typeDocumentTechnical;

    @OneToMany(mappedBy = "technicals", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServicesDetail> servicesDet = new HashSet<>();

    public Technicals() {
    }

    public Technicals(IdTechnical idTechnical, NameTechnical nameTechnical, TypeDocumentTechnical typeDocumentTechnical) {
        this.idTechnical = idTechnical;
        this.nameTechnical = nameTechnical;
        this.typeDocumentTechnical = typeDocumentTechnical;
    }

    public IdTechnical getIdTechnical() {
        return idTechnical;
    }

    public void setIdTechnical(IdTechnical idTechnical) {
        this.idTechnical = idTechnical;
    }

    public NameTechnical getNameTechnical() {
        return nameTechnical;
    }

    public void setNameTechnical(NameTechnical nameTechnical) {
        this.nameTechnical = nameTechnical;
    }

    public TypeDocumentTechnical getTypeDocumentTechnical() {
        return typeDocumentTechnical;
    }

    public void setTypeDocumentTechnical(TypeDocumentTechnical typeDocumentTechnical) {
        this.typeDocumentTechnical = typeDocumentTechnical;
    }

    @Override
    public String toString() {
        return "Technicals{" +
                "idTechnical=" + idTechnical +
                ", nameTechnical=" + nameTechnical +
                ", typeDocumentTechnical=" + typeDocumentTechnical +
                '}';
    }
}


