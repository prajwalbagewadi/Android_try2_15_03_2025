package com.bagew.imageswitcher;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

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
        ImageSwitcher imageSwitcher = findViewById(R.id.imageSwitcher);
        //Set factory for creating ImageView
        imageSwitcher.setFactory(()->{
            ImageView iv = new ImageView(getApplicationContext());
            iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            return iv;
        });

        //Animation
        Animation inAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation outAnim = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        imageSwitcher.setInAnimation(inAnim);
        imageSwitcher.setOutAnimation(outAnim);

        // Image list
        int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3,
                        R.drawable.img4, R.drawable.img5, R.drawable.img6,
                        R.drawable.img7, R.drawable.img8, R.drawable.img9};
        // Index tracker
        int []  currentIndex = {0};
        // Set initial image
        imageSwitcher.setImageResource(images[currentIndex[0]]);
        // Switch image on click
        imageSwitcher.setOnClickListener(v->{
            //Later you can switch to another image
            currentIndex[0] = (currentIndex[0] + 1) % images.length;
            imageSwitcher.setImageResource(images[currentIndex[0]]);
        });
    }
}
