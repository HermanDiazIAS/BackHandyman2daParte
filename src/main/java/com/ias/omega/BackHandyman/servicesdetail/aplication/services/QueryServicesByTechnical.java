package com.ias.omega.BackHandyman.servicesdetail.aplication.services;

import static java.time.temporal.ChronoUnit.HOURS;

import com.ias.omega.BackHandyman.infrastructure.validations.ServiceDetailValidations;
import com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs.EndDateServDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs.StartDateServDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.others.HoursWorked;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.input.QueryServicesByTechnicalUseCase;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output.ServiceDetailRepository;
import com.ias.omega.BackHandyman.utils.WeekNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class QueryServicesByTechnical implements QueryServicesByTechnicalUseCase {
    @Autowired
    private ServiceDetailValidations serviceDetailValidations;
    @Autowired
    private ServiceDetailRepository serviceDetailRepository;

    @Override
    public HoursWorked execute(HashMap s) {
        String id = s.get("idTechnical").toString();
        String weekTechnical = s.get("week").toString();
        String startDate = "";
        String endDate = "";
        for (WeekNumber week : WeekNumber.values()) {
            if (week.getName().equals(weekTechnical)) {
                startDate = week.getStartDate();
                endDate = week.getEndDate();
            }
        }

        List<ServicesDetail> listServiceDetail = serviceDetailRepository.queryServices(id, startDate, endDate);
        serviceDetailValidations.validationsServiceDetailException(listServiceDetail.size());
        HoursWorked hoursWorked = numberHours(listServiceDetail);
        return hoursWorked;
    }

    private HoursWorked numberHours(List<ServicesDetail> listSD) {

        String startHour = null;
        String endHour = null;
        HoursWorked hoursWorked = null;

        int nightCount7 = 0;
        int nightCount24 = 0;
        int dayCount = 0;
        int sundayCount = 0;
        int extraSundayCount = 0;
        int extraHours = 0;
        int extraHourDay = 0;
        int extraHourNight = 0;
        int extraDayCount = 0;
        int extraNightCount7 = 0;
        int extraNightCount20 = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        for (ServicesDetail sd : listSD) {

            StartDateServDetail startDateServDetail = sd.getStartDateServDetail();
            EndDateServDetail endDateServDetail = sd.getEndDateServDetail();
            Date startDateServDetail1 = startDateServDetail.getStartDateServDetail();
            Date endDateServDetail1 = endDateServDetail.getEndDateServDetail();

            String localDateTimeStart = convertToLocalDateTimeViaInstant(startDateServDetail1);
            String localDateTimeEnd = convertToLocalDateTimeViaInstant(endDateServDetail1);

            //startHour = String.valueOf(sd.getStartDateServDetail());
            startHour = localDateTimeStart;
            //endHour = String.valueOf(sd.getEndDateServDetail().getEndDateServDetail());
            endHour = localDateTimeEnd;

            boolean isSunday = false;

            LocalTime dateTime1 = LocalTime.parse(startHour, formatter);
            LocalTime dateTime2 = LocalTime.parse(endHour, formatter);
            LocalDateTime start = LocalDateTime.parse(startHour, formatter);
            LocalDateTime finish = LocalDateTime.parse(endHour, formatter);

            var dayOfWeek = start.getDayOfWeek() + "";
            if (dayOfWeek.equals("SUNDAY")) {
                isSunday = true;
            }

            int hourInitial = dateTime1.getHour();
            int minuteInitial = dateTime1.getMinute();
            int hourFinal = dateTime2.getHour();
            int minuteFinal = dateTime2.getMinute();

            if ((hourInitial >= 0 && minuteInitial >= 0) && (hourFinal <= 23 && minuteFinal <= 59)) {

                int hourBegin = Integer.parseInt(dateTime1.getHour() + "");
                long days = HOURS.between(getHourBegin(start), getHourFinish(finish));

                /**Variables ciclo*/
                int zeroToSeven = 7;
                int six = 6;
                int twenty = 20;
                int twentyFour = 24;

                int dayChange = 24;
                //sumando las horas anterios en ele dia
                int cont = (int) (days + hourBegin);
                extraHours = dayCount + nightCount7 + nightCount24;
                for (int i = hourBegin; i < cont; i++) {

                    if (i > dayChange ){
                        /* 7 se convierte en 31 --> sumar 24*/
                        zeroToSeven = zeroToSeven + 24;
                        six = six + 24;
                        twenty = twenty + 24;
                        twentyFour = twentyFour + 24;
                        dayChange = dayChange + 24;
                    }

                    if (isSunday){
                        if (extraHours >= 48){
                            extraSundayCount++;
                        }else{
                            sundayCount++;
                        }

                    }else {

                        if (i < zeroToSeven) {

                            if (extraHours >= 48){
                                extraNightCount7++;
                            }else{
                                nightCount7++;
                            }

                        }

                        if (i > six && i < twenty) {

                            if (extraHours>=48){
                                extraDayCount++;
                            }else{
                                dayCount++;
                            }

                        }

                        if (i >= twenty && i <= twentyFour) {

                            if (extraHours>= 48){
                                extraNightCount20++;
                            }else{
                                nightCount24++;
                            }

                        }
                    }
                }
            }

        }


        hoursWorked = new HoursWorked();
        hoursWorked.setNormalHours(dayCount + "");
        hoursWorked.setNightHours((nightCount7 + nightCount24) + "");
        hoursWorked.setSundayHours(sundayCount + "");
        //hoursWorked.setExtraNormalHours(extraHourDay + "");
        hoursWorked.setExtraNormalHours(extraDayCount + "");
       //hoursWorked.setExtraNightHours(extraHourNight + "");
        hoursWorked.setExtraNightHours((extraNightCount7+extraNightCount20) + "");
        hoursWorked.setExtraSundayHours(extraSundayCount + "");
        return hoursWorked;
    }

    public String convertToLocalDateTimeViaInstant(Date dateToConvert){
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime localDateTime = dateToConvert.toInstant()
                 .atZone(ZoneId.systemDefault())
                 .toLocalDateTime();
        return localDateTime.format(formatter);
    }

    private LocalDateTime getHourBegin(LocalDateTime start){

        int yearInit = start.getYear();
        int monthInit = start.getMonthValue();
        int dayInit = start.getDayOfMonth();
        int hourInit = start.getHour();
        int minuteInit = start.getMinute();


        return LocalDateTime.of(yearInit, monthInit, dayInit,hourInit,minuteInit);

    }
    private LocalDateTime getHourFinish(LocalDateTime finish) {
        int yearFinish = finish.getYear();
        int monthFinish = finish.getMonthValue();
        int dayFinish = finish.getDayOfMonth();
        int hourFinish = finish.getHour();
        int minuteFinish = finish.getMinute();
        return LocalDateTime.of(yearFinish, monthFinish, dayFinish,hourFinish,minuteFinish);
    }
}
