package com.vikas.quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz5 extends AppCompatActivity implements View.OnClickListener {

    // setting up things
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private ImageView Image;
    private TextView questionTextView;
    private Button btnReset;
    private int correct = 0;
    // to keep current question track
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            // array of objects of class Question
            // providing questions from string
            // resource and the correct ans
            new Question(R.string.a5, false),
            new Question(R.string.b5, false),
            new Question(R.string.c5, true),
            new Question(R.string.d5, true),
            new Question(R.string.e5, false),
            new Question(R.string.f5, false),};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        // setting up the buttons
        // associated with id
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
//        prevButton = findViewById(R.id.prev_button);
        btnReset = findViewById(R.id.btnreset);
        // register our buttons to listen to
        // click events
        questionTextView = findViewById(R.id.answer_text_view);
        Image = findViewById(R.id.myimage);
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }
    public void nextQuestion(){
        // go to next question
        // limiting question bank range
        if (currentQuestionIndex < 7) {
            currentQuestionIndex = currentQuestionIndex + 1;
            // we are safe now!
            // last question reached
            // making buttons
            // invisible
            if (currentQuestionIndex == 6) {
                questionTextView.setText(getString(
                        R.string.correct, correct));
                nextButton.setVisibility(View.INVISIBLE);
//                prevButton.setVisibility(View.INVISIBLE);
                trueButton.setVisibility(View.INVISIBLE);
                falseButton.setVisibility(View.INVISIBLE);
                btnReset.setVisibility(View.VISIBLE);
                if (correct > 3) {
                    Image.setImageResource(R.drawable.happy);
                    questionTextView.setText("CORRECTNESS IS " + correct + " " + "OUT OF 6");
                }
                // showing correctness
                else
                    Image.setImageResource(
                            R.drawable.sad);
                // if correctness<3 showing sad emoji
            }
            else {
                updateQuestion();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v)
    {
        // checking which button is
        // clicked by user
        // in this case user choose false
        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                nextQuestion();
                break;

            case R.id.true_button:
                checkAnswer(true);
                nextQuestion();
                break;


            case R.id.btnreset:
                // Restarting the activity
                Intent intent =  new Intent(Quiz5.this,MainMenuActivity.class);
                startActivity(intent);

            case R.id.next_button:
                nextQuestion();

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion()
    {
        Log.d("Current",
                "onClick: " + currentQuestionIndex);

        questionTextView.setText(
                questionBank[currentQuestionIndex]
                        .getAnswerResId());
        // setting the textview with new question
        switch (currentQuestionIndex) {
            case 1:
                // setting up image for each
                // question
                Image.setImageResource(R.drawable.gk);
                break;
            case 2:
                Image.setImageResource(R.drawable.gk);
                break;
            case 3:
                Image.setImageResource(R.drawable.gk);
                break;
            case 4:
                Image.setImageResource(R.drawable.gk);
                break;
            case 5:
                Image.setImageResource(R.drawable.gk);
                break;
            case 6:
                Image.setImageResource(R.drawable.gk);
                break;
            case 7:
                Image.setImageResource(R.drawable.gk);
                break;
        }
    }
    private void checkAnswer(boolean userChooseCorrect)
    {
        boolean answerIsTrue
                = questionBank[currentQuestionIndex]
                .isAnswerTrue();
        // getting correct ans of current question
        int toastMessageId;
        // if ans matches with the
        // button clicked

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
        }
        else {
            // showing toast
            // message correct
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(Quiz5.this, toastMessageId,Toast.LENGTH_SHORT).show();
    }
}