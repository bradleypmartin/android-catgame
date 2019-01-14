package com.bradleypmartinsandbox.catgame;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button shuffleButton;
    TextView meowText;
    ArrayList cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shuffleButton = (Button)findViewById(R.id.shuffleButton);
        meowText = (TextView)findViewById(R.id.meowText);
        cards = new ArrayList<ImageView>();

        ImageView card1 = (ImageView)findViewById(R.id.card1);
        cards.add(card1);

        ImageView card2 = (ImageView)findViewById(R.id.card2);
        cards.add(card2);

        ImageView card3 = (ImageView)findViewById(R.id.card3);
        cards.add(card3);
    }
}
