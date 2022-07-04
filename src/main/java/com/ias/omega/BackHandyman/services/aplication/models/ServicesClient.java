package com.ias.omega.BackHandyman.services.aplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ias.omega.BackHandyman.services.aplication.domain.valueObjs.*;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name="services")

public class ServicesClient {
    @AttributeOverrides({
            @AttributeOverride( name = "idService", column = @Column(name = "id")),
    })

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Embedded
    private IdService idService;

    @Embedded
    private TypeService typeService;

    @Embedded
    private JourneyTypeService journeyTypeService;

    @Embedded
    private AddressService addressService;

    @Embedded
    private UserService userService;


    @JsonBackReference
    @OneToMany(mappedBy = "servicesClient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ServicesDetail> servicesDet = new HashSet<>();

    public Set<ServicesDetail> getServicesDet() {
        return servicesDet;
    }

    public void setServicesDet(Set<ServicesDetail> servicesDet) {
        this.servicesDet = servicesDet;
    }

    public ServicesClient() {}

    public ServicesClient(IdService idService, TypeService typeService, JourneyTypeService journeyTypeService, AddressService addressService, UserService userService) {
        this.idService = idService;
        this.typeService = typeService;
        this.journeyTypeService = journeyTypeService;
        this.addressService = addressService;
        this.userService = userService;
    }

    public static ServicesClient fromResult(Optional<ServicesClient> servicesClient){
        ServicesClient servicesClientNew = new ServicesClient();
        servicesClientNew.setIdService(servicesClient.get().getIdService());
        servicesClientNew.setTypeService(servicesClient.get().getTypeService());
        servicesClientNew.setJourneyTypeService(servicesClient.get().getJourneyTypeService());
        servicesClientNew.setAddressService(servicesClient.get().getAddressService());
        servicesClientNew.setUserService(servicesClient.get().getUserService());
        return servicesClientNew;
    }

    public IdService getIdService() {
        return idService;
    }

    public void setIdService(IdService idService) {
        this.idService = idService;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public JourneyTypeService getJourneyTypeService() {
        return journeyTypeService;
    }

    public void setJourneyTypeService(JourneyTypeService journeyTypeService) {
        this.journeyTypeService = journeyTypeService;
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
