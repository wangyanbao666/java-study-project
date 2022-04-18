package com.example.PickBeforeGo2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.PickBeforeGo2.components.Product;
import com.example.PickBeforeGo2.helper.GetProductHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Toolbar topbar;
    private BottomNavigationView bottom_bar;
//    img for homepage
//    private Integer[] imgId = {R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5};
    private static final String TAG = "Main activity";
    private ArrayList<Product> allProductArrayList;
    private ArrayList<Product> favouriteProductArrayList;
    private ArrayList<Product> promoProductArrayList;
    private ArrayList<Product> noStockProductArrayList;
    SharedPreferences mainSharedPreference;

    public ArrayList<Product> getAllProductArrayList(){
        return this.allProductArrayList;
    }

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (allProductArrayList == null){
            GetProductHelper getProduct = new GetProductHelper();
            allProductArrayList = getProduct.getAllProducts();
            favouriteProductArrayList = getProduct.getFavouriteProducts();
            promoProductArrayList = getProduct.getPromotionProducts();
            noStockProductArrayList = getProduct.getNoStockProducts();
        }

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference dbRef = database.getReference();
//        dbRef.child("Product").addListenerForSingleValueEvent(new ValueEventListener() {
//              @Override
//              public void onDataChange(DataSnapshot dataSnapshot) {
//                  productsList.clear();
//                  // get all of the children at this level.
//                  for (DataSnapshot child : dataSnapshot.getChildren()) {
//                      Products product = child.getValue(Products.class);
//                      productsList.add(product);
//                  }
//              }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                    Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
//            }
//          });

        mainSharedPreference = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        String Rate_text = mainSharedPreference.getString("test","test failed");
        System.out.println(Rate_text);

        //set up the bottom navigation bar
        bottom_bar = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,R.id.my_nav);
        NavigationUI.setupWithNavController(bottom_bar,navController);

        Toast.makeText(MainActivity.this,"Welcome back",Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.top_bar,menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor =
                mainSharedPreference.edit();
        preferencesEditor.putString("test", "test1");
        preferencesEditor.apply();
    }

}