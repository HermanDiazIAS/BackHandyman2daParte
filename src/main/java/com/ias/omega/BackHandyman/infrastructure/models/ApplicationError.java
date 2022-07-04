package com.ias.omega.BackHandyman.infrastructure.models;

import java.util.Map;

public class ApplicationError {
    private final String error;
    private final String message;
    private final Map<String,String> metaData;

    public ApplicationError(String error, String message, Map<String, String> metaData) {
        this.error = error;
        this.message = message;
        this.metaData = metaData;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getMetaData() {
        return metaData;
    }
}
