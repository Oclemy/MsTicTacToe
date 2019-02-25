package info.camposha.mstictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView info;
    Button playAgainBtn, quiteGameBtn;
    int move = 1; // 1 for player 1 move and 2 for player 2 move
    boolean gameEnd = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.info);
        playAgainBtn = findViewById(R.id.playAgainBtn);
        quiteGameBtn = findViewById(R.id.quiteGameBtn);

        info.setText("Player One's turn"); // turn is move
        playAgainBtn.setEnabled(false);
        playAgainBtn.setAlpha(0.2f);
    }
    public void marked(View view) {
        if (!gameEnd) {
            ImageView box = (ImageView) view;
            // following code will mark the box tic or cross according to the player move
            // tic and cross marked will helped us to check who's the winner
            if (box.getTag() != "tic" && box.getTag() != "cross") {
                if (move <= 9) // to set player move and check game is draw or not
                {
                    if (move % 2 != 0 || move == 1) // player's 1 moves
                    {
                        box.setImageResource(R.drawable.tic);
                        box.setTag("tic");
                        boolean check = test();
                        if (check == true) {
                            // player 1 win
                            info.setText("*** Player 1 Wins ***");
                            playAgainBtn.setEnabled(true);
                            playAgainBtn.setAlpha(1f);
                            // stop the game
                            gameEnd = true;
                        } else {
                            if (move == 9) {
                                info.setText("*** Game Draw ***");
                                playAgainBtn.setEnabled(true);
                                playAgainBtn.setAlpha(1f);
                                gameEnd = true;
                            } else {
                                move++;
                                info.setText("Player Two's turn"); // turn is move
                            }
                        }
                    } else // if(move%2 == 0) ,if player's 2 move
                    {
                        box.setImageResource(R.drawable.cross);
                        box.setTag("cross");
                        boolean check = test();
                        if (check == true) {
                            // player 2 win
                            info.setText("*** Player 2 Wins ***");
                            playAgainBtn.setEnabled(true);
                            playAgainBtn.setAlpha(1f);
                            // stop the game
                            gameEnd = true;
                        } else {
                            move++;
                            info.setText("Player One's turn"); // turn is move
                        }
                    }
                }

            } else {
                if (move <= 9) {Log.i("info", "Already marked");}
            }

        } else {
            info.setText("Game is completed"); // turn is move
            Toast.makeText(this, "Game is completed", Toast.LENGTH_SHORT).show();
        }
    } // for marked the box on click

    public boolean test() {
        ImageView box1 = findViewById(R.id.box1);
        ImageView box2 = findViewById(R.id.box2);
        ImageView box3 = findViewById(R.id.box3);
        ImageView box4 = findViewById(R.id.box4);
        ImageView box5 = findViewById(R.id.box5);
        ImageView box6 = findViewById(R.id.box6);
        ImageView box7 = findViewById(R.id.box7);
        ImageView box8 = findViewById(R.id.box8);
        ImageView box9 = findViewById(R.id.box9);


        // player win
// no player win
        return box1.getTag() == box2.getTag() && box2.getTag() == box3.getTag() ||
                box4.getTag() == box5.getTag() && box5.getTag() == box6.getTag() ||
                box7.getTag() == box8.getTag() && box8.getTag() == box9.getTag() ||
                box1.getTag() == box4.getTag() && box4.getTag() == box7.getTag() ||
                box2.getTag() == box5.getTag() && box5.getTag() == box8.getTag() ||
                box3.getTag() == box6.getTag() && box6.getTag() == box9.getTag() ||
                box1.getTag() == box5.getTag() && box5.getTag() == box9.getTag() ||
                box3.getTag() == box5.getTag() && box5.getTag() == box7.getTag();
    }  // fot test any player win or not

    public void reset(View view) {
        ImageView box1 = findViewById(R.id.box1);
        ImageView box2 = findViewById(R.id.box2);
        ImageView box3 = findViewById(R.id.box3);
        ImageView box4 = findViewById(R.id.box4);
        ImageView box5 = findViewById(R.id.box5);
        ImageView box6 = findViewById(R.id.box6);
        ImageView box7 = findViewById(R.id.box7);
        ImageView box8 = findViewById(R.id.box8);
        ImageView box9 = findViewById(R.id.box9);


        move = 1;
        gameEnd = false;
        box1.setTag("1");
        box2.setTag("2");
        box3.setTag("3");
        box4.setTag("4");
        box5.setTag("5");
        box6.setTag("6");
        box7.setTag("7");
        box8.setTag("8");
        box9.setTag("9");
        box1.setImageResource(R.drawable.nothing);
        box2.setImageResource(R.drawable.nothing);
        box3.setImageResource(R.drawable.nothing);
        box4.setImageResource(R.drawable.nothing);
        box5.setImageResource(R.drawable.nothing);
        box6.setImageResource(R.drawable.nothing);
        box7.setImageResource(R.drawable.nothing);
        box8.setImageResource(R.drawable.nothing);
        box9.setImageResource(R.drawable.nothing);

        info.setText("Player One's turn");
        playAgainBtn.setEnabled(false);
        playAgainBtn.setAlpha(0.2f);

    }  // To reset the game

    public void quiteGame(View view) {
        finish();
    }
}
//end