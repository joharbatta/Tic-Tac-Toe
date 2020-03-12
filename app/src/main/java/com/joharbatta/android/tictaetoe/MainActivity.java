package com.joharbatta.android.tictaetoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import javax.security.auth.x500.X500Principal;

public class MainActivity extends AppCompatActivity {

//    0-O
//    1-X
    boolean gameActive=true;
    int activePlayer=0;
    int gameValues[] = {2,2,2,2,2,2,2,2,2};
    int player1Win = 0;
    int player2Win = 0;
    int winnerPlayer = -1;
    int winPositions [][] = { {0,1,2} , {3,4,5} , {6,7,8},
            {0,3,6} , {1,4,7} , {2,5,8},
            {0,4,8} , {2,4,6}
    };
    public void Tap(View view)
    {
        ImageView imageView=(ImageView)view;
        int tapBlock=Integer.parseInt(view.getTag().toString());
        boolean draw = true;

        for(int i=0;i<=8;i++)
        {
            if(gameValues[i]==2)
            {
                draw = false;
                break;
            }
        }
        if(draw == true)    //as if draw condition occurs after 9th tap when i click it reset as game value array changes completely so draw boolean remain true
        {
            reset(view);
        }
        if(!gameActive)
        {
            reset(view);
        }
        else if(gameValues[tapBlock]==2 && gameActive)
        {
            gameValues[tapBlock] = activePlayer;
            imageView.setTranslationY(-1000f);
            if (activePlayer == 0)
            {
                imageView.setImageResource(R.drawable.zero);
                activePlayer = 1;
                TextView turn=findViewById(R.id.playerTurn);
                turn.setText("X's Turn");
            }
             else
                {
                imageView.setImageResource(R.drawable.cross);
                activePlayer = 0;
                TextView turn=findViewById(R.id.playerTurn);
                turn.setText("O's Turn");
                }

            imageView.animate().translationYBy(1000f).setDuration(200);

            for(int winPosition[]: winPositions)
            {
                if(gameValues[winPosition[0]]!=2 && gameValues[winPosition[0]]==gameValues[winPosition[1]] && gameValues[winPosition[1]]==gameValues[winPosition[2]])
                {
                    String winner;
                    gameActive=false;
                    if(gameValues[winPosition[0]]==0)
                    {
                        winner="O has won";
                        player1Win++;
                        TextView playerWiins = findViewById(R.id.textView4);
                        playerWiins.setText("O's Wins: " + player1Win);
                        winnerPlayer = 0;
                    }
                    else
                    {
                        winner = "X has won!!!";
                        player2Win++;
                        TextView playerWiins = findViewById(R.id.textView5);
                        playerWiins.setText("X's Wins: " + player2Win);
                        winnerPlayer = 1;
                    }
                    TextView turn=findViewById(R.id.playerTurn);
                    turn.setText(winner);

                }
            }
        }
        else
        {
            TextView turn = findViewById(R.id.playerTurn);
            turn.setText("Wrong Choice!!!");
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
