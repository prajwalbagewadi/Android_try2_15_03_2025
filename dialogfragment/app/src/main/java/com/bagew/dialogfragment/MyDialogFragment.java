package com.bagew.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment{
    public interface DialogListener{
        void onDialogResult(String result);
    }
    public DialogListener Listener;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Listener = (DialogListener) context;
    }
    public Dialog onCreateDialog(Bundle savedInstanceState){
        return new AlertDialog.Builder(requireActivity()).setTitle("Confirm").setMessage("Confirm to proceed forward?").setPositiveButton("yes",(dialog, which) -> {
            Toast.makeText(getContext(),"Yes button pressed. 😍",Toast.LENGTH_SHORT).show();
            Listener.onDialogResult("YES button pressed ♥️");
        }).setNegativeButton("No",(dialog, which) -> {
            Toast.makeText(getContext(),"No button pressed. 😔",Toast.LENGTH_SHORT).show();
            Listener.onDialogResult("NO button pressed ✨");
        }).create();
    }
}
