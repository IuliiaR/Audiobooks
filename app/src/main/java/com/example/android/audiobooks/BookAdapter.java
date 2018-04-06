package com.example.android.audiobooks;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {

    private final Context mContext;
    private ArrayList<Book> mBooks;

    public BookAdapter(@NonNull Context context, ArrayList<Book> books) {
        super(context, 0, books);
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Book currentBook = getItem(position);

        ImageView bookCoverImageView = listItemView.findViewById(R.id.cover_image_view);
        bookCoverImageView.setImageResource(currentBook.getBookCover());

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.book_title_text_view);
        miwokTextView.setText(currentBook.getBookTitle());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.author_text_view);
        defaultTextView.setText(currentBook.getAuthor());

        listItemView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                //we use INTENT to turn on new ones activity
                Intent myIntent = new Intent(mContext, DetailsActivity.class);
                myIntent.putExtra(MainActivity.CHOSEN_BOOK, currentBook);
                // Start the new activity
                mContext.startActivity(myIntent);
            }
        });

        return listItemView;
    }
}
