package com.itismob.s03.lawan.giancarlo.exercise1;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean isFavorited = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        View mainView = findViewById(R.id.cl_main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // Favorite Button Logic
        ImageButton favoriteButton = findViewById(R.id.ib_favorite);
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFavorited = !isFavorited;
                if (isFavorited) {
                    favoriteButton.setImageResource(android.R.drawable.btn_star_big_on);
                } else {
                    favoriteButton.setImageResource(android.R.drawable.btn_star_big_off);
                }
            }
        });

        // Purchase Button Logic
        final Button purchaseButton = findViewById(R.id.btn_purchase);
        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseButton.setEnabled(false);
                purchaseButton.setText(R.string.purchased);
                purchaseButton.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
            }
        });
    }
}
