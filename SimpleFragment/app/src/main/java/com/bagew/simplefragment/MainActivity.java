package com.bagew.simplefragment;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;




public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 1️⃣ FragmentManager – Manages Fragments
         * FragmentManager is responsible for:
         * ✅ Adding, removing, or replacing fragments
         * ✅ Handling back stack operations
         * ✅ Retrieving existing fragments
         *
         * Example: Get the FragmentManager in an Activity:
         */

        /**
        * 2️⃣ FragmentTransaction – Performs Fragment Operations
        * A FragmentTransaction allows you to:
        * ✅ Add, replace, or remove a fragment
        * ✅ Control animations for fragment transitions
        * ✅ Commit changes to the fragment state
        *
        * Example: Replace an existing fragment dynamically:
        */



        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            // Ensure that FragmentManager is correctly initialized
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            Fragment fragment = new FragmentActivity();
            ft.replace(R.id.fragment_container,fragment);
            //Enables back navigation
            ft.addToBackStack(null);
            ft.commit();
        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(v -> {
            // Ensure that FragmentManager is correctly initialized
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            Fragment fragment = new FragmentActivity2();
            ft.replace(R.id.fragment_container,fragment);
            //Enables back navigation
            ft.addToBackStack(null);
            ft.commit();
        });
    }
}