package com.nhunhu.vocabularyunit.controllers;

import android.content.Context;

import com.nhunhu.vocabularyunit.models.Unit;
import com.nhunhu.vocabularyunit.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UnitManagement {
    private static UnitManagement sInstance;
    ArrayList<Unit>mList;
    private UnitManagement(){
        mList = new ArrayList<>();
    }

    public static UnitManagement getInstance(){
        if(sInstance == null){
            sInstance = new UnitManagement();
        }
        return sInstance;
    }

    public void add(Unit u){
        mList.add(u);
    }

    public ArrayList<Unit>gets(){
        return mList;
    }

    public void load(Context context){
        mList.clear();
        String content = Utils.readAssets(context, "dataVocabulary.json");
        try{
            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonArray = jsonObject.getJSONArray("units");
            for(int i =0; i<jsonArray.length();i++){
                JSONObject object = jsonArray.getJSONObject(i);
                int unitId = object.getInt(Unit.FIELD_ID);
                String titleEN = object.getString(Unit.FIELD_TITLE_EN);
                String titleVI = object.getString(Unit.FIELD_TITLE_VI);
                Unit u = new Unit(unitId, titleEN, titleVI);
                mList.add(u);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

}
