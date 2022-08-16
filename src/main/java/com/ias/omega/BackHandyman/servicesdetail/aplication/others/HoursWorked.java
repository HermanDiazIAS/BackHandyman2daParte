package com.ias.omega.BackHandyman.servicesdetail.aplication.others;

public class HoursWorked {

    private String normalHours;
    private String nightHours;
    private String sundayHours;
    private String extraNormalHours;
    private String extraNightHours;
    private String extraSundayHours;

    public HoursWorked(String normalHours, String nightHours, String sundayHours, String extraNormalHours, String extraNightHours, String extraSundayHours) {
        this.normalHours = normalHours;
        this.nightHours = nightHours;
        this.sundayHours = sundayHours;
        this.extraNormalHours = extraNormalHours;
        this.extraNightHours = extraNightHours;
        this.extraSundayHours = extraSundayHours;
    }

    public HoursWorked() {
    }

    public String getNormalHours() {
        return normalHours;
    }

    public void setNormalHours(String normalHours) {
        this.normalHours = normalHours;
    }

    public String getNightHours() {
        return nightHours;
    }

    public void setNightHours(String nightHours) {
        this.nightHours = nightHours;
    }

    public String getSundayHours() {
        return sundayHours;
    }

    public void setSundayHours(String sundayHours) {
        this.sundayHours = sundayHours;
    }

    public String getExtraNormalHours() {
        return extraNormalHours;
    }

    public void setExtraNormalHours(String extraNormalHours) {
        this.extraNormalHours = extraNormalHours;
    }

    public String getExtraNightHours() {
        return extraNightHours;
    }

    public void setExtraNightHours(String extraNightHours) {
        this.extraNightHours = extraNightHours;
    }

    public String getExtraSundayHours() {
        return extraSundayHours;
    }

    public void setExtraSundayHours(String extraSundayHours) {
        this.extraSundayHours = extraSundayHours;
    }

}
