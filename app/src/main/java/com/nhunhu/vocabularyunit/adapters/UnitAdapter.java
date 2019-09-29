package com.nhunhu.vocabularyunit.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.nhunhu.vocabularyunit.R;
import com.nhunhu.vocabularyunit.models.Unit;

import java.util.List;

public class UnitAdapter extends ArrayAdapter<Unit> {
    Activity context;
    int resource;
    List<Unit> objects;
    public UnitAdapter(Activity context, int resource, List<Unit> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView tvId = row.findViewById(R.id.tvId);
        TextView tvEN = row.findViewById(R.id.tvEN);
        TextView tvVI = row.findViewById(R.id.tvVI);

        Unit unit = this.objects.get(position);
        tvId.setText(unit.getId() + "");
        tvEN.setText(unit.getTitleEN());
        tvVI.setText(unit.getTitleVI());
        return row;
    }
}
