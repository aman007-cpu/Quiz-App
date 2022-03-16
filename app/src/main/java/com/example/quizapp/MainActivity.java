package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView optionA,optionB, optionC,optionD;
    private TextView questionnumber , question, score;
    private TextView checkout1, checkout2;
    int currentIndex;
    int mscore=0;
    int qn=1;
    ProgressBar progressBar;
    int currentque, currentopA, currentopB,currentopC,currentopD;


    private answer[] questionbank = new answer[]{
         new answer(R.string.que1,R.string.que1_A,R.string.que1_B,R.string.que1_C,R.string.que1_D,R.string.ans1),
         new answer(R.string.que2,R.string.que2_A,R.string.que2_B,R.string.que2_C,R.string.que2_D,R.string.ans2),
         new answer(R.string.que3,R.string.que3_A,R.string.que3_B,R.string.que3_C,R.string.que3_D,R.string.ans3),
         new answer(R.string.que4,R.string.que4_A,R.string.que4_B,R.string.que4_C,R.string.que4_D,R.string.ans4),
         new answer(R.string.que5,R.string.que5_A,R.string.que5_B,R.string.que5_C,R.string.que5_D,R.string.ans5),
         new answer(R.string.que6,R.string.que6_A,R.string.que6_B,R.string.que6_C,R.string.que6_D,R.string.ans6),
         new answer(R.string.que7,R.string.que7_A,R.string.que7_B,R.string.que7_C,R.string.que7_D,R.string.ans7),
         new answer(R.string.que8,R.string.que8_A,R.string.que8_B,R.string.que8_C,R.string.que8_D,R.string.ans8),


    };
    final int PROGRESS_BAR = (int) Math.ceil(100/questionbank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    optionA = findViewById(R.id.optionA);
    optionB = findViewById(R.id.optionB);
    optionC = findViewById(R.id.optionC);
    optionD = findViewById(R.id.optionD);

    question = findViewById(R.id.question);
    score = findViewById(R.id.score);
    questionnumber = findViewById(R.id.questionno);
    checkout1 = findViewById(R.id.selectedoption);
    checkout2 = findViewById(R.id.correctans);
    progressBar = findViewById(R.id.progressbar);

   currentque = questionbank[currentIndex].getQuestionid();
   question.setText(currentque);
   currentopA = questionbank[currentIndex].getOptionA();
   optionA.setText(currentopA);
   currentopB = questionbank[currentIndex].getOptionB();
        optionB.setText(currentopB);
        currentopC = questionbank[currentIndex].getOptionC();
        optionC.setText(currentopC);
        currentopD = questionbank[currentIndex].getOptionD();
        optionD.setText(currentopD);

   optionA.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           checkans(currentopA);
           updatequestion();

       }
   });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkans(currentopB);
                updatequestion();

            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkans(currentopC);
                updatequestion();

            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkans(currentopD);
                updatequestion();

            }
        });


    }

    private void checkans(int userselection) {
      int correctanswer = questionbank[currentIndex].getAnswerid();
      checkout1.setText(userselection);
      checkout2.setText(correctanswer);
      String m = checkout1.getText().toString().trim();
      String n  = checkout2.getText().toString().trim();
      if(m.equals(n)){
          Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
          mscore = mscore +1;
      }
          else {
          Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
      }
    }

    private void updatequestion() {


        currentIndex = (currentIndex+1)%questionbank.length;

        if(currentIndex==0){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("GAME OVER");
            alert.setCancelable(false);
            alert.setMessage("Your Score" + mscore + "points");
            alert.setPositiveButton("Closs App ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mscore = 0;
                    qn =1;
                    progressBar.setProgress(0);
                    score.setText("Score" + mscore + "/" + questionbank.length);
                    questionnumber.setText(qn + "/" + questionbank.length + "Question");
                }
            });
            alert.show();
        }
        currentque = questionbank[currentIndex].getQuestionid();
        question.setText(currentque);
        currentopA = questionbank[currentIndex].getOptionA();
        optionA.setText(currentopA);
        currentopB = questionbank[currentIndex].getOptionB();
        optionB.setText(currentopB);
        currentopC = questionbank[currentIndex].getOptionC();
        optionC.setText(currentopC);
        currentopD = questionbank[currentIndex].getOptionD();
        optionD.setText(currentopD);

        qn = qn + 1;
        if(qn<=questionbank.length){
            questionnumber.setText(qn + "/" + questionbank.length + "Question");
        }
        score.setText("Score" + mscore + "/" + questionbank.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);
    }
}