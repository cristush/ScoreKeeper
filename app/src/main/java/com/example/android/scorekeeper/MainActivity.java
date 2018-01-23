package com.example.android.scorekeeper;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamA = 0;
    int yellowCardsTeamA = 0;
    int redCardsTeamA = 0;
    int foulsTeamB = 0;
    int yellowCardsTeamB = 0;
    int redCardsTeamB = 0;

    String[] teams = {"Alaves", "Athletic Bilbao", "Atletico Madrid", "Barcelona", "Celta Vigo",
            "Deportivo", "Eibar", "Espanyol", "Getafe", "Girona", "Las Palmas", "Leganes",
            "Levante", "Malaga", "Real Betis", "Real Madrid", "Real Sociedad", "Sevilla",
            "Valencia", "Villareal"};

    private TypedArray teamLogos;
    private ImageView itemLogoImageA;
    private ImageView itemLogoImageB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Get array values
         */
        String[] teamList = getResources().getStringArray(R.array.teams);
        teamLogos = getResources().obtainTypedArray(R.array.team_logos);
        /**
         * Find views that display logos
         */
        itemLogoImageA = (ImageView) findViewById(R.id.team_a_logo);
        itemLogoImageB = (ImageView) findViewById(R.id.team_b_logo);

        /**
         * Create spinners
         */
        final Spinner spinnerTeamA = (Spinner) findViewById(R.id.team_a);
        final Spinner spinnerTeamB = (Spinner) findViewById(R.id.team_b);

        /**
         * Create adapter for spinner
         */
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, teamList);
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);

        /**
         * Set actions for displaying team logo on item selection of Team A spinner
         */
        spinnerTeamA.setAdapter(spinnerAdapter);
        spinnerTeamA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemLogoImageA.setImageResource(teamLogos.getResourceId(spinnerTeamA.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        /**
         * Set actions for displaying team logo on item selection of Team B spinner
         */
        spinnerTeamB.setAdapter(spinnerAdapter);
        spinnerTeamB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemLogoImageB.setImageResource(teamLogos.getResourceId(spinnerTeamB.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayScoreForTeamA(scoreTeamA);
    }

    /**
     * Increase the number of fouls for Team A
     */
    public void addFoulForTeamA(View v) {
        foulsTeamA = foulsTeamA + 1;
        displayFoulsForTeamA(foulsTeamA);
    }

    /**
     * Increase the number of yellow cards for Team A
     */
    public void addYellowCardForTeamA(View v) {
        yellowCardsTeamA = yellowCardsTeamA + 1;
        displayYellowCardsForTeamA(yellowCardsTeamA);
    }

    /**
     * Increase the number of red cards for Team A
     */
    public void addRedCardForTeamA(View v) {
        redCardsTeamA = redCardsTeamA + 1;
        displayRedCardsForTeamA(redCardsTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays fouls for Team A.
     */
    public void displayFoulsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_fouls);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays yellow cards for Team A.
     */
    public void displayYellowCardsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_yellow_cards);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays red cards for Team A.
     */
    public void displayRedCardsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_red_cards);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayScoreForTeamB(scoreTeamB);
    }

    /**
     * Increase the number of fouls for Team B
     */
    public void addFoulForTeamB(View v) {
        foulsTeamB = foulsTeamB + 1;
        displayFoulsForTeamB(foulsTeamB);
    }

    /**
     * Increase the number of yellow cards for Team B
     */
    public void addYellowCardForTeamB(View v) {
        yellowCardsTeamB = yellowCardsTeamB + 1;
        displayYellowCardsForTeamB(yellowCardsTeamB);
    }

    /**
     * Increase the number of red cards for Team B
     */
    public void addRedCardForTeamB(View v) {
        redCardsTeamB = redCardsTeamB + 1;
        displayRedCardsForTeamB(redCardsTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays fouls for Team B.
     */
    public void displayFoulsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_fouls);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays yellow cards for Team B.
     */
    public void displayYellowCardsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_yellow_cards);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays red cards for Team B.
     */
    public void displayRedCardsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_red_cards);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Reset scores for Team A and Team B
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        foulsTeamA = 0;
        yellowCardsTeamA = 0;
        redCardsTeamA = 0;

        scoreTeamB = 0;
        foulsTeamB = 0;
        yellowCardsTeamB = 0;
        redCardsTeamB = 0;

        displayScoreForTeamA(scoreTeamA);
        displayFoulsForTeamA(foulsTeamA);
        displayYellowCardsForTeamA(yellowCardsTeamA);
        displayRedCardsForTeamA(redCardsTeamA);
        displayScoreForTeamB(scoreTeamB);
        displayFoulsForTeamB(foulsTeamB);
        displayYellowCardsForTeamB(yellowCardsTeamB);
        displayRedCardsForTeamB(redCardsTeamB);
    }
}
