package com.ias.omega.BackHandyman.infrastructure.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private long valueField;

    public ResourceNotFoundException(String resourceName, String fieldName, long valueField) {
        super(String.format("%s Not found with :  %s : '%s'",resourceName,fieldName,valueField));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.valueField = valueField;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getValueField() {
        return valueField;
    }

    public void setValueField(long valueField) {
        this.valueField = valueField;
    }
}
