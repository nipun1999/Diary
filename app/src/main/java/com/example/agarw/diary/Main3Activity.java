package com.example.agarw.diary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
     EditText headingupdate, notesupdate;
    Button update,delete,gohome;
    private long _id;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        headingupdate = (EditText)(findViewById(R.id.editText3));
        notesupdate = (EditText)(findViewById(R.id.editText2));
        update = (Button)(findViewById(R.id.button3));
        delete = (Button)(findViewById(R.id.button));
        gohome = (Button)(findViewById(R.id.button4));

        dbManager = new DBManager(this);
        dbManager.open();

        Intent intent = getIntent();

        String id = intent.getStringExtra("id");
        String heading = intent.getStringExtra("heading");
        String note = intent.getStringExtra("notes");

        _id = Long.parseLong(id);

        headingupdate.setText(heading);
        notesupdate.setText(note);

        View.OnClickListener updatelistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heading = headingupdate.getText().toString();
                String notes = notesupdate.getText().toString();

                dbManager.update(_id, heading, notes);

                Toast.makeText(Main3Activity.this, "Successfully updated",
                        Toast.LENGTH_LONG).show();
                Intent modify_intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(modify_intent);
            }
        };

        update.setOnClickListener(updatelistener);

        View.OnClickListener deletelistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbManager.delete(_id);
                Toast.makeText(Main3Activity.this, "Successfully deleted",
                        Toast.LENGTH_LONG).show();
                Intent modify_intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(modify_intent);
            }
        };

        delete.setOnClickListener(deletelistener);

        View.OnClickListener gohomelistener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modify_intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(modify_intent);
            }
        };

        gohome.setOnClickListener(gohomelistener);


    }
}
