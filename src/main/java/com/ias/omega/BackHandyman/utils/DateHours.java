package com.ias.omega.BackHandyman.utils;

import com.ias.omega.BackHandyman.servicesdetail.aplication.domain.valueObjs.*;
import com.ias.omega.BackHandyman.servicesdetail.aplication.models.ServicesDetail;
import com.ias.omega.BackHandyman.servicesdetail.aplication.others.HoursWorked;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DateHours {

   public final static HoursWorked DATE_HOURS_WORKED =
           new HoursWorked("39","27","0","18","0","0");

   public static Optional<HoursWorked> workedHours(){
       return Optional.of(new HoursWorked("39","27","0","18","0","0"));
   }

   public static List<ServicesDetail> days_worked() throws ParseException {

           return Arrays.asList(
                   new ServicesDetail(
                           new IdServDetail(1L),new IdTechnicalServDetail("1152669883"), new IdServiceClientServDetail(1L),
                           new StartDateServDetail(converterDate("2022-08-12 08:00:33.0")), new EndDateServDetail(converterDate("2022-08-13 08:00:40.0")),new StatusServDetail(1)
                   )
           );


   }

    public static List<ServicesDetail> listEmpty(){
        return Arrays.asList();
    }

//   public final static List<ServicesDetail> DAYS_WORKED;
//
//    static {
//        try {
//            DAYS_WORKED = Arrays.asList(
//                    new ServicesDetail(
//                       new IdServDetail(1L),new IdTechnicalServDetail("1152669883"), new IdServiceClientServDetail(1L),
//                       new StartDateServDetail(converterDate("2022-07-26 01:00:50.0")), new EndDateServDetail(converterDate("2022-07-26 23:00:08.0")),new StatusServDetail(1)
//                    )
////                    ,
////                    new ServicesDetail(
////                            new IdServDetail(2L),new IdTechnicalServDetail("1152669883"), new IdServiceClientServDetail(1L),
////                            new StartDateServDetail(converterDate("2022-07-27 01:00:31.0")), new EndDateServDetail(converterDate("2022-07-27 23:00:33.0")),new StatusServDetail(1)
////                    ),
////                    new ServicesDetail(
////                            new IdServDetail(3L),new IdTechnicalServDetail("1152669883"), new IdServiceClientServDetail(1L),
////                            new StartDateServDetail(converterDate("2022-07-28 01:00:57.0")), new EndDateServDetail(converterDate("2022-07-28 23:00:59.0")),new StatusServDetail(1)
////                    )
//            );
//        } catch (ParseException e) {
//            System.out.println("error --> "+ e.getMessage());
//            throw new RuntimeException(e);
//        }
//    }

    public static Date converterDate(String date) throws ParseException {
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
      Date fecha = formato.parse(date);
      return fecha;
   }




}
