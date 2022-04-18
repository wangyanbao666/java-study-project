package com.example.PickBeforeGo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.PickBeforeGo.MainActivity;
import com.example.PickBeforeGo.R;
import com.example.PickBeforeGo.fragments.InStockAvailabilityFragment;
import com.example.PickBeforeGo.fragments.InStockProductCardFragment;
import com.example.PickBeforeGo.fragments.NoStockAvailabilityFragment;
import com.example.PickBeforeGo.fragments.NoStockProductCardFragment;
import com.example.PickBeforeGo.fragments.PromoProductCardFragment;

public class ProductScreenActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_screen);
        ImageView btnBack = findViewById(R.id.btnBack);
        // set up top bar

        // set up fragments
        Fragment productCardFragment = new InStockProductCardFragment();
        Fragment availabilityFragment = new InStockAvailabilityFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_productCard, productCardFragment, "Product_Card");
        fragmentTransaction.add(R.id.fragment_availability, availabilityFragment, "Availability");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductScreenActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}