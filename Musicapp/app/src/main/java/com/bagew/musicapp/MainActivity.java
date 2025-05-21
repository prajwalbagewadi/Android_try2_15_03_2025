package com.bagew.musicapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bagew.musicapp.databinding.ActivityMainBinding;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CircularProgressBar circularSeekBar = binding.circularSeekBar;
        ImageView pointer = binding.pointer;
        float progress = circularSeekBar.getProgress();
        float angle = (progress/circularSeekBar.getProgress())*360f;
        pointer.setRotation(angle);
        YouTubeDataFetcher.fetchVideoDetails("dQw4w9WgXcQ");

    }
}