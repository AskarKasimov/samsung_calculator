package com.askarkasimov.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements DataFromFragment, Clicked{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData(String string) {
        String[] numbers = new String[0];
        char operation = ' ';
        if (string.contains("+")) {
            numbers = string.split("\\+");
            operation = '+';
        }
        if (string.contains("-")) {
            numbers = string.split("-");
            operation = '-';
        }
        if (string.contains("*")) {
            numbers = string.split("\\*");
            operation = '*';
        }
        if (string.contains("/")) {
            numbers = string.split("/");
            operation = '/';
        }
        OutputFragment outputFragment = (OutputFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView3);
        switch (operation){
            case ('+'):
                outputFragment.setOutput(String.valueOf(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])));
                break;
            case ('-'):
                outputFragment.setOutput(String.valueOf(Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1])));
                break;
            case ('*'):
                outputFragment.setOutput(String.valueOf(Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1])));
                break;
            case ('/'):
                outputFragment.setOutput(String.valueOf(Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1])));
                break;
            default:
                outputFragment.setOutput("Ошибка!");
        }
    }

    @Override
    public void click() {
        InputFragment inputFragment = (InputFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        inputFragment.sendData();
    }
}