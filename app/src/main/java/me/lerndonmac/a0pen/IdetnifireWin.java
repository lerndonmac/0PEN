package me.lerndonmac.a0pen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import me.lerndonmac.a0pen.model.Identificator;
import me.lerndonmac.a0pen.model.db.DBHelper;

public class IdetnifireWin extends AppCompatActivity {
    private AppCompatButton enterButton;
    private AppCompatButton backText3;
    private AppCompatEditText identifierEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identifier_window);
        enterButton = findViewById(R.id.enterButton);
        identifierEditText = findViewById(R.id.identifierEditText);
        backText3 = findViewById(R.id.backButton3);
        backText3.setOnClickListener(v -> finish());
        enterButton.setOnClickListener(v ->{
            String ident = identifierEditText.getText().toString();
            if (ident.equals("")){
                AppCompatTextView alertText = findViewById(R.id.appCompatTextView5);
                alertText.setText(R.string.pleasenterid);
                alertText.setTextColor(getColor(R.color.rad));
            }else {
            try (DBHelper helper = new DBHelper(this)){
                Dao<Identificator, Integer> identificators = DaoManager.createDao(new AndroidConnectionSource(helper), Identificator.class);
                for (Identificator i:identificators.queryForAll()) {
                    if (i.getId() == Long.parseLong(ident)){
                        LoadWin.id = i.getId();
                        FileOutputStream fos = openFileOutput("conein", Context.MODE_PRIVATE);
                        fos.write(ident.getBytes());
                        System.out.println(ident);
                        fos.close();
                        //go to work place
                        startActivity(new Intent(this, MainActivity.class));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            }
        });
    }
}
