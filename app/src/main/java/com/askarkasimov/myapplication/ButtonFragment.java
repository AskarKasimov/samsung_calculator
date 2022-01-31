package com.askarkasimov.myapplication;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ButtonFragment extends Fragment{
    Clicked clicked;

    @Override
    public void onAttach(@NonNull Context context) {
//        if (context instanceof Clicked) {
            super.onAttach(context);
            try {
                clicked = (Clicked) context;
            }
            catch (ClassCastException e) {
                e.printStackTrace();
            }
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.button_fragment, container, false);
        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(view -> {
            if (clicked != null) {
                clicked.click();
            }
        });

        return v;
    }


}
