package com.example.agarw.diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    public final static String KEY_EXTRA_CONTACT_ID = "KEY_EXTRA_CONTACT_ID";

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.HEADING, DatabaseHelper.NOTES };

    final int[] to = new int[] { R.id.id, R.id.heading, R.id.note};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();
        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));
        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.heading);
                TextView noteTextView = (TextView) view.findViewById(R.id.note);

                String id1 = idTextView.getText().toString();
                String heading = titleTextView.getText().toString();
                String notes = noteTextView.getText().toString();



                Intent modify_intent = new Intent(getApplicationContext(), Main3Activity.class);

                modify_intent.putExtra("id", id1);
                modify_intent.putExtra("heading", heading);
                modify_intent.putExtra("notes", notes);

                startActivity(modify_intent);

            }
        });





    }
}
