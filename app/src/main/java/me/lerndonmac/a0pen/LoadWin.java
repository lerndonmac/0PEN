package me.lerndonmac.a0pen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadWin extends AppCompatActivity {
    public static long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try(FileInputStream fis = openFileInput("conein")) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String text = new String(bytes);
            id = Long.parseLong(text);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (id ==0){
            startActivity(new Intent(this, Autorization.class));
        }else {
            startActivity(new Intent(this, MainActivity.class));
        }

    }
}
