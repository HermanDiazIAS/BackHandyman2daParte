package com.ias.omega.BackHandyman.infrastructure.models.technicals;

import com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs.IdTechnical;
import com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs.NameTechnical;
import com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs.TypeDocumentTechnical;
import com.ias.omega.BackHandyman.technicals.aplication.models.Technicals;

public class TechnicalDTO {

    private String idTechnical;
    private String nameTechnical;
    private String typeDocumentTechnical;

    public TechnicalDTO() {
    }

    public TechnicalDTO(String idTechnical, String nameTechnical, String typeDocumentTechnical) {
        this.idTechnical = idTechnical;
        this.nameTechnical = nameTechnical;
        this.typeDocumentTechnical = typeDocumentTechnical;
    }


    public Technicals toDomain() {
        return new Technicals(
                new IdTechnical(idTechnical),
                new NameTechnical(nameTechnical),
                new TypeDocumentTechnical(typeDocumentTechnical)
                );
    }

    public static TechnicalDTO fromToDomain(Technicals technicals) {
        TechnicalDTO technicalDTO = new TechnicalDTO();
        technicalDTO.setIdTechnical(technicals.getIdTechnical().getIdTechnical());
        technicalDTO.setNameTechnical(technicals.getNameTechnical().getNameTechnical());
        technicalDTO.setTypeDocumentTechnical(technicals.getTypeDocumentTechnical().getTypeDocument());
        return technicalDTO;
    }

    public Technicals toUnsaveDomain() {
        return new Technicals(null,
                new NameTechnical(nameTechnical),
                new TypeDocumentTechnical(typeDocumentTechnical)
                );
    }

    public String getIdTechnical() {
        return idTechnical;
    }

    public void setIdTechnical(String idTechnical) {
        this.idTechnical = idTechnical;
    }

    public String getNameTechnical() {
        return nameTechnical;
    }

    public void setNameTechnical(String nameTechnical) {
        this.nameTechnical = nameTechnical;
    }

    public String getTypeDocumentTechnical() {
        return typeDocumentTechnical;
    }

    public void setTypeDocumentTechnical(String typeDocumentTechnical) {
        this.typeDocumentTechnical = typeDocumentTechnical;
    }
}
