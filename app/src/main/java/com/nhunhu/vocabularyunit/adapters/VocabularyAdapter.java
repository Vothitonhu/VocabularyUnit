package com.nhunhu.vocabularyunit.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nhunhu.vocabularyunit.R;
import com.nhunhu.vocabularyunit.models.Unit;
import com.nhunhu.vocabularyunit.models.Vocabulary;

import java.util.List;

public class VocabularyAdapter extends ArrayAdapter<Vocabulary> {
    Activity context;
    int resource;
    List<Vocabulary> objects;
    public VocabularyAdapter(Activity context, int resource, List<Vocabulary> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(resource, parent, false);

        TextView tvWord = row.findViewById(R.id.tvWord);
        TextView tvType = row.findViewById(R.id.tvType);
        TextView tvPronunciation = row.findViewById(R.id.tvPronunciation);
        TextView tvMean = row.findViewById(R.id.tvMean);
        TextView tvExample = row.findViewById(R.id.tvExample);

        Vocabulary v = this.objects.get(position);
        tvWord.setText(v.getWord());
        tvType.setText(v.getType());
        tvPronunciation.setText(v.getPronunciation());
        tvMean.setText(v.getMean());
        tvExample.setText(v.getExample());
        return row;
    }
}
