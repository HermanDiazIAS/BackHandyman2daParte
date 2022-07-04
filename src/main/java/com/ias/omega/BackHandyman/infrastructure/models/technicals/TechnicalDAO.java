package com.ias.omega.BackHandyman.infrastructure.models.technicals;

import lombok.Getter;
import lombok.Setter;

public class TechnicalDAO {

    @Getter @Setter
    private Long idTechnical;

    @Getter @Setter
    private String nameTechnical;

    @Getter @Setter
    private String typeDocumentTechnical;

    public TechnicalDAO() {
    }

    public TechnicalDAO(Long idTechnical, String nameTechnical, String typeDocumentTechnical) {
        this.idTechnical = idTechnical;
        this.nameTechnical = nameTechnical;
        this.typeDocumentTechnical = typeDocumentTechnical;
    }
}
