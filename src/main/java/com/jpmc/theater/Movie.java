package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing);
    }

    private double getDiscount(Showing showing) {
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        double sequenceDiscount = 0;
        if (showing.getSequenceOfTheDay() == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showing.getSequenceOfTheDay() == 2) {
            sequenceDiscount = 2; // $2 discount for 2nd show
        }
//        else {
//            throw new IllegalArgumentException("failed exception");
//        }

        //1$ discount -> movies showing on 7th
        double seventhDiscount = 0;
        if(LocalDateTime.now().getDayOfMonth()==7){
            seventhDiscount=1;
        }

        // 25% discount -> movies showing starting between 11AM ~ 4pm
        double elevenToFourDiscount=0;
        if (showing.getStartTime().getHour() >=11 && showing.getStartTime().getHour() <=16 ) {
            elevenToFourDiscount = ticketPrice * 0.25;
        }

        // biggest discount wins
        //return specialDiscount > sequenceDiscount ? specialDiscount : sequenceDiscount;
        return Collections.max(Arrays.asList(specialDiscount,sequenceDiscount,seventhDiscount,elevenToFourDiscount));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}