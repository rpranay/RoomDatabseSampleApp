package com.dev.pranay.roomwordsample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDAO mWordDAO;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getWordRoomDatabase(application);
        mWordDAO = db.getWordDAO();
        mAllWords = mWordDAO.getAllWords();
    }

    LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        new insertAsyncTask(mWordDAO).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDAO mAsyncTaskDAO;

        insertAsyncTask(WordDAO wordDAO){
            this.mAsyncTaskDAO = wordDAO;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDAO.insert(words[0]);
            return null;
        }
    }
}
