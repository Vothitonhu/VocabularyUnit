package com.nhunhu.vocabularyunit.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
    public static String readAssets(Context context, String path){
        String content = "";
        try{
            InputStream inp = context.getAssets().open(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(inp));

            String line = br.readLine();
            while (line != null) {
                content += line + "\n";
                line = br.readLine();
            }
            inp.close();
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return content;
    }
}
