package com.example.sakib.womenchildcaredemo3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sakib.womenchildcaredemo3.adapter.GridAdapter;
import com.example.sakib.womenchildcaredemo3.model.AfterPregCare;
import com.example.sakib.womenchildcaredemo3.model.ChildCare;
import com.example.sakib.womenchildcaredemo3.model.ContactChat;
import com.example.sakib.womenchildcaredemo3.model.DuringPregCaring;
import com.example.sakib.womenchildcaredemo3.model.DuringPregVaccine;
import com.example.sakib.womenchildcaredemo3.model.ItemType;
import com.example.sakib.womenchildcaredemo3.model.MotherIdealFood;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity //implements NavigationView.OnNavigationItemSelectedListener
{

    GridView gridView;
    GridAdapter adapter;
    ArrayList<ItemType> cricketers;

    //private NavigationView navigation;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        //navigation = findViewById(R.id.navigationView);

//        actionBarDrawerToggle = new ActionBarDrawerToggle(this,mdrawerLayout,R.string.drawer_open,R.string.drawer_close);
//
//        mdrawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        navigation.setNavigationItemSelectedListener(this);


        cricketers = new ArrayList<>();
        setData();
        adapter = new GridAdapter(cricketers, MainActivity.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0)
                {
                    Intent intent = new Intent(MainActivity.this, DuringPregCaring.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
                else if(i == 1)
                {
                    Intent intent = new Intent(MainActivity.this, DuringPregVaccine.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
                else if(i == 2)
                {
                    Intent intent = new Intent(MainActivity.this, MotherIdealFood.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
                else if(i == 3)
                {
                    Intent intent = new Intent(MainActivity.this, AfterPregCare.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
                else if(i == 4)
                {
                    Intent intent = new Intent(MainActivity.this, ChildCare.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
                else if(i == 5)
                {
                    Intent intent = new Intent(MainActivity.this, ContactChat.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
            }
        });

    }

    private void setData() {
//        ItemType duringPreg = new ItemType(R.drawable.duringpreg, "গর্ভকালীন সেবা");
//        ItemType food = new ItemType(R.drawable.food, "সুষম খাবার");
//        ItemType afterPreg = new ItemType(R.drawable.afterpreg, "গর্ভ পরবর্তী সেবা");
//        ItemType childCare = new ItemType(R.drawable.childcare, "শিশু সেবা");
//        ItemType vaccine = new ItemType(R.drawable.vaccine, "গর্ভকালীন টিকা");
//        ItemType chat = new ItemType(R.drawable.chat, "লাইভ চ্যাট");


        ItemType duringPreg = new ItemType(R.drawable.duringpreg);
        ItemType food = new ItemType(R.drawable.food);
        ItemType afterPreg = new ItemType(R.drawable.afterpreg);
        ItemType childCare = new ItemType(R.drawable.childcare);
        ItemType vaccine = new ItemType(R.drawable.vaccine);
        ItemType chat = new ItemType(R.drawable.chat);

        cricketers.add(duringPreg);
        cricketers.add(vaccine);
        cricketers.add(food);
        cricketers.add(afterPreg);
        cricketers.add(childCare);
        cricketers.add(chat);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem Item)
//    {
//        if(actionBarDrawerToggle.onOptionsItemSelected(Item))
//        {
//            return  true;
//        }
//
//        return  super.onOptionsItemSelected(Item);
//    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item)
//    {
//        int id = item.getItemId();
//
//        if(id == R.id.accountLogin)
//        {
//            Toast.makeText(this,"this is Account",Toast.LENGTH_LONG).show();
//            mdrawerLayout.closeDrawers();
//        }
//        else if(id == R.id.address)
//        {
//            Toast.makeText(this,"this is system",Toast.LENGTH_LONG).show();
//        }
//        else if(id == R.id.logOut)
//        {
//            Toast.makeText(this,"this is login",Toast.LENGTH_LONG).show();
//        }
//
//        return false;
//    }

}
