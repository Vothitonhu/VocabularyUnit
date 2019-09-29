package com.nhunhu.vocabularyunit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nhunhu.vocabularyunit.adapters.UnitAdapter;
import com.nhunhu.vocabularyunit.controllers.UnitManagement;
import com.nhunhu.vocabularyunit.controllers.VocabularyManagement;
import com.nhunhu.vocabularyunit.models.Unit;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvUnit;
    private UnitAdapter mAdapter;
    private ArrayList<Unit> mList;

    private int positionSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvUnit = findViewById(R.id.lvUnit);

        UnitManagement.getInstance().load(this);
        VocabularyManagement.getInstance().load(this);
        mList = UnitManagement.getInstance().gets();
        mAdapter = new UnitAdapter(this, R.layout.item_unit, mList);
        lvUnit.setAdapter(mAdapter);

        lvUnit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                positionSelected = i;
                Intent intent = new Intent(MainActivity.this, VocabularyActivity.class);
                Unit unit = mList.get(i);
                intent.putExtra("SEND", unit);
                startActivity(intent);
            }
        });




//        for(Unit u : mList){
//            System.out.println(u.toString());
//        }
    }
}
