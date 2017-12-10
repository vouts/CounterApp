package com.example.android.counterapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Define Global variables
     */

    int scorePlayerA, scorePlayerB, shotsLeft = 3, currentTurnScore;
    boolean selectedPlayerA = false, selectedPlayerB = false, plusOne = false, plusTwo = false, plusThree = false, winner = false;

    /**
     * Starts the game and sets Player A as active player
     */

    private void initialization() {
        selectedPlayerA = true;
        selectedPlayerB = false;
        plusOne = true;
        plusTwo = false;
        plusThree = false;
        scorePlayerB = 301;
        scorePlayerA = 301;
        shotsLeft = 3;
        currentTurnScore = 0;
        winner = false;

        printShotsPlayerA(Integer.toString(shotsLeft));
        printShotsPlayerB(Integer.toString(shotsLeft));

        printScorePlayerA(Integer.toString(scorePlayerA));
        printScorePlayerB(Integer.toString(scorePlayerB));

        LinearLayout liPlayerA = (LinearLayout) findViewById(R.id.playerB);
        liPlayerA.setBackgroundResource(R.color.white);

        LinearLayout liPlayerB = (LinearLayout) findViewById(R.id.playerA);
        liPlayerB.setBackgroundResource(R.color.currentPlayerBG);

        TextView playerA = (TextView) findViewById(R.id.namePlayerB);
        playerA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

        TextView playerB = (TextView) findViewById(R.id.namePlayerA);
        playerB.setCompoundDrawablesWithIntrinsicBounds(R.drawable.play, 0, 0, 0);



    }

    /**
     * Display score for player A
     */
    private void printScorePlayerA(String result) {

        TextView resultView = (TextView) findViewById(R.id.scorePlayerA);
        resultView.setText(String.valueOf(result));
    }

    /**
     * Display remaining Darts for player A
     */
    private void printShotsPlayerA(String result) {

        TextView resultView = (TextView) findViewById(R.id.shotsPlayerA);
        resultView.setText(String.valueOf(result));
    }

    /**
     * Display remaining Darts for player B
     */
    private void printShotsPlayerB(String result) {

        TextView resultView = (TextView) findViewById(R.id.shotsPlayerB);
        resultView.setText(String.valueOf(result));
    }

    /**
     * Display score for player B
     */
    private void printScorePlayerB(String result) {

        TextView resultView = (TextView) findViewById(R.id.scorePlayerB);
        resultView.setText(String.valueOf(result));
    }

    /**
     * Set Booleans and background when x1 is pressed
     */

    public void setPlusOne(View view) {
        plusOne = true;
        plusTwo = false;
        plusThree = false;

        Button selectedButton = (Button) findViewById(R.id.plusOne);
        selectedButton.setBackgroundResource(R.color.colorPrimaryDark);

        Button otherButton1 = (Button) findViewById(R.id.plusTwo);
        otherButton1.setBackgroundResource(R.color.buttonColor);

        Button otherButton2 = (Button) findViewById(R.id.plusThree);
        otherButton2.setBackgroundResource(R.color.buttonColor);
    }

    /**
     * Set Booleans and background when x2 is pressed
     */

    public void setPlusTwo(View view) {
        plusOne = false;
        plusTwo = true;
        plusThree = false;

        Button selectedButton = (Button) findViewById(R.id.plusTwo);
        selectedButton.setBackgroundResource(R.color.colorPrimaryDark);

        Button otherButton1 = (Button) findViewById(R.id.plusOne);
        otherButton1.setBackgroundResource(R.color.buttonColor);

        Button otherButton2 = (Button) findViewById(R.id.plusThree);
        otherButton2.setBackgroundResource(R.color.buttonColor);
    }

    /**
     * Set Booleans and background when x3 is pressed
     */

    public void setPlusThree(View view) {
        plusOne = false;
        plusTwo = false;
        plusThree = true;

        Button selectedButton = (Button) findViewById(R.id.plusThree);
        selectedButton.setBackgroundResource(R.color.colorPrimaryDark);

        Button otherButton1 = (Button) findViewById(R.id.plusOne);
        otherButton1.setBackgroundResource(R.color.buttonColor);

        Button otherButton2 = (Button) findViewById(R.id.plusTwo);
        otherButton2.setBackgroundResource(R.color.buttonColor);
    }

    /**
     * Change players turn
     */
    private void changeTurn() {
        plusOne = true;
        plusTwo = false;
        plusThree = false;
        currentTurnScore = 0;


        Button selectedButton = (Button) findViewById(R.id.plusOne);
        selectedButton.setBackgroundResource(R.color.colorPrimaryDark);

        Button otherButton1 = (Button) findViewById(R.id.plusTwo);
        otherButton1.setBackgroundResource(R.color.buttonColor);

        Button otherButton2 = (Button) findViewById(R.id.plusThree);
        otherButton2.setBackgroundResource(R.color.buttonColor);

        if (selectedPlayerA) {

            selectedPlayerA = false;
            selectedPlayerB = true;

            printShotsPlayerA(Integer.toString(shotsLeft));
            shotsLeft = 3;
            printShotsPlayerB(Integer.toString(shotsLeft));

            LinearLayout liPlayerA = (LinearLayout) findViewById(R.id.playerA);
            liPlayerA.setBackgroundResource(R.color.white);

            LinearLayout liPlayerB = (LinearLayout) findViewById(R.id.playerB);
            liPlayerB.setBackgroundResource(R.color.currentPlayerBG);

            TextView playerA = (TextView) findViewById(R.id.namePlayerA);
            playerA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

            TextView playerB = (TextView) findViewById(R.id.namePlayerB);
            playerB.setCompoundDrawablesWithIntrinsicBounds(R.drawable.play, 0, 0, 0);


        } else {
            selectedPlayerA = true;
            selectedPlayerB = false;

            printShotsPlayerB(Integer.toString(shotsLeft));
            shotsLeft = 3;
            printShotsPlayerA(Integer.toString(shotsLeft));

            LinearLayout liPlayerA = (LinearLayout) findViewById(R.id.playerB);
            liPlayerA.setBackgroundResource(R.color.white);

            LinearLayout liPlayerB = (LinearLayout) findViewById(R.id.playerA);
            liPlayerB.setBackgroundResource(R.color.currentPlayerBG);

            TextView playerA = (TextView) findViewById(R.id.namePlayerB);
            playerA.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

            TextView playerB = (TextView) findViewById(R.id.namePlayerA);
            playerB.setCompoundDrawablesWithIntrinsicBounds(R.drawable.play, 0, 0, 0);
        }
    }

    /**
     * Set the correct number and update the score
     */
    private void setNumbers(String content) {
        boolean bullsEye = false;
        int scoreCheck;
        int target = Integer.parseInt(content);
        if (target == 25) {
            currentTurnScore = currentTurnScore + target;
        } else if (target == 50) {
            bullsEye = true;
            currentTurnScore = currentTurnScore + target;
        } else if (plusTwo) {
            target = target * 2;
            currentTurnScore = currentTurnScore + target;
        } else if (plusThree) {
            target = target * 3;
            currentTurnScore = currentTurnScore + target;
        } else {
            currentTurnScore = currentTurnScore + target;
        }
        shotsLeft = shotsLeft - 1;

        if (selectedPlayerA) {
            printShotsPlayerA(Integer.toString(shotsLeft));
        } else {
            printShotsPlayerB(Integer.toString(shotsLeft));
        }
        if (selectedPlayerA) {

            scoreCheck = scorePlayerA - currentTurnScore;
            if (scoreCheck == 0 && (bullsEye || plusTwo)) {
                printScorePlayerA("Winner!!");
                winner = true;
            } else if (scoreCheck <= 1) {
                printScorePlayerA("Bust " + Integer.toString(scorePlayerA));
                changeTurn();
            } else if (scoreCheck > 0 && shotsLeft == 0) {
                scorePlayerA = scorePlayerA - currentTurnScore;
                printScorePlayerA(Integer.toString(scorePlayerA));
            } else if (scoreCheck > 0 && shotsLeft > 0) {
                printScorePlayerA(Integer.toString(scoreCheck));
            }

        } else {

            scoreCheck = scorePlayerB - currentTurnScore;
            if (scoreCheck == 0 && (bullsEye || plusTwo)) {
                printScorePlayerB("Winner!!");
            } else if (scoreCheck <= 1) {
                printScorePlayerB("Bust " + Integer.toString(scorePlayerB));
                changeTurn();
            } else if (scoreCheck > 0 && shotsLeft == 0) {
                scorePlayerB = scorePlayerB - currentTurnScore;
                printScorePlayerB(Integer.toString(scorePlayerB));
            } else if (scoreCheck > 0 && shotsLeft > 0) {
                printScorePlayerB(Integer.toString(scoreCheck));
            }

        }

        if (shotsLeft == 0) {
            changeTurn();
        }

    }

    /**
     * change turn after miss
     */
    public void zero(View view) {
        if (!winner) {
            changeTurn();
        }
    }

    /**
     * change turn after miss
     */
    public void reset(View view) {
        initialization();
    }


    /**
     * Get the text of the button and place it to the Variable
     */
    public void getNumberFromText(View view) {

        if (!winner) {
            Button resultView = (Button) view;
            String textContent = resultView.getText().toString();
            setNumbers(textContent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }
}
