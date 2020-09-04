package com.atacelen.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedInfoActivity extends AppCompatActivity {

    ImageView imageView;
    TextView foodNameText, foodCaloriesText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_info);

        imageView = findViewById(R.id.imageView);
        foodNameText = findViewById(R.id.foodNameText);
        foodCaloriesText = findViewById(R.id.foodCaloriesText);

        Intent intent = getIntent();

        String foodName = intent.getStringExtra("foodname");
        Integer foodCalories = intent.getIntExtra("foodcalories", 0);

        Singleton singleton = Singleton.getInstance();
        Bitmap foodImage = singleton.getChosenFoodImage();

        foodNameText.setText("Food Name: " + foodName);
        foodCaloriesText.setText("Calories: " + foodCalories.toString());
        imageView.setImageBitmap(foodImage);


    }
}