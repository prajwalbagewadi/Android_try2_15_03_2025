package com.bagew.gridview;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Array of image resource names as Integer
    Integer[] imgs= {R.drawable.img1,R.drawable.img2,R.drawable.img3,
            R.drawable.img4,R.drawable.img5,R.drawable.img6,
            R.drawable.img7,R.drawable.img8,R.drawable.img9};


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
        GridView gridView = findViewById(R.id.gridView);
        ImageView imageView = findViewById(R.id.imageView);
        gridView.setAdapter(new ImageAdapter());
        gridView.setOnItemClickListener((parent,view,position,id)->{
            imageView.setImageResource(imgs[position]);
            Toast.makeText(this, "Clicked img 📸"+(position+1), Toast.LENGTH_SHORT).show();
        });
        }
        class ImageAdapter extends BaseAdapter{
            @Override
            public int getCount(){
                return imgs.length;
            }
            @Override
            public Object getItem(int position){
                return imgs[position];
            }
            @Override
            public long getItemId(int position){
                return position;
            }
            @Override
            public View getView(int position,View convertView,ViewGroup parent){
                ImageView iv = new ImageView(MainActivity.this);
                iv.setImageResource(imgs[position]);
                iv.setLayoutParams(new GridView.LayoutParams(300,300));
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                iv.setPadding(8,8,8,8);
                return iv;
            }
        }
    }
