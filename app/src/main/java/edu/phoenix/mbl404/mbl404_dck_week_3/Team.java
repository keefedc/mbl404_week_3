package edu.phoenix.mbl404.mbl404_dck_week_3;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Game> games = new ArrayList();

    public Team(String name, String[] opfor, int[][] scoreMatrix){
        this.name = name;

        for (int i = 0; i < opfor.length; i++){
            this.games.add(new Game(i+1,opfor[i],scoreMatrix[i]));
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Game> getGames() {
        return games;
    }
}
