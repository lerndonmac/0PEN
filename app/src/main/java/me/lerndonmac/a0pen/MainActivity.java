package me.lerndonmac.a0pen;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {
private AppCompatButton settings_icon;
private AppCompatButton open_button_barrier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings_icon = findViewById(R.id.settings_icon);
        open_button_barrier = findViewById(R.id.open_button_barrier);
        settings_icon.setOnClickListener(v -> startActivity(new Intent(this, SettingsWin.class)));
        open_button_barrier.setOnClickListener(v -> {
            //сюда отправку запроса на открытия
        });
    }
}