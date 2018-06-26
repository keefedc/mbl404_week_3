package edu.phoenix.mbl404.mbl404_dck_week_3;

public class Game {
    private int week;
    private String opFor;
    private Score first,second,third,fourth;

    public Game(int wek, String opfor, int[] raw){
        this.week = wek;
        this.opFor = opfor;

        this.first = new Score(raw[0], raw[1]);
        this.second = new Score(raw[2], raw[3]);
        this.third = new Score(raw[4], raw[5]);
        this.fourth = new Score(raw[6], raw[7]);

    }

    public int getWeek() {
        return week;
    }

    public String getOpFor() {
        return opFor;
    }

    public Score getFirst() {
        return first;
    }

    public Score getSecond() {
        return second;
    }

    public Score getThird() {
        return third;
    }

    public Score getFourth() {
        return fourth;
    }
}
