package com.example.PickBeforeGo2.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.PickBeforeGo2.R;

public class ProductScreenActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    public final String TAG = "Logcat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_product_screen);
        ImageView imageButton = findViewById(R.id.imageButton);
        // set up top bar




//        ConstraintLayout product_screen = findViewById(R.id.product_screen);
//        product_screen.addView(v);
////        ConstraintSet set = new ConstraintSet();
////        set.clone(product_screen);
//        ConstraintLayout.LayoutParams product_layout_param = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            product_screen.setForegroundGravity(Gravity.CENTER);
//        }
//        product_screen.setElevation(10);

//         set up fragments
//        Fragment availability = new AvailabilityFragment();
//        Fragment productCard = new ProductCardFragment();
//        FragmentManager manager = getSupportFragmentManager();
//        transaction = manager.beginTransaction();
//        transaction.add(R.id.fragment_product_card, productCard, "Product_Card");
//        transaction.add(R.id.fragment_availability, availability, "Availability");
//        transaction.addToBackStack(null);
//        transaction.commit();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}