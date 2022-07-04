package com.ias.omega.BackHandyman.services.aplication.domain;

import com.ias.omega.BackHandyman.services.aplication.domain.valueObjs.*;

public class Services {

    private final IdService idService;
    private final TypeService typeService;
    private final JourneyTypeService journeyTypeService;
    private final AddressService addressService;
    private final UserService userService;


    public Services(IdService idService, TypeService typeService, JourneyTypeService journeyTypeService, AddressService addressService, UserService userService) {
        this.idService = idService;
        this.typeService = typeService;
        this.journeyTypeService = journeyTypeService;
        this.addressService = addressService;
        this.userService = userService;
    }

    public IdService getIdService() {
        return idService;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public JourneyTypeService getJourneyTypeService() {
        return journeyTypeService;
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public UserService getUserService() {
        return userService;
    }

    @Override
    public String toString() {
        return "Services{" +
                "idService=" + idService +
                ", typeService=" + typeService +
                ", journeyTypeService=" + journeyTypeService +
                ", addressService=" + addressService +
                ", userService=" + userService +
                '}';
    }
}
