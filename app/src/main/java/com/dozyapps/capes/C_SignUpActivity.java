package com.dozyapps.capes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class C_SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    EditText mailid,pwd,pwd1;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_activity_sign_up);
        mailid=(EditText)findViewById(R.id.et_signup_email);
        pwd=(EditText)findViewById(R.id.et_signup_pwd);
        pwd1=(EditText)findViewById(R.id.et_signup_pwd1);

        mAuth=FirebaseAuth.getInstance();
        findViewById(R.id.btn_signup).setOnClickListener(this);
    }
    private void registerUser(){
        String email = mailid.getText().toString().trim();
        String password = pwd.getText().toString().trim();
        String password1 = pwd1.getText().toString().trim();


        if (email.isEmpty()){
            mailid.setError("Email is required");
            mailid.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mailid.setError("Please enter valid email");
            mailid.requestFocus();
            return;
        }

        if (password.isEmpty()){
            pwd.setError("Password is required");
            pwd.requestFocus();
            return;
        }
        if (password1.isEmpty()){
            pwd1.setError("Password is required");
            pwd1.requestFocus();
            return;
        }

        if (password.length()<6){
            pwd.setError("Minimum length should be 6");
            pwd.requestFocus();
            return;
        }

        if (!password1.equals(password)){
            pwd1.setError("Password dont match");
            pwd1.requestFocus();
            return;
        }





        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Toast.makeText(C_SignUpActivity.this, "Regestration Successfull", Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    Intent intent=new Intent(C_SignUpActivity.this, C_MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(C_SignUpActivity.this, "Email is already registered", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(C_SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_signup:
                registerUser();
                break;

        }
    }
}
