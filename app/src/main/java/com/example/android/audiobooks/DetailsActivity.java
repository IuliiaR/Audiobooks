package com.example.android.audiobooks;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    public static final String CHOSEN_BOOK = "chosen_book";
    private Book chosenBook;
    ImageButton play;
    ImageButton pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_view);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //collect the transferred data from the previous activity
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            chosenBook = bundle.getParcelable(CHOSEN_BOOK);
        }

        ImageView cover = findViewById(R.id.book_cover_view);
        CollapsingToolbarLayout title = findViewById(R.id.book_title_view);
        TextView author = findViewById(R.id.book_author_view);
        TextView narrator = findViewById(R.id.book_narrator_view);
        TextView duration = findViewById(R.id.duration_view);
        TextView summary = findViewById(R.id.book_description);
        play = findViewById(R.id.play_button);
        pause = findViewById(R.id.pause_button);

        cover.setImageResource(chosenBook.getBookCover());
        title.setTitle(chosenBook.getBookTitle());
        author.setText(String.format("Author: %s", chosenBook.getAuthor()));
        narrator.setText(String.format("Narrator: %s", chosenBook.getNarrator()));
        duration.setText(String.format("Duration: %s", chosenBook.getDuration()));
        summary.setText(chosenBook.getSummary());

        final View bottomNavBar = findViewById(R.id.bottom_nav);

        final FloatingActionButton playFAButton = findViewById(R.id.play_floating_action_button);
        playFAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playFAButton.setVisibility(View.GONE);
                bottomNavBar.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), R.string.now_playing_message, Toast.LENGTH_SHORT).show();
            }
        });

        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                play.setVisibility(View.GONE);
                pause.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), R.string.now_playing_message, Toast.LENGTH_SHORT).show();
            }
        });

        pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pause.setVisibility(View.GONE);
                play.setVisibility(View.VISIBLE);
            }
        });
    }
}
