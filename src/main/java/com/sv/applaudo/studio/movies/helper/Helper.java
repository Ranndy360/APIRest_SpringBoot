package com.sv.applaudo.studio.movies.helper;

import com.sv.applaudo.studio.movies.model.Rental;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class Helper {

    @Value("config.days-rent")
    private int daysRent;

    public Rental setDates(Rental rental){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        Date today = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        rental.setRental_date(today);
        localDate = LocalDate.now().plusDays(daysRent);
        rental.setReturn_date(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));

        return rental;
    }
}
