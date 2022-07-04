package com.ias.omega.BackHandyman.infrastructure.models.services;

import com.ias.omega.BackHandyman.services.aplication.domain.Services;
import com.ias.omega.BackHandyman.services.aplication.domain.valueObjs.*;
import com.ias.omega.BackHandyman.services.aplication.models.ServicesClient;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceDTO {
    @Autowired
    private ModelMapper modelMapper;

    private Long idService;

    private String typeService;

    private String journeyTypeService;

    private String addressService;

    private Integer userService;


    public ServiceDTO(Long idService, String typeService, String journeyTypeService, String addressService,Integer userService) {
        this.idService = idService;
        this.typeService = typeService;
        this.journeyTypeService = journeyTypeService;
        this.addressService = addressService;
        this.userService = userService;
    }

    public ServiceDTO() {
    }

    public ServicesClient toDomain(){
        return  new ServicesClient(
                new IdService(idService),
                new TypeService(typeService),
                new JourneyTypeService(journeyTypeService),
                new AddressService(addressService),
                new UserService(userService)
        );
    }

    public static ServiceDTO fromToDomain(ServicesClient service){
        //System.out.println(service.getIdService());
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setIdService(service.getIdService().getValue());
        serviceDTO.setTypeService(service.getTypeService().getValue());
        serviceDTO.setJourneyTypeService(service.getJourneyTypeService().getValue());
        serviceDTO.setAddressService(service.getAddressService().getValue());
        serviceDTO.setUserService(service.getUserService().getValue());
        return serviceDTO;
    }

    public Services toUnsaveDomain(){
       return new Services(null,
            new TypeService(typeService),
            new JourneyTypeService(journeyTypeService),
            new AddressService(addressService),
            new UserService(userService)
       );
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public String getJourneyTypeService() {
        return journeyTypeService;
    }

    public void setJourneyTypeService(String journeyTypeService) {
        this.journeyTypeService = journeyTypeService;
    }

    public String getAddressService() {
        return addressService;
    }

    public void setAddressService(String addressService) {
        this.addressService = addressService;
    }

    public Integer getUserService() {
        return userService;
    }

    public void setUserService(Integer userService) {
        this.userService = userService;
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }
}
