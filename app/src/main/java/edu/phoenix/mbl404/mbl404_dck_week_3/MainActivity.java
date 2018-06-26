package edu.phoenix.mbl404.mbl404_dck_week_3;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Layout items (in order of appearance).
    Spinner teamOne, teamTwo;
    TextView resultsDisplay;

    //Program entry point.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize core layout.

        setContentView(R.layout.activity_main);

        //Bind action bar to variable and bind program Icon to the bar (pure visual/marketing).

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.sisyphus);

        //Bind java variable layout items to layout xml items (in order of appearance).

        teamOne = (Spinner) findViewById(R.id.spinner_team_one);
        teamTwo = (Spinner) findViewById(R.id.spinner_team_two);
        resultsDisplay = (TextView) findViewById(R.id.data_view);

        //Call function to create and bind an adapter to the team spinners.

        teamOneSpinner();
        teamTwoSpinner();
    }

    /* ====== FUNCTION ======
    teamOne and teamTwo Spinner invokes the spinner adapter, sets dropdown options via array in
    values, dropdown layout, and initial position
    */

    public void teamOneSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nfl_teams, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        teamOne.setAdapter(adapter);
        teamOne.setSelection(0);
        teamOne.setOnItemSelectedListener(new TeamSpinnerActivity());
    }

    public void teamTwoSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nfl_teams, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_text);
        teamTwo.setAdapter(adapter);
        teamTwo.setSelection(0);
        teamTwo.setOnItemSelectedListener(new TeamSpinnerActivity());
    }

    /* ====== CLASS ======
    TeamSpinnerActivity class allows for various behaviors to be monitored by the listener,
    specifically position selection data.
     */

    public class TeamSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            Season season = new Season();
            if (teamOne.getSelectedItemPosition() == 0 || teamTwo.getSelectedItemPosition() == 0) {
                resultsDisplay.setText("Select two teams");
            } else if (teamOne.getSelectedItemPosition() == teamTwo.getSelectedItemPosition()) {
                resultsDisplay.setText("The same team cannot play itself.");
            } else {
                switch (teamOne.getSelectedItemPosition()) {
                    case 1: //Cardinals
                        switch (teamTwo.getSelectedItemPosition()) {
                            case 2:
                                teamComp(season.cardinals, "Bears");
                                break;
                            case 3: //Packers
                                teamComp(season.cardinals, "Packers");
                                break;
                            case 4: //Giants
                                teamComp(season.cardinals, "Giants");
                                break;
                        }
                        break;
                    case 2: //Bears
                        switch (teamTwo.getSelectedItemPosition()) {
                            case 1: //Cardinals
                                teamComp(season.bears, "Cardinals");
                                break;
                            case 3: //Packers
                                teamComp(season.bears, "Packers");
                                break;
                            case 4: //Giants
                                teamComp(season.bears, "Giants");
                                break;
                        }
                        break;
                    case 3: //Packers
                        switch (teamTwo.getSelectedItemPosition()) {
                            case 1: //Cardinals
                                teamComp(season.packers, "Cardinals");
                                break;
                            case 2: //Bears
                                teamComp(season.packers, "Bears");
                                break;
                            case 4: //Giants
                                teamComp(season.packers, "Giants");
                                break;
                        }
                        break;
                    case 4: //Giants
                        switch (teamTwo.getSelectedItemPosition()) {
                            case 1: //Cardinals
                                teamComp(season.giants, "Cardinals");
                                break;
                            case 2: //Bears
                                teamComp(season.giants, "Bears");
                                break;
                            case 3: //Packers
                                teamComp(season.giants, "Packers");
                                break;
                        }
                        break;
                }
            }
        }


    public void teamComp(Team teamOne, String teamTwo) {
        for (int i = 0; i < teamOne.getGames().size(); i++) {
            if (teamOne.getGames().get(i).getOpFor().compareTo(teamTwo) == 0) {
                String text = teamOne.getName() + " vs. " + teamOne.getGames().get(i).getOpFor() +
                        "\nQ1:  " + getFQ(teamOne,i) +
                        "\nQ2:  " + getSQ(teamOne,i) +
                        "\nQ3:  " + getTQ(teamOne,i) +
                        "\nQ4 (Final):  " + finalScore(teamOne, i);
                resultsDisplay.setText(text);
                return;
            } else {
                resultsDisplay.setText("These teams did not play eachother!");
                return;
            }
        }
    }

    public String finalScore(Team teamOne, int pos){
        String agr = teamOne.getName();
        String def = teamOne.getGames().get(pos).getOpFor();
        int agrS = teamOne.getGames().get(pos).getFourth().getAgressor();
        int defS = teamOne.getGames().get(pos).getFourth().getDefender();
        if(agrS > defS){
            return Integer.toString(agrS) + " : " + Integer.toString(defS) + " - Winner: " + agr;
        } else {
            return Integer.toString(agrS) + " : " + Integer.toString(defS) + " - Winner: " + def;
        }
    }

    public String getFQ(Team teamOne, int pos){
        return Integer.toString(teamOne.getGames().get(pos).getFirst().getAgressor()) + " : " +
                Integer.toString(teamOne.getGames().get(pos).getFirst().getDefender());
    }

    public String getSQ(Team teamOne, int pos){
        return Integer.toString(teamOne.getGames().get(pos).getSecond().getAgressor()) + " : " +
                Integer.toString(teamOne.getGames().get(pos).getSecond().getDefender());
    }

    public String getTQ(Team teamOne, int pos){
        return Integer.toString(teamOne.getGames().get(pos).getThird().getAgressor()) + " : " +
                Integer.toString(teamOne.getGames().get(pos).getThird().getDefender());
    }


    public void onNothingSelected(AdapterView<?> parent) { }
    }
}
