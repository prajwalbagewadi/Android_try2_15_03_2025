package com.bagew.questionplaysonginbackground;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class AudioService extends Service {
    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate(){
        super.onCreate();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            getSystemService(NotificationManager.class).createNotificationChannel(
                    new NotificationChannel("com.bagew.questionplaysonginbackground.AudioService","Audio Service",NotificationManager.IMPORTANCE_LOW));
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.afsosxjhol);
        mediaPlayer.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        startForeground(1,new NotificationCompat.Builder(this,"com.bagew.questionplaysonginbackground.AudioService").setContentTitle("playingaudio").setContentText("background music is playing").build());
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
        }
        return START_STICKY;
    }

    public void onDestory(){
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        super.onDestroy();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }
}
