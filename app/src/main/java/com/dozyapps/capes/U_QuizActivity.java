package com.dozyapps.capes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class U_QuizActivity extends AppCompatActivity {
    RadioButton radioButton;
    int count=0;
    JSONObject obj;
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u__quiz);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Getting elements

        TextView tv1= findViewById(R.id.quiz_question);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup1);
        RadioButton r1 = findViewById(R.id.quiz_ans_1);
        RadioButton r2 = findViewById(R.id.quiz_ans_2);
        RadioButton r3 = findViewById(R.id.quiz_ans_3);
        RadioButton r4 = findViewById(R.id.quiz_ans_4);


        Button button = findViewById(R.id.submit_ans);
        //End



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Submitting your answers", Snackbar.LENGTH_LONG)
                        .setAction("Click to Submit", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Getting Data from JSON
        try {
            obj = new JSONObject(readJSONFromAsset());
            jsonArray = (JSONArray) obj.getJSONArray("questions");
            final int temp;

           // while (obj.length()!=0) {
                for (int i = 0; i<jsonArray.length();i++){

                JSONObject json_data = jsonArray.getJSONObject(i);

                int id= json_data.getInt("id");
                String ques= json_data.getString("Question");
                String ans1= json_data.getString("Ans1");
                String ans2= json_data.getString("Ans2");
                String ans3= json_data.getString("Ans3");
                String ans4= json_data.getString("Ans4");
                final String correctAns = json_data.getString("correct");

                tv1.setText(ques);
                r1.setText(ans1);
                r2.setText(ans2);
                r3.setText(ans3);
                r4.setText(ans4);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int cAns  = radioGroup.getCheckedRadioButtonId();
                        //String stringcAns = String.valueOf(cAns);
//                        Toast.makeText(this, cans, Toast.LENGTH_SHORT).show();
                        radioButton = (RadioButton) findViewById(cAns);
//                        String stringcAns = radioGroup.getChildAt(cAns);
                        String stringcAns = (String) radioButton.getText();
                        if (stringcAns.equals(correctAns))
                        {
                            count++;
                            Toast.makeText(U_QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(U_QuizActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(U_QuizActivity.this, stringcAns, Toast.LENGTH_SHORT).show();
                    }
                });

            }
            Toast.makeText(this, "Total Marks: "+getMarks(), Toast.LENGTH_SHORT).show();
           // if (correctAns.equals(radioGroup.getTransitionName()));

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error."+e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("quiz.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "Cannot go back!", Toast.LENGTH_SHORT).show();

        //Toast.makeText()
        //super.onBackPressed();
    }

    public int getMarks(){
        return count;
    }

    public String judgeMarks(){

        return null;
    }

}
