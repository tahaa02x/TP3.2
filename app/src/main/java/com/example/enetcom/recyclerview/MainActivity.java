package com.example.enetcom.recyclerview;

import android.os.Bundle;

import com.example.enetcom.recyclerview.Data.Datasource;
import com.example.enetcom.recyclerview.adapter.WordListAdapter;
import com.example.enetcom.recyclerview.model.Word;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;


import com.example.enetcom.recyclerview.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private WordListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Datasource mDatasource = new Datasource();
        LinkedList<Word> mWordList = mDatasource.loadWords();
        setSupportActionBar(binding.toolbar);

        mAdapter = new WordListAdapter(mWordList);
        binding.contentMain.recyclerview.setAdapter(mAdapter);
        binding.contentMain.recyclerview.setHasFixedSize(true);



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
                int wordListSize = mWordList.size();
                mWordList.addLast(new Word("+ Word " + wordListSize));
                binding.contentMain.recyclerview.getAdapter().notifyItemInserted(wordListSize);
                binding.contentMain.recyclerview.smoothScrollToPosition(wordListSize);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}