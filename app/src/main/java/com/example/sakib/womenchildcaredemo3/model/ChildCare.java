package com.example.sakib.womenchildcaredemo3.model;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.sakib.womenchildcaredemo3.MainActivity;
import com.example.sakib.womenchildcaredemo3.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ChildCare extends AppCompatActivity {

    TextView textView;
    ScrollView scrollView;
    private NavigationView navigation;
    private DrawerLayout mdrawerLayout;

    ImageButton front;
    ImageButton back;

    private int currentFile = 0;
    private int currentSound = 0;

    MediaPlayer mp;
    ImageButton playButton;

    boolean key = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_care);

        playButton = findViewById(R.id.playButton);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        textView = findViewById(R.id.textView);
        scrollView = findViewById(R.id.SCROLLER_ID);
        navigation = findViewById(R.id.navigationView);
        front = findViewById(R.id.front);
        back = findViewById(R.id.back);

        readMessage(R.raw.childcare);
        currentFile = R.raw.childcare;
        //changeBackground(R.drawable.preg_week1);

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/SolaimanLipi.ttf");
        textView.setTypeface(myCustomFont);

        //mp = MediaPlayer.create(ChildCare.this,R.raw.afterpregcare_1);
        //currentSound = R.raw.afterpregcare_1;
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event) {
        if ((KeyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(ChildCare.this, MainActivity.class);
            startActivity(intent);
            ChildCare.this.finish();
            //mp.stop();
            return true;
        }
        return super.onKeyDown(KeyCode, event);
    }

    private void readMessage(int fileName) {
        try {
            String message;
            StringBuffer stringBuffer = new StringBuffer();
            InputStream inputStream = this.getResources().openRawResource(fileName);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            if (inputStream != null) {
                try {
                    while ((message = bufferedReader.readLine()) != null) {
                        stringBuffer.append(message + "\n");
                    }
                    textView.setText(stringBuffer);
                    inputStream.close();
                } catch (Exception e) {

                }
            }

        } catch (Exception e) {
            Log.i("Error : ", "readMessage: "+e.toString());
        }

        currentFile = fileName;
    }

    private void setSound(int sound) {
        if(key == true)
        {
            mp.stop();
            playButton.setBackgroundResource(R.drawable.play);
            key = false;
            mp = MediaPlayer.create(ChildCare.this,sound);
            //Toast.makeText(this,Integer.toString(soundFile),Toast.LENGTH_LONG).show();
            currentSound = sound;
        }
        else
        {
            mp = MediaPlayer.create(ChildCare.this,sound);
            mp.start();
            playButton.setBackgroundResource(R.drawable.pause);
            //Toast.makeText(this,Integer.toString(soundFile),Toast.LENGTH_LONG).show();
            currentSound = sound;
            key = true;
        }
    }

    public void playSound(View view) {

        /*if(key == false)
        {
            mp.start();
            playButton.setBackgroundResource(R.drawable.pause);
            key = true;
        }
        else if(key == true)
        {
            mp.pause();
            playButton.setBackgroundResource(R.drawable.play);
            key = false;
        }*/

    }

    public void goFront(View view) {
    }

    public void goBack(View view) {
    }
}
