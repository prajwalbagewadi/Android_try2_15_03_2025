package com.bagew.galleryviewold;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class CustomGalleryAdpater extends BaseAdapter {
    private Context context;
    private int[] images;
    public CustomGalleryAdpater(Context context,int[] images){
        this.context=context;
        this.images=images;
    }
    // returns the number of images
    @Override
    public int getCount() {
        return images.length;
    }
    // returns the item at a given position (in this case, image resource ID)
    public Object getItem(int position) {
        return images[position];
    }
    //returns the ID of an item
    public long getItemId(int position) {
        return position;
    }

    // returns an ImageView view
    public View getView(int position, View convertView, ViewGroup parent){
        // create a ImageView programmatically
        ImageView imgview = new ImageView(context);
        imgview.setImageResource(images[position]); // set image in ImageView
        imgview.setLayoutParams(new Gallery.LayoutParams(450,450));// set ImageView param
        return  imgview;
    }
}
