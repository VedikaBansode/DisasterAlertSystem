package com.example.disasteralertsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout screenContainer;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screenContainer = findViewById(R.id.screenContainer);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        // Open Map screen by default
        bottomNavigation.setSelectedItemId(R.id.nav_home);
        loadScreen(R.layout.screen_home);

        // Handle bottom navigation
        bottomNavigation.setOnItemSelectedListener(item -> {

            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                loadScreen(R.layout.screen_home);
                return true;

            } else if (itemId == R.id.nav_timeline) {
                loadScreen(R.layout.screen_timeline);
                return true;

            } else if (itemId == R.id.nav_map) {
                loadScreen(R.layout.screen_map);
                return true;

            } else if (itemId == R.id.nav_weather) {
                loadScreen(R.layout.screen_weather);
                return true;

            } else if (itemId == R.id.nav_menu) {
                loadScreen(R.layout.screen_menu);
                return true;
            }

            return false;
        });
    }

    private void loadScreen(int layoutId) {

        View screen = LayoutInflater.from(this)
                .inflate(layoutId, screenContainer, false);

        screenContainer.removeAllViews();
        screenContainer.addView(screen);
    }

    private void showPlaceholder(String screenName) {

        TextView placeholder = new TextView(this);

        placeholder.setText(screenName + " screen\nComing soon");
        placeholder.setTextSize(22);
        placeholder.setTextColor(
                getResources().getColor(R.color.text_primary)
        );

        placeholder.setGravity(android.view.Gravity.CENTER);

        screenContainer.removeAllViews();
        screenContainer.addView(placeholder);
    }
}