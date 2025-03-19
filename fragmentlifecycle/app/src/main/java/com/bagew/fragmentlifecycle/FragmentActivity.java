package com.bagew.fragmentlifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FragmentActivity extends Fragment {

    public void onAttach(@NonNull Context context){
        //Called when the fragment is attached to an activity.
        //Activity reference can be obtained here.
        super.onAttach(context);
        Log.d("fraglifecycle","onAttach() called");
    }
    public void onCreate(Bundle savedInstanceState){
        //Called when the fragment is created.
        //Used for initialization, setting up resources, etc.
        super.onCreate(savedInstanceState);
        Log.d("fraglifecycle","onCreate() called");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Called to create the view for the fragment.
        //The UI layout is inflated in this method.
        Log.d("fraglifecycle","onCreateView() called");
        return inflater.inflate(R.layout.fragment_eg, container,false);
    }

    public void onStart(){
        super.onStart();
        //Called when the fragment becomes visible.
        Log.d("fraglifecycle","onStart() called");
    }

    public void onPause(){
        //Called when the fragment is partially visible (another activity or fragment appears in front)
        // pressing home button
        super.onPause();
        Log.d("fraglifecycle","onPause() called from FragmentActivity");
    }

    public void onResume(){
        //Called when the fragment is active and interactable.
        super.onResume();
        Log.d("fraglifecycle","onResume() called from FragmentActivity");
    }

    public void onStop(){
        //Called when the fragment is no longer visible.
        // activity completely removed from background
        super.onStop();
        Log.d("fraglifecycle","onStop() called from FragmentActivity");
    }

    public void onDestoryView(){
        //Called before the fragment’s view is destroyed.
        //Used for cleaning up UI resources.
        super.onDestroyView();
        Log.d("fraglifecycle","onDestoryView() called from FragmentActivity");
    }

    public void onDestory(){
        //Called when the fragment is completely destroyed.
        super.onDestroy();
        Log.d("fraglifecycle","onDestory() called from FragmentActivity");
    }

    public void onDettach(){
        //Called when the fragment is detached from the activity.
        super.onDetach();
        Log.d("fraglifecycle","onDettach() called from FragmentActivity");
    }
}