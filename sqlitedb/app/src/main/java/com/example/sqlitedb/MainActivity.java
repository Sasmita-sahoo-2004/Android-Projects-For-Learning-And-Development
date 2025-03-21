package com.example.sqlitedb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText etName,etSurname,etMarks,etId;
    Button addBtn;
    Button vBtn;
    Button updateBtn;
    Button delBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new  DatabaseHelper(this);
        etId=(EditText)findViewById(R.id.editTextTextPersonName4);
        etName=(EditText)findViewById(R.id.editTextTextPersonName);
        etSurname=(EditText)findViewById(R.id.editTextTextPersonName2);
        etMarks=(EditText)findViewById(R.id.editTextTextPersonName3);
        addBtn=(Button) findViewById(R.id.button);
        vBtn=(Button) findViewById(R.id.button2);
        updateBtn=(Button) findViewById(R.id.button3);
        delBtn=(Button) findViewById(R.id.button4);
        adData();
        viewData();
        updateData();
        dellData();
    }
    public void adData()
    {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted= myDb.insertData( etName.getText().toString(),
                        etSurname.getText().toString(),
                        etMarks.getText().toString()
                );
                if(isInserted==true)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data  not Inserted",Toast.LENGTH_LONG).show();

            }
        });
    }
    public void viewData()
    {
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDb.getData();
                if (res.getCount() == 0) {
                    //show message
                    showMsg("Error","No data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("ID :" + res.getString(0) + "\n");
                    buffer.append("NAME :" + res.getString(1) + "\n");
                    buffer.append("SURNAME :" + res.getString(2) + "\n");
                    buffer.append("MARKS :" + res.getString(3) + "\n\n");
                }
                //show alldata
                showMsg("Data",buffer.toString());
            }
        });
    }
    public void showMsg(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void dellData()
    {
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int delRows=myDb.delData( etId.getText().toString());
                if(delRows>0)
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data  not Deleted",Toast.LENGTH_LONG).show();


            }
        });
    }
    public void updateData()
    {
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate=myDb.updateData( etId.getText().toString(),
                        etName.getText().toString(),
                        etSurname.getText().toString(),
                        etMarks.getText().toString());
                if(isUpdate==true)
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data  not Updated",Toast.LENGTH_LONG).show();

            }
        });
    }

}
