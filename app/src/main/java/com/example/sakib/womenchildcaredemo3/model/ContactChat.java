package com.example.sakib.womenchildcaredemo3.model;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sakib.womenchildcaredemo3.MainActivity;
import com.example.sakib.womenchildcaredemo3.R;


public class ContactChat extends AppCompatActivity {

    ImageButton ib;
    TextView tv;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_chat);

        ib = findViewById(R.id.buttonImage);
        tv = findViewById(R.id.textView);

//        ib.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent callIntent = new Intent(Intent.ACTION_CALL_BUTTON);
//                callIntent.setData(Uri.parse("tel:01918047180"));
//
//                if (ActivityCompat.checkSelfPermission(ContactChat.this,
//                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    return;
//                }
//                startActivity(callIntent);
//
//            }
//        });
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event) {
        if ((KeyCode == KeyEvent.KEYCODE_BACK))
        {
            Intent intent = new Intent(ContactChat.this, MainActivity.class);
            startActivity(intent);
            ContactChat.this.finish();
            return true;
        }
        return super.onKeyDown(KeyCode, event);
    }



    public void CallDoctor(View view) {

        try
        {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:01918047180"));
            //Toast.makeText(ContactChat.this,"yes",Toast.LENGTH_LONG).show();
            startActivity(callIntent);
        }
        catch (Exception e)
        {
            Toast.makeText(ContactChat.this,e.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
