package com.enigma.android.questionlevelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    List<Question> questList;
    int score=0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion;
    Button btnNext;
    RadioButton rda, rdb, rdc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelper db = new DbHelper(this);
        questList= db.getAllQuestions();
        currentQ = questList.get(qid);
        txtQuestion= findViewById(R.id.textView1);
        rda = findViewById(R.id.radio0);
        rdb = findViewById(R.id.radio1);
        rdc = findViewById(R.id.radio2);
        btnNext = findViewById(R.id.button1);
        setQuestionView();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup group = findViewById(R.id.radioGroup1);
                RadioButton answer = findViewById(group.getCheckedRadioButtonId());
                Log.d("your answer", currentQ.getANSWER()+ " " +answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())){
                    score++;
                    Log.d("score", "Your score " + score);
                }
                if (qid < 5){
                    currentQ = questList.get(qid);
                    setQuestionView();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("score", score); //this score
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }
}
