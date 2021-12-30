package com.example.andr;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_two, container, false);

        EditText textView = root.findViewById(R.id.showText);

        Bundle bundle = getArguments();
        String text = bundle.getString("text");
        String color = bundle.getString("color");


        textView.setText(text + "\n" + color);
        //textView.setTextColor(Color.parseColor(color));

        Button buttonReturn = root.findViewById(R.id.button_return);

        buttonReturn.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentOne fragmentOne = new FragmentOne(); //Create and instance of your fragment class here
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.frame_container, fragmentOne).addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
            }
        });

        return root;
    }
}