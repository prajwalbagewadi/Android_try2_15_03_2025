package com.bagew.addingdynamicfragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentActivity extends Fragment {
    int i;
    public FragmentActivity(int i){
        this.i=i;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        int cnt = 0;
//        TextView txt = findViewById();
        View view = inflater.inflate(R.layout.fragement_eg,container,false);

        String var =Integer.toString(this.i);
        Log.d("frag","onCreateView() called."+var);
        return view;
    }
}
