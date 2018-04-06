package com.example.android.audiobooks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Book> allAudioFiles = new ArrayList<>();

    public static final String CHOSEN_BOOK = "chosen_book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.addFakeDataArray();

        BookAdapter itemsAdapter = new BookAdapter(this, allAudioFiles);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }

    private void addFakeDataArray() {
        for (int i = 0; i < 20; i++) {
            allAudioFiles.add(new Book(this, R.array.Black_holes_and_baby_universes, R.drawable.book_cover));
        }
    }
}
