package com.example.andr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class FragmentOne extends Fragment {

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_one, container, false);

        radioGroup = root.findViewById(R.id.radioGroup);
        EditText textView = root.findViewById(R.id.InputText);

        Button buttonApply = root.findViewById(R.id.button_apply);

        buttonApply.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = root.findViewById(radioId);
                Bundle bundle = new Bundle();
                bundle.putString("color", radioButton.getText().toString());
                bundle.putString("text", textView.getText().toString());

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FragmentTwo fragmentTwo = new FragmentTwo();
                fragmentTwo.setArguments(bundle);

                fragmentTransaction.replace(R.id.frame_container, fragmentTwo);
                fragmentTransaction.commit();
            }
        });
        return root;
    }
}