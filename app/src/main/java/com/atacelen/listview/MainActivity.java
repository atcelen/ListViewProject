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

    /*
    The onCreate method is called when the activity is first started

    Documentation:
    https://developer.android.com/guide/components/activities/activity-lifecycle
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Links the main activity with our code
        setContentView(R.layout.activity_main);

        /*
        The listView is being defined by calling the "findViewById" method.
        The listView in the xml file is being linked to the listView object of our code.
        As parameter, the ID of the referenced object is provided as an integer. The IDs from the xml file can be reached under "R.id"
         */
        ListView listView = findViewById(R.id.listView);

        //Initializing the Food Names array list (Array lists don't have a fixed length therefore they are better suited in this context)
        final ArrayList<String> foodNames = new ArrayList<>();
        foodNames.add("Quattro Formaggi");
        foodNames.add("Ravioli");
        foodNames.add("Paella");
        foodNames.add("Fondue");
        foodNames.add("Sushi");

        //Initializing the Food Calories array list
        final ArrayList<Integer> foodCalories = new ArrayList<>();
        foodCalories.add(728);
        foodCalories.add(215);
        foodCalories.add(234);
        foodCalories.add(492);
        foodCalories.add(255);

        /*
        "BitmapFactory.decodeResource" method converts a resource into a Bitmap.
        Its parameters are the resources of the current Activity. (You could either use "MainActivity.this" or "getApplicationContext()"as the context)

        If you want to add an image to your project, you can add it in the file "res/drawable" (not "res/drawable-v24"!).

        Documentation:
        https://docs.microsoft.com/en-us/dotnet/api/android.graphics.bitmapfactory.decoderesource?view=xamarin-android-sdk-9
         */
        Bitmap quattroFormaggiBitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(),R.drawable.quattro_formaggi);
        Bitmap ravioliBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ravioli);
        Bitmap paellaBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.paella);
        Bitmap fondueBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.fondue);
        Bitmap sushiBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.sushi);

        // Initializing the food Images array list
        final ArrayList<Bitmap> foodImages = new ArrayList<>();
        foodImages.add(quattroFormaggiBitmap);
        foodImages.add(ravioliBitmap);
        foodImages.add(paellaBitmap);
        foodImages.add(fondueBitmap);
        foodImages.add(sushiBitmap);





        /*
        We define an array adapter, which converts the array lists into views that are later added to the listView.
        The method takes the context ,the resource and an array of objects as parameters.
        In this example, we can directly use the resource provided to us by Android Studio. However, we will be creating our own layout in the customView project.
        You can also experiment with other layout types under "android.R.layout"
         */
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, foodNames);
        listView.setAdapter(arrayAdapter);
        // This method is called when an item on the listView is being clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // parameter "i" is the index of the clicked item in the list
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*
                Intents are mainly used to jump between activities and classes ( We will also see other examples)
                As parameters, the current context and the class that will be switched to, is given
                 */
                Intent intent = new Intent(MainActivity.this, DetailedInfoActivity.class);

                //"putExtra" method adds information to our intent, which will then be carried to the other activity
                intent.putExtra("foodname", foodNames.get(i));
                intent.putExtra("foodcalories", foodCalories.get(i));

                // See "Singleton.java" for details
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenFoodImage(foodImages.get(i));

                //Used to start the intent
                startActivity(intent);
            }
        });

    }
}