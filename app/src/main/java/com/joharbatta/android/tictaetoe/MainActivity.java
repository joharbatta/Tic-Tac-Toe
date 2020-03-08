package com.joharbatta.android.tictaetoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;
    int gameValues[] = {2,2,2,2,2,2,2,2,2};
    int winPosition [][] = { {0,1,2} , {3,4,5} , {6,7,8},
            {0,3,6} , {1,4,7} , {2,5,8},
            {0,4,8} , {2,4,6}
    };

    public void Tap(View view)
    {
        ImageView imageView=(ImageView)view;
        int tapBlock=Integer.parseInt(view.getTag().toString());

        if(gameValues[tapBlock]==2) {
            gameValues[tapBlock] = activePlayer;
            imageView.setTranslationY(-1000f);
            if (activePlayer == 0) {
                imageView.setImageResource(R.drawable.cross);
                activePlayer = 1;
            } else {
                imageView.setImageResource(R.drawable.zero);
                activePlayer = 0;
            }

            imageView.animate().translationYBy(1000f).setDuration(300);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
