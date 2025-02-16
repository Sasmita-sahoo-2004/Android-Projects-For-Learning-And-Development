package com.example.multiactivity_communication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.textView);
        Button btnNavigate = findViewById(R.id.btnNavigateBack);
        String receivedUsername = getIntent().getStringExtra("USERNAME_KEY");
        // Set received data to TextView
        if (receivedUsername != null && !receivedUsername.isEmpty()) {
            textView.setText("Welcome, " + receivedUsername + "!");
        } else {
            textView.setText("Welcome, Guest!");
        }
        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from EditText
                // Create Intent and send data
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}