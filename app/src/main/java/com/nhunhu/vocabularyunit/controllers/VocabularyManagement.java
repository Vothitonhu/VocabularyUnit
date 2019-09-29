package com.nhunhu.vocabularyunit.controllers;

import android.content.Context;

import com.nhunhu.vocabularyunit.models.Unit;
import com.nhunhu.vocabularyunit.models.Vocabulary;
import com.nhunhu.vocabularyunit.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class VocabularyManagement {
    private static VocabularyManagement sInstance;
   // ArrayList<Vocabulary>mList;
    HashMap<Integer, ArrayList<Vocabulary>> mVList;//ni
//    private VocabularyManagement(){
//        mList = new ArrayList<>();//ni
//    }
    private VocabularyManagement(){
        mVList = new HashMap<>();//ni
    }
    public static VocabularyManagement getInstance(){
        if(sInstance == null){
            sInstance = new VocabularyManagement();
        }
        return sInstance;
    }
    public void add(Vocabulary vocabulary){
        ArrayList<Vocabulary>list = mVList.get(vocabulary.getUnitId());
        if(list==null){
            list = new ArrayList<>();
            mVList.put(vocabulary.getUnitId(), list);
        }
        list.add(vocabulary);
    }
//    public ArrayList<Vocabulary>gets(){
//        return mList;
//    }

//    public ArrayList<Vocabulary>gets(Unit unit){
//        ArrayList<Vocabulary> list = new ArrayList<>();
//        for(Vocabulary v : mList){
//            if(v.getUnitId() == unit.getId()){
//                list.add(v);
//            }
//        }
//        return list;
//    }
    public  ArrayList<Vocabulary>gets(Unit u){
        return mVList.get(u.getId());
    }
//    public HashMap<Unit, Vocabulary>getVoca(Unit unit){
//        HashMap<Unit, Vocabulary> hMap = new HashMap<>();
//       // Vocabulary v = hMap.get(unit);
//        for(Vocabulary v1 : hMap.values()){
//            hMap.put(unit, v1);
//        }
//        return hMap;
//    }
    public void load(Context context){
        mVList.clear();
        String content = Utils.readAssets(context, "dataVocabulary.json");
        try{
            JSONObject jsonObject = new JSONObject(content);
            JSONArray jsonArray = jsonObject.getJSONArray("vocabularies");
            for(int i =0; i<jsonArray.length();i++){
                JSONObject object = jsonArray.getJSONObject(i);
                int unitId = object.getInt(Vocabulary.FIELD_UNIT_ID);
                String word = object.getString(Vocabulary.FIELD_WORD);
                String type = object.getString(Vocabulary.FIELD_TYPE);
                String pronunciation = object.getString(Vocabulary.FIELD_PRONUNCIATION);
                String vietnameseMean = object.getString(Vocabulary.FIELD_MEAN);
                String example = object.getString(Vocabulary.FIELD_EXAMPLE);
                Vocabulary v = new Vocabulary(unitId, word, type, pronunciation, vietnameseMean, example);
                add(v);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

}
