package com.bagew.questionplaysonginbackground;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.media.MediaMetadataRetriever;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.animation.ObjectAnimator;

public class MainActivity extends AppCompatActivity {
//    public static Bitmap getAlbumArt(String filepath){
//        MediaMetadataRetriever mmdr = new MediaMetadataRetriever();
//        mmdr.setDataSource(filepath);
//        byte[] art = mmdr.getEmbeddedPicture();
//       // mmdr.release();
//        if (art!=null){
//            return BitmapFactory.decodeByteArray(art,0,art.length);
//        }
//        return null;
//    }
    private void startRotationAnimation(ImageView imageView){
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        rotationAnimator.setDuration(5000); // 5 seconds per full rotation
        rotationAnimator.setInterpolator(new LinearInterpolator()); // Smooth rotation
        rotationAnimator.setRepeatCount(ObjectAnimator.INFINITE); // Infinite loop
        rotationAnimator.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//        String mp3Path = "android.resource://"+getPackageName()+"/"+R.raw.afsosxjhol;
//        Bitmap albumart = getAlbumArt(mp3Path);
        ImageView iv = findViewById(R.id.poster);
//        if(albumart!=null){
//            iv.setImageBitmap(albumart);
//        }else{
//            iv.setImageResource(R.drawable.vinyl);
//        }
        iv.setImageResource(R.drawable.vinylbg);
        startRotationAnimation(iv);
        ImageButton startbtn = findViewById(R.id.play);
        ImageButton stopbtn = findViewById(R.id.stop);

        startbtn.setOnClickListener(v->startService(new Intent(this,AudioService.class)));
        stopbtn.setOnClickListener(v->stopService(new Intent(this,AudioService.class)));

    }
}