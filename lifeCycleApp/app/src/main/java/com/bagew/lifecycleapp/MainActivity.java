package com.bagew.lifecycleapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        EdgeToEdge.enable(this);
////        setContentView(R.layout.activity_main);
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
////            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
////            return insets;
////        });
//
//        super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            Log.d("LifeCycle","onCreate()Called");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        /*
        * SavedInstanceState is a mechanism used to restore the state of an Activity, in case of a process death, or an activity recreation caused by a configuration change
        * */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         /*
            * The method setContentView(R.layout.activity_main); is used in an Android Activity to define the layout that should be displayed on the screen.
            * How It Works?
            * R.layout.activity_main refers to an XML file located in the res/layout/ directory.
            * This file defines the UI components (buttons, text views, etc.) for the activity.
            * The method inflates (loads) the XML layout and displays it on the screen.
            * */
        EditText edit = findViewById(R.id.editText);
        edit.setText("onCreate() called");
        Log.d("lifecycle","onCreate() called");
    }

    @Override
    protected void onStart(){
        super.onStart();
        EditText edit = findViewById(R.id.editText);
        edit.setText("onStart() called");
        Log.d("lifecycle","onStart() called");
    }

    @Override
    protected void onResume(){
        super.onResume();
        EditText edit = findViewById(R.id.editText);
        //also called when app is resumed from the background
        edit.setText("onResume() called");
        Log.d("lifecycle","onResume() called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        EditText edit = findViewById(R.id.editText);
        edit.setText("onPause() called");
        Log.d("lifecycle","onPause() called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        EditText edit = findViewById(R.id.editText);
        edit.setText("onStop() called");
        Log.d("lifecycle","onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EditText edit = findViewById(R.id.editText);
        edit.setText("onDestroy() called");
        Log.d("lifecycle","onDestory() called");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        EditText edit = findViewById(R.id.editText);
        edit.setText("onRestart() called");
        Log.d("lifecycle","onRestart() called");
    }
}