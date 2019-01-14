package com.bradleypmartinsandbox.catgame;

import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // init global vars
    Button shuffleButton;
    TextView meowText;
    ArrayList<ImageView> cards;
    Random randomGenerator;
    Integer correctGuess;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // default boilerplate for '1-view' app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init values for globals
        cards = new ArrayList<ImageView>();
        randomGenerator = new Random();
        correctGuess = -1;
        mediaPlayer = MediaPlayer.create(this, R.raw.cat_meow);

        // creating references to asset presentations
        meowText = findViewById(R.id.meowText);
        meowText.setText("Please reshuffle the card deck.");

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
                meowText.setText("Tap a card to find the kitty...");
            }
        });

        ImageView card;
        for (int idx=0; idx<3; idx++) {
            card = cards.get(idx);
            card.setTag(idx);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int chosenCard = (int)v.getTag();
                    selectedCard(chosenCard);
                }
            });
        }
    }

    private void selectedCard(int chosenCard) {
        if(correctGuess != -1) {
            ImageView card = cards.get(chosenCard);
            if (chosenCard == correctGuess) {
                card.setImageResource(R.drawable.cat);
                mediaPlayer.start();
                meowText.setText("Meow, you win! Reshuffle to restart.");
            }
            else {
                card.setImageResource(R.drawable.dog);
                meowText.setText("Woof, wrong card! Reshuffle to restart.");
            }
        }
        correctGuess = -1;
    }
}
