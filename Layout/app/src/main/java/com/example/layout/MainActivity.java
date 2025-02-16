package com.example.layout;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        TextView textView = findViewById(R.id.textView);

        EditText et1 = findViewById(R.id.et1);
        EditText et2 = findViewById(R.id.et2);
        EditText et3 = findViewById(R.id.et3);
        EditText et4 = findViewById(R.id.et4);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            String name1=et1.getText().toString().trim();
            String name2=et2.getText().toString().trim();
            String univ=et3.getText().toString().trim();
            String branch=et4.getText().toString().trim();
            if(!name1.isEmpty() && !name2.isEmpty() && !univ.isEmpty() && !branch.isEmpty()){
                Toast.makeText(MainActivity.this, "Hello"+name1+" "+name2+" of"+univ+" ,"+branch+" Branch", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, "Fields Should not Empty", Toast.LENGTH_SHORT).show();
        });


    }
}