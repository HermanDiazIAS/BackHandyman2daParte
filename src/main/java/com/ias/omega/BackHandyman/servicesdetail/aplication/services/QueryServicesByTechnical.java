package com.ias.omega.BackHandyman.servicesdetail.aplication.services;

import com.ias.omega.BackHandyman.servicesdetail.aplication.others.HoursWorked;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.input.QueryServicesByTechnicalUseCase;
import com.ias.omega.BackHandyman.servicesdetail.aplication.ports.output.ServiceDetailRepository;
import com.ias.omega.BackHandyman.utils.WeekNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class QueryServicesByTechnical implements QueryServicesByTechnicalUseCase {

    @Autowired
    private ServiceDetailRepository serviceDetailRepository;

    @Override
    public HoursWorked execute(HashMap s) {
        String id = s.get("idTechnical").toString();
        String semana = s.get("week").toString();
        String startDate = "";
        String endDate = "";
        for (WeekNumber week : WeekNumber.values()) {
            if (week.getName().equals(semana)) {
                startDate = week.getStartDate();
                endDate = week.getEndDate();
            }
        }

        List<ServicesDetail> lista = serviceDetailRepository.queryServices(id, startDate, endDate);
        HoursWorked hoursWorked = numberHours(lista);
        return hoursWorked;
    }

    private HoursWorked numberHours(List<ServicesDetail> lista) {

        String startHour = null;
        String endHour = null;
        HoursWorked hoursWorked = null;

        int contarNocturna7 = 0;
        int contarNocturna24 = 0;
        int contarDiurna = 0;
        int contarDomingo = 0;
        int contarExtraNormal = 0;
        int contarExtraNocturna = 0;
        int contarExtraDomingo = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        for (ServicesDetail sd : lista) {

            startHour = String.valueOf(sd.getStartDateServDetail());
            endHour = String.valueOf(sd.getEndDateServDetail().getEndDateServDetail());
            boolean isSunday = false;
            LocalTime dateTime1 = LocalTime.parse(startHour, formatter);
            LocalTime dateTime2 = LocalTime.parse(endHour, formatter);
            LocalDate start = LocalDate.parse(startHour, formatter);

            var dayOfWeek = start.getDayOfWeek()+"";
            if (dayOfWeek.equals("SUNDAY")) {
                isSunday = true;
            }

            int hoursInit = dateTime1.getHour();
            int minuteInit = dateTime1.getMinute();
            int hoursFin = dateTime2.getHour();
            int minuteFin = dateTime2.getMinute();

            if ((hoursInit >= 0 && minuteInit >= 0) && (hoursFin <= 23 && minuteFin <= 59)) {

                int horaFin = Integer.parseInt(dateTime2.getHour() + "");
                int horaInicio = Integer.parseInt(dateTime1.getHour() + "");

                for (int i = horaInicio; i < horaFin; i++) {

                    if (isSunday){
                        contarDomingo++;
                    }else {
                        if (i < 7) {
                            contarNocturna7++;
                        }

                        if (i > 6 && i < 20) {
                            contarDiurna++;
                        }

                        if (i >= 20 && i < 24) {
                            contarNocturna24++;
                        }
                    }
                }
            }
        }

        int hoursExt = contarDiurna + contarNocturna7 + contarNocturna24;
        if (hoursExt > 48) {
            contarExtraNormal = hoursExt - 48;
        }

        int hoursNoc = contarNocturna7 + contarNocturna24;
        if (hoursNoc > 48){
            contarExtraNocturna = hoursNoc - 48;
        }

        if(contarDomingo > 48){
            contarExtraDomingo = contarDomingo - 48 ;
        }

        hoursWorked = new HoursWorked();
        hoursWorked.setNormalHours(contarDiurna + "");
        hoursWorked.setNightHours((contarNocturna7 + contarNocturna24) + "");
        hoursWorked.setSundayHours(contarDomingo + "");
        hoursWorked.setExtraNormalHours(contarExtraNormal + "");
        hoursWorked.setExtraNightHours(contarExtraNocturna + "");
        hoursWorked.setExtraSundayHours(contarExtraDomingo + "");
        return hoursWorked;
    }
}
