package com.ias.omega.BackHandyman.services.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;

public class AddressService {
    @Column(name="address",length = 50)
    private String address;

    public AddressService(String address) {
        Validate.notNull(address,"The Address field cannot be empty or null.");
        Validate.isTrue(address.toString().length() < 50,"The maximum Address size is 50 characters.");
        this.address = address;
    }

    public String getValue() {
        return address;
    }

    @Override
    public String toString() {
        return address.toString();
    }

    protected AddressService() {
    }
}
