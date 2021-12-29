package com.example.fal;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

import java.io.FileOutputStream;
import java.util.ConcurrentModificationException;

public class Filework{

    private final static String FILE_NAME = "content.txt";

    public static void saveFile(String text) throws IOException{

        Context context = MainActivity.textView.getContext();
        FileOutputStream fos = null;
        fos = context.openFileOutput(FILE_NAME, MainActivity.MODE_PRIVATE);
        fos.write(text.getBytes());
    }

    public static String readFile() throws IOException {
        FileInputStream fin = null;
        byte[] bytes = new byte[fin.available()];
        fin.read(bytes);
        String text = new String (bytes);
        return text;
    }
}