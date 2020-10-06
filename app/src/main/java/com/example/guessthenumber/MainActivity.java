        package com.example.guessthenumber;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Random;

        public class MainActivity extends AppCompatActivity implements View.OnClickListener{

            public static final int MAX_NUMBER = 100;
            //set the highest number to 100
            public static final Random RANDOM = new Random();
            //generate a random number
            private EditText numberEnteredEt;
            private Button mSubmit;
            private TextView msgTv;
            private int numberToFind, numberTries;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                numberEnteredEt = (EditText) findViewById(R.id.TnEnter);
                mSubmit = (Button) findViewById(R.id.btnSubmit);
                msgTv = (TextView) findViewById(R.id.tvComment);
                mSubmit.setOnClickListener((View.OnClickListener) this);

                newGame();
            }
                @Override
                public void onClick (View view){
                    if (view == mSubmit) {
                        mSubmit();
                        //when user click submit, it will be directed to the mSubmit class
                    }
                }

            private void mSubmit() {
                int n = Integer.parseInt(numberEnteredEt.getText().toString());
            //get the value of the number entered
            if (numberTries < 2){
            Toast.makeText(this, "Out of turns! the correct number is " + numberToFind, Toast.LENGTH_SHORT).show();
                newGame();
                //end the game after 5 turn and reveal the correct answer
            }
            else{
                if (n == numberToFind) {
                    Toast.makeText(this, "Congratulation ! You found the number", Toast.LENGTH_SHORT).show();
                    newGame();
                    //if the number entered equal number to find the game will end
                } else if (n > numberToFind) {
                    msgTv.setText("Too High!");
                    //if the number entered is higher than number to find the game will display a message
                } else if (n < numberToFind) {
                    msgTv.setText("Too Low!");
                    //if the number entered is lower than number to find the game will display a message
                }
                numberTries--;

            }

            }
            private void newGame() {
                    numberToFind = RANDOM.nextInt(MAX_NUMBER) + 1;
                    msgTv.setText("");
                    numberEnteredEt.setText("");
                    numberTries = 5;
                 //reset the game
            }
        }