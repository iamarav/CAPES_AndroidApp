package com.dozyapps.capes;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.Random;

public class U_Quiz extends AppCompatActivity {

    //for timer
    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    //

    Button answer1, answer2, answer3, answer4;
    TextView score, question;


    private Questions mQuestions = new Questions();

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u__quiz_final);

        //timer
        mTextViewCountDown = findViewById(R.id.text_view_countdown);

//        mButtonStartPause = findViewById(R.id.button_start_pause);
//        mButtonReset = findViewById(R.id.button_reset);

        //

        startTimer();

        r = new Random();

        answer1 = (Button) findViewById(R.id.answer_1);
        answer2 = (Button) findViewById(R.id.answer_2);
        answer3 = (Button) findViewById(R.id.answer_3);
        answer4 = (Button) findViewById(R.id.answer_4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        score.setText("Score: "+ mScore);

        updateQuestion(r.nextInt(mQuestionsLength));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: "+ mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else {
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer2.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: "+ mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else {
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer3.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: "+ mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else {
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer4.getText() == mAnswer){
                    mScore++;
                    score.setText("Score: "+ mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                }
                else {
                    gameOver();
                }
            }
        });

    }


    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);

    }


    private void gameOver() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Game Over! Your Score is: "+mScore+" points")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), U_Quiz.class));
                                finish();
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                gameOver();
            }
        }.start();

        mTimerRunning = true;
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();

    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText("Time Left: "+timeLeftFormatted);
    }

}
