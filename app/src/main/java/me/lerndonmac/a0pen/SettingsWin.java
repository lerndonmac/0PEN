package me.lerndonmac.a0pen;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SettingsWin extends AppCompatActivity {
    private AppCompatButton settings_icon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        settings_icon = findViewById(R.id.settings_icon);
        settings_icon.setOnClickListener(v -> finish());

    }
}
