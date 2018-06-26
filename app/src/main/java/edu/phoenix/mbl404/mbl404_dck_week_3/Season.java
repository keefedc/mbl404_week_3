package edu.phoenix.mbl404.mbl404_dck_week_3;

public class Season {
    Team cardinals, bears, packers, giants;

    String[] carOpfor = {"Bears", "Packers"};
    String[] beaOpfor = {"Cardinals", "Giants"};
    String[] pacOpfor = {"Giants", "Cardinals"};
    String[] giaOpfor = {"Packers", "Bears"};

    int[][] carScore = {{0,0,7,14,14,21,21,28}, //Card vs. Bears
                        {7,0,7,7,14,21,28,21}}; //card vs pack

    int[][] beaScore = {{0,0,14,7,21,14,28,21}, //Bears vs. Card
                        {14,7,21,21,28,21,28,35}}; //bear vs giant

    int[][] pacScore = {{7,7,14,14,21,21,28,21}, //pac vs giants
                        {0,7,7,7,21,14,21,28}}; // pack vs card

    int[][] giaScore = {{7,7,14,14,21,21,21,28}, //giants vs pac
                        {7,14,21,21,21,28,35,28}}; //giant vs bear

    public Season(){
        cardinals = new Team("Cardinals",carOpfor,carScore);
        bears = new Team("Bears",beaOpfor,beaScore);
        packers = new Team("Packers",pacOpfor,pacScore);
        giants = new Team("Giants",giaOpfor,giaScore);
    }
}
