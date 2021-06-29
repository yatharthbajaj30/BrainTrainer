package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    TextView resultTextView;
    TextView scoreTextView;
    int locationOfCorrectAnswer;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int score=0;
    int numberOfQuestions=0;
    public void chooseAnswer(View view)
    {
        if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()))
        {
            resultTextView.setText("Correct");
            score++;
        }
        else
        {
            resultTextView.setText("Wrong:(");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));

    }

    public void start(View view)
    {
        goButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView sumTextView=findViewById(R.id.sumTextView);
        Button button0=findViewById(R.id.button0);
        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        Button button3=findViewById(R.id.button3);
        resultTextView=findViewById(R.id.resultTextView);
        goButton=findViewById(R.id.goButton);
        sumTextView=findViewById(R.id.sumTextView);
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));
        locationOfCorrectAnswer=rand.nextInt(4);
        for(int i=0;i<4;i++)
        {   if(i==locationOfCorrectAnswer)
        {
            answers.add(a+b);
        }
        else
        {
            int wronganswer=rand.nextInt(41);
            while(wronganswer==(a+b))
            {
                wronganswer=rand.nextInt(41);
            }
            answers.add(wronganswer);
        }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }
}
