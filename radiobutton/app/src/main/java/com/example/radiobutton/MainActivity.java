package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static RadioGroup rg;
    private static RadioButton rb;
    private static Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m1();
    }
    public void m1()
    {
        rg=(RadioGroup)findViewById(R.id.hlo);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res=rg.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(res);
                Toast.makeText(MainActivity.this,rb.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}