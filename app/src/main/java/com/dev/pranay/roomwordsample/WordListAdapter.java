package com.dev.pranay.roomwordsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Word> mWords;

    WordListAdapter(Context c){
        mLayoutInflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.wordItemTextview.setText(current.getWord());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemTextview.setText("No Word");
        }
    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mWords == null)
            return 0;
        else
            return mWords.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder{

        private final TextView wordItemTextview;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemTextview = itemView.findViewById(R.id.textView);
        }
    }
}
