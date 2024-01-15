package com.counter.androidviewsui;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView questionTextView,
            correctAnswerTextView,
            falseAnswerTextView;

    private Button trueButton,
            falseButton,
            nextQuestionButton,
            finishButton;


    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<Boolean> answers = new ArrayList<>();

    private static int currentQuestionCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        correctAnswerTextView = findViewById(R.id.correctAnswerTextView);
        falseAnswerTextView = findViewById(R.id.wrongAnswerTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextQuestionButton = findViewById(R.id.nextQuestionButton);
        finishButton = findViewById(R.id.finishButton);


        // Providing the questions and the answers
        questions.add("The color of the sky is blue.");
        answers.add(true);

        questions.add("The color of the ground is brown.");
        answers.add(true);

        questions.add("Lions are part of the insect family.");
        answers.add(false);


        questions.add("Bees don't have a queen.");
        answers.add(false);

        questions.add("People have two arms.");
        answers.add(true);

        String currentQuestion = questions.get(currentQuestionCounter);
        questionTextView.setText(currentQuestion);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });


        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNextQuestion();
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNextQuestion();
            }
        });

    }


    private void displayNextQuestion() {
        if (currentQuestionCounter < questions.size() - 1) {
            currentQuestionCounter++;
        }
        else{
            questionTextView.setVisibility(View.INVISIBLE);
            correctAnswerTextView.setVisibility(View.INVISIBLE);
            nextQuestionButton.setVisibility(View.INVISIBLE);
            trueButton.setVisibility(View.INVISIBLE);
            falseButton.setVisibility(View.INVISIBLE);
            finishButton.setVisibility(View.VISIBLE);
        }

        String currentQuestion = questions.get(currentQuestionCounter);
        questionTextView.setText(currentQuestion);

        correctAnswerTextView.setVisibility(View.INVISIBLE);
        nextQuestionButton.setVisibility(View.INVISIBLE);

        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);
    }

    private void checkAnswer(boolean answer) {
        boolean currentAnswer = answers.get(currentQuestionCounter);
        if (currentAnswer == answer) {

            nextQuestionButton.setVisibility(View.VISIBLE);

            correctAnswerTextView.setVisibility(View.VISIBLE);

            trueButton.setVisibility(View.INVISIBLE);
            falseButton.setVisibility(View.INVISIBLE);

            falseAnswerTextView.setVisibility(View.INVISIBLE);

        } else {

            nextQuestionButton.setVisibility(View.INVISIBLE);

            correctAnswerTextView.setVisibility(View.INVISIBLE);
            falseAnswerTextView.setVisibility(View.VISIBLE);

            trueButton.setVisibility(View.VISIBLE);
            falseButton.setVisibility(View.VISIBLE);
        }
    }

}


