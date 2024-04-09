package com.example.homecareconnect.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.homecareconnect.R;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        gotoSignUp();
    }
    private void gotoSignUp(){
        Button button = (Button) findViewById(R.id.buttonToSignUp);
        button.setOnClickListener(v -> startActivity(new Intent(LogIn.this,SignUpActivity.class)));

    }
}