package me.lerndonmac.a0pen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Autorization extends AppCompatActivity {
    private AppCompatButton authorization_button_barrier;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization_start);
        authorization_button_barrier = findViewById(R.id.authorization_button_barrier);
        authorization_button_barrier.setOnClickListener(v -> {
            startActivity(new Intent(this, IdetnifireWin.class));
        });
    }
}
