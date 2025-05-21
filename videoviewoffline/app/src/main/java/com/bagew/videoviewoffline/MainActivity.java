package com.bagew.videoviewoffline;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        VideoView vv = findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(vv);
        vv.setMediaController(mc);
        vv.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.jdm);
        vv.setOnPreparedListener(mp -> {
            mp.setLooping(true);
            vv.start();
        });
        vv.setOnErrorListener((mp, what, extra) ->{
            Toast.makeText(this, "Error in the Video Playback", Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}