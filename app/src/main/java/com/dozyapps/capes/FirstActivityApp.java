package com.dozyapps.capes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivityApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button chooseUser, chooseCorporate;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_app);


        chooseUser = (Button) findViewById(R.id.choose_user);
        chooseCorporate = (Button) findViewById(R.id.choose_corporate);

        chooseUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivityApp.this, U_MainActivity.class);
                    startActivity(intent);
            }
        });

        chooseCorporate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivityApp.this, C_MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
