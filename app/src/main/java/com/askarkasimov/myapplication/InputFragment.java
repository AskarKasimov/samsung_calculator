package com.askarkasimov.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment{

    DataFromFragment dataFromFragment;
    View v;
    EditText input;
    @Override
    public void onAttach(@NonNull Context context) {
        if (context instanceof Activity) {
            super.onAttach(context);
            try {
                dataFromFragment = (DataFromFragment) context;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.input_fragment, container, false);
        input = v.findViewById(R.id.input);
        return v;
    }

    public void sendData(){
        dataFromFragment.sendData(input.getText().toString());
    }
}
