package com.example.sakib.womenchildcaredemo3.model;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sakib.womenchildcaredemo3.MainActivity;
import com.example.sakib.womenchildcaredemo3.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.sakib.womenchildcaredemo3.R.drawable.pause;

public class MotherIdealFood extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView textView;
    ScrollView scrollView;
    private NavigationView navigation;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private CoordinatorLayout coordinatorLayout;

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
        setContentView(R.layout.activity_mother_ideal_food);


        playButton = findViewById(R.id.playButton);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        textView = findViewById(R.id.textView);
        scrollView = findViewById(R.id.SCROLLER_ID);
        navigation = findViewById(R.id.navigationView);
        coordinatorLayout = findViewById(R.id.coordinator);
        front = findViewById(R.id.front);
        back = findViewById(R.id.back);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,mdrawerLayout,R.string.drawer_open,R.string.drawer_close);

        mdrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        readMessage(R.raw.food1);
        currentFile = R.raw.food1;

        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/SolaimanLipi.ttf");
        textView.setTypeface(myCustomFont);

        navigation.setNavigationItemSelectedListener(this);

        mp = MediaPlayer.create(MotherIdealFood.this,R.raw.pregmomfood_1);
        currentSound = R.raw.pregmomfood_1;
        //Toast.makeText(this,Integer.toString(currentSound),Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem Item)
    {
        if(actionBarDrawerToggle.onOptionsItemSelected(Item))
        {
            return  true;
        }

        return  super.onOptionsItemSelected(Item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        try
        {
            if(id == R.id.motherFood)
            {
                readMessage(R.raw.food1);
                //coordinatorLayout.setBackgroundResource(R.drawable.pregnent);
                //Toast.makeText(this,"week 1",Toast.LENGTH_LONG).show();
                setSound(R.raw.pregmomfood_1);
                mdrawerLayout.closeDrawers();
            }
            else if(id == R.id.calcium)
            {
                readMessage(R.raw.food2);
                //coordinatorLayout.setBackgroundResource(R.drawable.preg_week2);
                //Toast.makeText(this,"week 2",Toast.LENGTH_LONG).show();
                setSound(R.raw.pregmomfood_2);
                mdrawerLayout.closeDrawers();
            }
            else if(id == R.id.iron)
            {
                readMessage(R.raw.food3);
                //coordinatorLayout.setBackgroundResource(R.drawable.preg_week3);
                //Toast.makeText(this,"week 3",Toast.LENGTH_LONG).show();
                setSound(R.raw.pregmomfood_3);
                mdrawerLayout.closeDrawers();
            }
            else if(id == R.id.vitaminA)
            {
                readMessage(R.raw.food4);
                // Toast.makeText(this,"week 4",Toast.LENGTH_LONG).show();
                setSound(R.raw.pregmomfood_4);

                mdrawerLayout.closeDrawers();
            }
            else if(id == R.id.vitaminB)
            {
                readMessage(R.raw.food5);
                // Toast.makeText(this,"week 4",Toast.LENGTH_LONG).show();
                setSound(R.raw.pregmomfood_5);
                mdrawerLayout.closeDrawers();
            }
            else
            {
                Toast.makeText(this,"Content is missing",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(MotherIdealFood.this,"No Files Available",Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event) {
        if ((KeyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(MotherIdealFood.this, MainActivity.class);
            startActivity(intent);
            MotherIdealFood.this.finish();
            mp.stop();
            return true;
        }
        return super.onKeyDown(KeyCode, event);
    }


    public void readMessage(int fileName)
    {
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
            mp = MediaPlayer.create(MotherIdealFood.this,sound);
            //Toast.makeText(this,Integer.toString(soundFile),Toast.LENGTH_LONG).show();
            currentSound = sound;
        }
        else
        {
            mp = MediaPlayer.create(MotherIdealFood.this,sound);
            mp.start();
            playButton.setBackgroundResource(R.drawable.pause);
            //Toast.makeText(this,Integer.toString(soundFile),Toast.LENGTH_LONG).show();
            currentSound = sound;
            key = true;
        }
    }

    public void playSound(View view)
    {
        if(key == false)
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
        }
    }

    public void goFront(View view)
    {
        try {
            if(currentFile >= R.raw.food1 && currentFile < R.raw.food5)
            {
                readMessage(currentFile + 1);
            }
            if(currentSound >= R.raw.pregmomfood_1 && currentSound <R.raw.pregmomfood_5)
            {
                setSound(currentSound+1);
                //Toast.makeText(this,Integer.toString(currentSound),Toast.LENGTH_LONG).show();
            }
            else
            {
                readMessage(R.raw.food1);
                setSound(R.raw.pregmomfood_1);
            }
        }
        catch (Exception e)
        {
            setSound(R.raw.pregmomfood_1);
        }
    }

    public void goBack(View view)
    {
        try
        {
            if(currentFile >= R.raw.food1)
            {
                readMessage(currentFile - 1);
            }
            if(currentSound >= R.raw.pregmomfood_1)
            {
                setSound(currentSound - 1);
            }
            else if(currentFile <= R.raw.food1)
            {
                readMessage(R.raw.food1);
            }
            else if(currentSound <= R.raw.pregmomfood_1)
            {
                setSound(R.raw.pregmomfood_1);
            }
        }
        catch (Exception e)
        {
            setSound(R.raw.pregmomfood_1);
        }
    }


}
