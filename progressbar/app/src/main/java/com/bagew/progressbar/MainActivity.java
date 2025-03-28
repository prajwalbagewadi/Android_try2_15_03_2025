package com.bagew.progressbar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    Button btn;
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
        pb = findViewById(R.id.progbar);
        btn = findViewById(R.id.startbtn);
        pb.setVisibility(View.VISIBLE);
        btn.setOnClickListener(View->new MyAsyncTask().execute());
    }
    private class MyAsyncTask extends AsyncTask<Void,Integer,String>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pb.setProgress(0);
            btn.setEnabled(false);//Disable button while task runs
        }
        @Override
        protected String doInBackground(Void... voids){
            for(int i=0;i<=100;i++){
                try{
                    Thread.sleep(500);// Simulate work (500ms per step)
                    publishProgress(i);//Update progress
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "Task Completed.";
        }
        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            pb.setProgress(values[0]);
        }
        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
            btn.setEnabled(true);//Re-enable button
        }
        /**
         * onPreExecute(): Prepares UI before starting the task.
         *
         * onProgressUpdate(): Updates the ProgressBar.
         *
         * onPostExecute(): Displays a Toast message when done.
         */
    }
}
