package com.example.sakib.womenchildcaredemo3.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.sakib.womenchildcaredemo3.MainActivity;
import com.example.sakib.womenchildcaredemo3.R;

public class DuringPregVaccine extends AppCompatActivity{

    ImageView vaccineImage;
    int currentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_preg_vaccine);

        vaccineImage = findViewById(R.id.vaccineImage);
        currentImage = R.drawable.vaccine_one;
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event) {
        if ((KeyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(DuringPregVaccine.this, MainActivity.class);
            startActivity(intent);
            DuringPregVaccine.this.finish();
            return true;
        }
        return super.onKeyDown(KeyCode, event);
    }

    public void goFront(View view) {
        if(currentImage == R.drawable.vaccine_one)
        {
            vaccineImage.setBackgroundResource(R.drawable.vaccine_two);
            currentImage = R.drawable.vaccine_two;
        }
        else if(currentImage == R.drawable.vaccine_two)
        {
            vaccineImage.setBackgroundResource(R.drawable.vaccine_three);
            currentImage = R.drawable.vaccine_three;
        }
        else if(currentImage == R.drawable.vaccine_three)
        {
            vaccineImage.setBackgroundResource(R.drawable.vaccine_one);
            currentImage = R.drawable.vaccine_one;
        }

    }

    public void goBack(View view) {
        if(currentImage == R.drawable.vaccine_one)
        {
            vaccineImage.setBackgroundResource(R.drawable.vaccine_three);
            currentImage = R.drawable.vaccine_three;
        }
        else if(currentImage == R.drawable.vaccine_two)
        {
            vaccineImage.setBackgroundResource(R.drawable.vaccine_one);
            currentImage = R.drawable.vaccine_one;
        }
        else if(currentImage == R.drawable.vaccine_three)
        {
            vaccineImage.setBackgroundResource(R.drawable.vaccine_two);
            currentImage = R.drawable.vaccine_two;
        }
    }
}
