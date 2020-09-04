package com.atacelen.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        final ArrayList<String> foodNames = new ArrayList<>();
        foodNames.add("Quattro Formaggi");
        foodNames.add("Ravioli");
        foodNames.add("Paella");
        foodNames.add("Fondue");
        foodNames.add("Sushi");

        final ArrayList<Integer> foodCalories = new ArrayList<>();
        foodCalories.add(728);
        foodCalories.add(215);
        foodCalories.add(234);
        foodCalories.add(492);
        foodCalories.add(255);

        Bitmap quattroFormaggiBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.quattroformaggi);
        Bitmap ravioliBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ravioli);
        Bitmap paellaBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.paella);
        Bitmap fondueBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.fondue);
        Bitmap sushiBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.sushi);

        final ArrayList<Bitmap> foodImages = new ArrayList<>();

        foodImages.add(quattroFormaggiBitmap);
        foodImages.add(ravioliBitmap);
        foodImages.add(paellaBitmap);
        foodImages.add(fondueBitmap);
        foodImages.add(sushiBitmap);






        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, foodNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailedInfoActivity.class);
                intent.putExtra("foodname", foodNames.get(i));
                intent.putExtra("foodcalories", foodCalories.get(i));
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenFoodImage(foodImages.get(i));
                startActivity(intent);
            }
        });

    }
}