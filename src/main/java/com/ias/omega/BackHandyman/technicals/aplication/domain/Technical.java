package com.ias.omega.BackHandyman.technicals.aplication.domain;

import com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs.IdTechnical;
import com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs.NameTechnical;
import com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs.TypeDocumentTechnical;

public class Technical {

    private final IdTechnical idTechnical;
    private final NameTechnical nameTechnical;
    private final TypeDocumentTechnical typeDocumentTechnical;

    public Technical(IdTechnical idTechnical, NameTechnical nameTechnical, TypeDocumentTechnical typeDocumentTechnical) {
        this.idTechnical = idTechnical;
        this.nameTechnical = nameTechnical;
        this.typeDocumentTechnical = typeDocumentTechnical;
    }

    public IdTechnical getIdTechnical() {
        return idTechnical;
    }

    public NameTechnical getNameTechnical() {
        return nameTechnical;
    }

    public TypeDocumentTechnical getTypeDocumentTechnical() {
        return typeDocumentTechnical;
    }

    @Override
    public String toString() {
        return "Technical{" +
                "idTechnical=" + idTechnical +
                ", nameTechnical=" + nameTechnical +
                ", typeDocumentTechnical=" + typeDocumentTechnical +
                '}';
    }
}
