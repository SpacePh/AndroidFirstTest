package com.example.uibasics;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txtHello;
    private Button btnChangeFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHello = findViewById(R.id.txtHello);
        btnChangeFont = findViewById(R.id.btnChangeFont);

        final Typeface typeface = ResourcesCompat.getFont(this, R.font.amsterdam);

        btnChangeFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHello.setTypeface(typeface);
            }
        });
    }

}