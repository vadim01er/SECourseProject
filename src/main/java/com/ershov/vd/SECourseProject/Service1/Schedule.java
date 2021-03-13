package com.ershov.vd.SECourseProject.Service1;

import lombok.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Date date;
    private String shipName;
    private Cargo cargo;
    private Date parkingTime;

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static Random random = new Random(2021);

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static Date startDate = new GregorianCalendar(2021, Calendar.MARCH, 15).getTime();

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static Date endDate = new GregorianCalendar(2025, Calendar.MARCH, 15).getTime();

    public void autoGenerate(){
        generateDate();
        generateShipName();
        generateCargo();
        generateParkingTime();
    }

    private void generateDate() {
        this.date = new Date(ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime()));
    }

    private void generateShipName() {
        this.shipName = random.nextInt() + " GeneratedShipName";
    }

    private void generateCargo() {
        Cargo cargo = new Cargo();
        cargo.autoGenerate();
        this.cargo = cargo;
    }
    private void generateParkingTime() {
        this.parkingTime = new Date(ThreadLocalRandom.current().nextLong(this.getDate().getTime(), endDate.getTime()));
    }
}
