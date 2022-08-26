package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {

    @Test
    void specialMovieWith50PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(9.375, spiderMan.calculateTicketPrice(showing));
        System.out.println("1. current time is - " + LocalDateProvider.singleton().currentDateTime());
        System.out.println("1. movie show time is - " + showing.getStartTime().toString());
        System.out.println("1. Calculated price is - " + spiderMan.calculateTicketPrice(showing));
        //System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void specialMovieWithRegularDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 30, 00, 342001212)));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
        System.out.println("2. current time is - " + LocalDateProvider.singleton().currentDateTime());
        System.out.println("2. movie show time is - " + showing.getStartTime().toString());
        System.out.println("2. Calculated price is - " + spiderMan.calculateTicketPrice(showing));
        //System.out.println(Duration.ofMinutes(90));
    }
}
