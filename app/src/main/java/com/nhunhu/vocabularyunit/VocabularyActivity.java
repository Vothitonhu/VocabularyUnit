package com.nhunhu.vocabularyunit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nhunhu.vocabularyunit.adapters.VocabularyAdapter;
import com.nhunhu.vocabularyunit.controllers.VocabularyManagement;
import com.nhunhu.vocabularyunit.models.Unit;
import com.nhunhu.vocabularyunit.models.Vocabulary;

import java.util.ArrayList;

public class VocabularyActivity extends AppCompatActivity {
    private ListView lvVocabulary;
    private VocabularyAdapter mAdapter;
    private ArrayList<Vocabulary>mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        lvVocabulary = findViewById(R.id.lvVocanulary);

        Intent intent = getIntent();
        Unit unit = (Unit)intent.getSerializableExtra("SEND");
        mList = VocabularyManagement.getInstance().gets(unit);
        mAdapter = new VocabularyAdapter(this, R.layout.item_vocabulary, mList);
        lvVocabulary.setAdapter(mAdapter);
    }
}
