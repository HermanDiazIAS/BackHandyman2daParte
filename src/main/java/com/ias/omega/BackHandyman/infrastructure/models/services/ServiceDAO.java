package com.ias.omega.BackHandyman.infrastructure.models.services;

import lombok.Getter;
import lombok.Setter;

public class ServiceDAO {
    @Getter @Setter
    private Long idService;

    @Getter @Setter
    private String typeService;

    @Getter @Setter
    private String journeyTypeService;

    @Getter @Setter
    private String addressService;

    @Getter @Setter
    private Integer userService;

    public ServiceDAO() {
    }

    public ServiceDAO(Long idService, String typeService, String journeyTypeService, String addressService, Integer userService) {
        this.idService = idService;
        this.typeService = typeService;
        this.journeyTypeService = journeyTypeService;
        this.addressService = addressService;
        this.userService = userService;
    }
}
