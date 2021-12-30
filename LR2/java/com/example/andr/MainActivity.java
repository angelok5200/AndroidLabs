package com.example.andr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, new FragmentOne());
        fragmentTransaction.commit();
    }

    public void CancelButton (View v){

        Button buttonCancel = findViewById(R.id.button_cancel);
        EditText textView = findViewById(R.id.InputText);
        buttonCancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });
    }
}

//
//    public void OkButton (View v){
//
//        radioGroup = findViewById(R.id.radioGroup);
//        EditText textView = findViewById(R.id.InputText);
//
//        Button buttonApply = findViewById(R.id.button_apply);
//
//        buttonApply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int radioId = radioGroup.getCheckedRadioButtonId();
//                if (!(textView.getText().length() == 0 & radioId == -1)) {
//                    Toast.makeText(MainActivity.this, "Enter all information needed " + radioButton.getText(),
//                            Toast.LENGTH_SHORT).show();
//                }
//                radioButton = findViewById(radioId);
//                textView.setTextColor(radioButton.getTextColors());
//                Bundle bundle = new Bundle();
//                bundle.putString("color", radioButton.getTextColors().toString());
//                bundle.putString("text", textView.getText().toString());
//            }
//        });
//    }
//
//    public void show (View v, Bundle savedInstanceState ){
//
//        Button buttonShow = findViewById(R.id.button_show);
//        EditText textView = findViewById(R.id.showText);
//        buttonShow.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//
//
//                String text = savedInstanceState.getString("text");
//                //String color = savedInstanceState.getString("color");
//                //textView.setTextColor(Integer.parseInt(color));
//                textView.setText(text);
//                FragmentManager fm = MainActivity.this.getSupportFragmentManager();
//                fm.popBackStack();
//            }
//        });
//    }
//}