package com.example.homecareconnect.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homecareconnect.Entities.User;
import com.example.homecareconnect.R;

public class LogInActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.log_in);
        Button button= (Button)findViewById(R.id.Confirm);


        button.setOnClickListener(view -> {
            EditText Username = (EditText)findViewById(R.id.Username);

        });

    }

}
