package edu.phoenix.mbl404.mbl404_dck_week_3;

public class Score {
    private int agressor, defender;

    public Score(int agr, int def){
        this.agressor = agr;
        this.defender = def;
    }

    public int getAgressor() {
        return agressor;
    }

    public int getDefender() {
        return defender;
    }
}
