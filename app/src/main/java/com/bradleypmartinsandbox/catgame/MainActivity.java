package com.bradleypmartinsandbox.catgame;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button shuffleButton;
    TextView meowText;
    ArrayList<ImageView> cards;
    Random randomGenerator;
    Integer correctGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cards = new ArrayList<ImageView>();
        randomGenerator = new Random();

        meowText = findViewById(R.id.meowText);

        ImageView card1 = findViewById(R.id.card1);
        cards.add(card1);

        ImageView card2 = findViewById(R.id.card2);
        cards.add(card2);

        ImageView card3 = findViewById(R.id.card3);
        cards.add(card3);

        shuffleButton = findViewById(R.id.shuffleButton);
        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int idx=0; idx<3; idx++) {
                    ImageView card = cards.get(idx);
                    card.setImageResource(R.drawable.card);
                }

                correctGuess = randomGenerator.nextInt(3);
                meowText.setText("Random Shuffle #: " + correctGuess);
            }
        });

        ImageView card;
        for (int idx=0; idx<3; idx++) {
            card = cards.get(idx);
            card.setTag(idx);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
