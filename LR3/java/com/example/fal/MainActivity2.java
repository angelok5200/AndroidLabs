package com.example.fal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fal.databinding.ActivityMain2Binding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    private final static String FILE_NAME = "content.txt";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        try {
            String text = Filework.readFile();
            textView.setText(text);
        } catch (IOException e) {
            Toast.makeText(MainActivity2.this, "error", Toast.LENGTH_SHORT).show();
        }
    }
}