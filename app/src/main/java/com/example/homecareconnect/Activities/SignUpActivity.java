package com.example.homecareconnect.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homecareconnect.R;

public class SignUpActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        //confirm button
        Button button= (Button)findViewById(R.id.Confirm);
        button.setOnClickListener(view -> {
            String Username = ((EditText)findViewById(R.id.Username)).getText().toString();
            Log.i("USERNAME",Username);
        });
    gotoLogIn();
    }
    private void gotoLogIn(){
        Button button = (Button) findViewById(R.id.buttonToLogIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
