package com.example.agarw.diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
     EditText headingtext, notestext;
     Button add,delete,gohome;
    private long _id;
    private DBManager dbManager;
    private SimpleCursorAdapter adapter;
    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.HEADING, DatabaseHelper.NOTES };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notestext = (EditText)(findViewById(R.id.editText2));
        headingtext = (EditText)(findViewById(R.id.editText3));
        add = (Button)(findViewById(R.id.button3));
        delete = (Button)(findViewById(R.id.button));
        gohome = (Button)(findViewById(R.id.button4));

        dbManager = new DBManager(this);
        dbManager.open();

        View.OnClickListener Listeneradd = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String heading = headingtext.getText().toString();
                final String Notes = notestext.getText().toString();

                dbManager.insert(heading, Notes);

            }
        };


        add.setOnClickListener(Listeneradd);

        View.OnClickListener Gohome = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
                finish();
            }
        };


 gohome.setOnClickListener(Gohome);



    }
}
