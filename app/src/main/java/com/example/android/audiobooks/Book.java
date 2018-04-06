package com.example.android.audiobooks;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
    private String mBookTitle;
    private String mAuthor;
    private String mNarrator;
    private String mSummary;
    private String mYear;
    private String mDuration;
    private int mBookCover;
    private String mPath;

    public Book(Context context, int bookArrayId, int coverId) {
        Resources resources = context.getResources();
        String[] bookInfo = resources.getStringArray(bookArrayId);
        mBookTitle = bookInfo[0];
        mAuthor = bookInfo[1];
        mNarrator = bookInfo[2];
        mSummary = bookInfo[5];
        mYear = bookInfo[3];
        mDuration = bookInfo[4];
        mBookCover = coverId;
    }

    protected Book(Parcel in) {
        mBookTitle = in.readString();
        mAuthor = in.readString();
        mNarrator = in.readString();
        mYear = in.readString();
        mDuration = in.readString();
        mPath = in.readString();
        mBookCover = in.readInt();
        mSummary = in.readString();
    }

    public String getBookTitle() {

        return mBookTitle;
    }

    public String getAuthor() {

        return mAuthor;
    }

    public String getNarrator() {
        return mNarrator;
    }

    public String getSummary() {
        return mSummary;
    }

    public String getYear() {
        return mYear;
    }

    public String getDuration() {

        return mDuration;
    }

    public String getPath() {
        return mPath;
    }

    public int getBookCover() {

        return mBookCover;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mBookTitle);
        parcel.writeString(mAuthor);
        parcel.writeString(mNarrator);
        parcel.writeString(mYear);
        parcel.writeString(mDuration);
        parcel.writeString(mPath);
        parcel.writeInt(mBookCover);
        parcel.writeString(mSummary);
    }
}
