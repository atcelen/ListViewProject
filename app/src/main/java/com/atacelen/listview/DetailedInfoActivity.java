package com.atacelen.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedInfoActivity extends AppCompatActivity {

    // Attributes
    ImageView imageView;
    TextView foodNameText, foodCaloriesText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_info);

        imageView = findViewById(R.id.imageView);
        foodNameText = findViewById(R.id.foodNameText);
        foodCaloriesText = findViewById(R.id.foodCaloriesText);

        //Receives the intent sent from the other Activity
        Intent intent = getIntent();

        //Receives the information put into the intent
        String foodName = intent.getStringExtra("foodname");
        Integer foodCalories = intent.getIntExtra("foodcalories", 0);

        // See "Singleton.java" for details
        Singleton singleton = Singleton.getInstance();
        Bitmap foodImage = singleton.getChosenFoodImage();

        //Sets the text/image for the TextView/ImageView
        foodNameText.setText("Food Name: " + foodName);
        foodCaloriesText.setText("Calories: " + foodCalories.toString());
        imageView.setImageBitmap(foodImage);


    }
}