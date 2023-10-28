package com.example.enetcom.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enetcom.recyclerview.R;
import com.example.enetcom.recyclerview.model.Word;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {


    private final LinkedList<Word> mWordList;
    public WordListAdapter(LinkedList<Word> mWordList) {
        this.mWordList = mWordList;
    }
    @NonNull
    @Override


    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.wordlist_item, parent, false);

        return new WordViewHolder(adapterLayout, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        Word mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent.getWord());

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word_title);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            int mPosition = getLayoutPosition();
            Word element = mWordList.get(mPosition);
            element.setWord("Clicked! " + element.getWord());
            mWordList.set(mPosition, element);
            mAdapter.notifyDataSetChanged();
        }
    }
}
