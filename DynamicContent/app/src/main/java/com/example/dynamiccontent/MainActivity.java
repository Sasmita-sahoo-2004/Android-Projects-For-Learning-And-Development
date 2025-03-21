package com.example.dynamiccontent;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText etname,etage;
    Button btn1,btn2;
    TextView tv1;
    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname= findViewById(R.id.et1);
        etage=findViewById(R.id.et2);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        tv1=findViewById(R.id.textView);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydatabase.execSQL("INSERT INTO TABLE1(name,age)values('" + etname.getText() +" '," +
                        etage.getText() + ");");
                etname.setText(" ");
                etage.setText(" ");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Cursor cursor ;
                try {
                    cursor=mydatabase.rawQuery("SELECT * FROM TABLE1", null);

                    cursor.moveToFirst();
                    tv1.setText(" ");
                    while(cursor.isBeforeFirst()==false) {
                        tv1.append(cursor.getString(0) + "," + cursor.getString(1) + "\n");
                        cursor.moveToNext();
                    }
                } catch (Exception ignored) {

                }
            }
        });
        mydatabase=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS TABLE1(name text,age int)");

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mydatabase.close();
    }
}