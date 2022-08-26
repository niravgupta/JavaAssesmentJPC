package com.jpmc.theater;

import java.time.LocalDateTime;

public class ScheduleClass {

    private int sequenceOfTheDay;
    private String showStartTime;
    private String movieTitle;
    private String runningTime;
    private Double movieFee;

    public ScheduleClass(int sequenceOfTheDay, LocalDateTime showStartTime, String movieTitle, String runningTime, Double movieFee) {
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime.toString();
        this.movieTitle = movieTitle;
        this.runningTime = runningTime;
        this.movieFee = movieFee;
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    public String getShowStartTime() {
        return showStartTime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public Double getMovieFee() {
        return movieFee;
    }
}
