package com.ias.omega.BackHandyman.infrastructure.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ErrorDetails {
    private Date mark_time;
    private String msg;
    private String details;

    public ErrorDetails(Date mark_time, String msg, String details) {
        this.mark_time = mark_time;
        this.msg = msg;
        this.details = details;
    }

    public Date getMark_time() {
        return mark_time;
    }

    public void setMark_time(Date mark_time) {
        this.mark_time = mark_time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
