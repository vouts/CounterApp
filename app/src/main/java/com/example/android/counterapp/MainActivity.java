package com.example.android.counterapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Define Global variables
     */

    int scorePlayerA, scorePlayerB;
    boolean selectedPlayerA = false, selectedPlayerB = false;

    private void initialization (){
        selectedPlayerA = true;

        LinearLayout li=(LinearLayout) findViewById(R.id.playerA);
        li.setBackgroundResource(R.color.currentPlayerBG);;

        TextView player = (TextView)findViewById(R.id.namePlayerA);
        player.setCompoundDrawablesWithIntrinsicBounds( R.drawable.play, 0, 0, 0);

        Button selectedButton = (Button) findViewById(R.id.plusOne);
        selectedButton.setBackgroundResource(R.color.colorPrimaryDark);;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
    }
}
