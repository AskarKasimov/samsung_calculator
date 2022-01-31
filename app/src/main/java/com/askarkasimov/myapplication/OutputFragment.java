package com.askarkasimov.myapplication;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class OutputFragment extends Fragment {
    TextView output;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.output_fragment, container, false);
        output = v.findViewById(R.id.output);
        return v;
    }

    public void setOutput(String value){
        output.setText("Ответ: " + value);
    }
}
