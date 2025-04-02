package com.bagew.listfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.util.List;

public class MyFragment extends ListFragment {
    String[] frutis = {"🍎apples","🍇grapes","🍓strawberry","🍒cherry","🍍pineapple"};
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = new ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,frutis);
        // Set adapter to display the list
        setListAdapter(adapter);
    }
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l,v,position,id);
        Toast.makeText(getActivity(),"Fruit Selected"+frutis[position],Toast.LENGTH_SHORT).show();
    }
}
