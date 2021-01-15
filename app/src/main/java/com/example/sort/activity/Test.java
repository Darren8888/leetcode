package com.example.sort.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.example.sort.R;
import com.example.sort.tree.BuildTree;


import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Test extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
//        int in[] = {4, 7, 2, 1, 5, 3, 8, 6};
//        int post[] = {7, 4, 2, 5, 8, 6, 3, 1};
//
//        BuildTree.TreeNode root = BuildTree.buildTree(pre, in);
//        BuildTree.posttraverse(root);
//
//        Log.d("darren", "=========================================");
//
//        root = BuildTree.buildTree1(in, post);
//        BuildTree.printPre(root);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("22", "22_1");
        hashMap.put("22", "22_2");
        hashMap.put("22", "22_3");

        ConcurrentHashMap<String, String> hashMap1 = new ConcurrentHashMap<>();
        hashMap1.put("22", "22_1");
        hashMap1.put("22", "22_2");
        hashMap1.put("22", "22_3");

        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            Log.d("darren", "1 key: " + key + ", value: " + hashMap.get(key));
        }

        Set<String> keySet1 = hashMap1.keySet();
        for (String key : keySet1) {
            Log.d("darren", "2 key: " + key + ", value: " + hashMap1.get(key));
        }

//        Intent intent1 = new Intent(this, Test1.class);
//        Intent intent2 = new Intent(this, Test2.class);
//        Intent intent3 = new Intent(this, Test3.class);
//        Intent intent[] = {intent1, intent2, intent3};
//        startActivities(intent);

//        char array[][] = new char {
//                'X', 'X', 'X', 'X',
//                'X', 'X', 'X', 'X',
//                'X', 'X', 'X', 'X',
//                'X', 'X', 'X', 'X',
//                'X', 'X', 'X', 'X'
//        };

//        Log.d("darren", "serial: " + getProperty("ro.serialno", ""));
//
//        char array[][] = new char[5][4];
//        for (int i=0; i<array.length; ++i) {
//            for (int j=0; j<array[0].length; ++j) {
//                array[i][j] = 'X';
//            }
//        }
//
//        array[0][0] = 'O';
//        array[0][1] = 'O';
//        array[0][2] = 'O';
////        array[1][1] = 'O';
//        array[2][2] = 'O';
//        array[2][1] = 'O';
//        array[4][0] = 'O';
//        array[4][3] = 'O';
//
//
//        for (int i=0; i<array.length; ++i) {
//            Log.d("darren", "i: " + i + ", " + array[i][0] + " " + array[i][1] + " " + array[i][2] + " " + array[i][3]);
//        }
//
//        Log.d("darren", "count O: " + Matrix.countO(array));
//        Matrix.replaceO2X(array);


//        Matrix.replaceO2X(array);

//        Log.d("darren", "ret 22: " + array.length);

//        for (int i=0; i<array.length; ++i) {
//            Log.d("darren", "i: " + i + ", " + array[i][0] + " " + array[i][1] + " " + array[i][2] + " " + array[i][3]);
//        }

//        Log.d("darren", "count22 O: " + Matrix.countO(array));
    }


    public static String getProperty(String key, String defaultValue) {
        String value = null;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            value = (String) (get.invoke(c, key, ""));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return TextUtils.isEmpty(value) ? defaultValue : value;
    }
}