package com.ias.omega.BackHandyman.technicals.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;

public class TypeDocumentTechnical {
    @Column(name="typeDocument",length = 30)
    private String TypeDocument;

    public TypeDocumentTechnical(String typeDocument) {
        Validate.notNull(TypeDocument,"The type document field cannot be empty or null.");
        Validate.isTrue(TypeDocument.toString().length() <= 50,"The maximum type document size is 30 characters.");
        TypeDocument = typeDocument;
    }

    public String getTypeDocument() {
        return TypeDocument;
    }

    @Override
    public String toString() {
        return TypeDocument;
    }

    protected TypeDocumentTechnical() {
    }
}

