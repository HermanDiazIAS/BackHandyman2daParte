package com.ias.omega.BackHandyman.services.aplication.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import javax.persistence.Column;

public class UserService {
    @Column(name="user",length = 11)
    private Integer userService;

    public UserService(Integer userService) {
        Validate.notNull(userService,"The User field cannot be empty or null.");
        Validate.isTrue(userService.toString().length() < 11,"The maximum User size is 11 characters.");
        this.userService = userService;
    }

    public Integer getValue() {
        return userService;
    }

    @Override
    public String toString() {
        return userService.toString();
    }

    protected UserService() {
    }
}
