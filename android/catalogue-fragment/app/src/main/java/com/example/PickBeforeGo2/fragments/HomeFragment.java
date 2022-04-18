package com.example.PickBeforeGo2.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.PickBeforeGo2.MainActivity;
import com.example.PickBeforeGo2.R;
import com.example.PickBeforeGo2.activities.ProductScreenActivity;
import com.example.PickBeforeGo2.components.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private BottomNavigationView bottom_bar;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ArrayList productList = new ArrayList();
        ArrayList promoList = new ArrayList();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference();
        dbRef.child("Product_List").addListenerForSingleValueEvent(new ValueEventListener() {
              @Override
              public void onDataChange(DataSnapshot dataSnapshot) {
                  productList.clear();
                  // get all of the children at this level.
                  for (DataSnapshot child : dataSnapshot.getChildren()) {
                      Product product = child.getValue(Product.class);
                      if (product.getIsPromo()){
                          promoList.add(product);
                      }
                      productList.add(product);
                  }
                  int l = promoList.size();
                  System.out.println(l);
                  addBox(view,inflater,l,promoList);
              }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                    Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
            }
          });


        return view;
    }

    public void addBox(View view, LayoutInflater inflater, int length, ArrayList<Product> productlist){
//         promotion
        ConstraintLayout home_layout = view.findViewById(R.id.main_home);
        LinearLayout promotion = home_layout.findViewById(R.id.promoLayout);
        for (int i=0; i<length; i++){
            Product product = productlist.get(i);
            View productLayout = inflater.inflate(R.layout.individual_product,null);
            ShapeableImageView prod_main = productLayout.findViewById(R.id.product_main_img);
            Picasso.get().load(product.getImageURL()).into(prod_main);
            int discountPercent = (int)(product.getDiscountPercent());
            TextView promodetail = productLayout.findViewById(R.id.promodetail);
            promodetail.setText("Promo "+discountPercent);
            TextView name = productLayout.findViewById(R.id.nameTxt);
            name.setText(product.getProductName());
            int resID = View.generateViewId();
            productLayout.setId(resID);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(380, 500);
            params.setMargins(50, 0, 20, 0);
            productLayout.setLayoutParams(params);
            productLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),ProductScreenActivity.class);
//                    intent.putExtra("imgResource",((Product) productList.get(k)).getImageId());
//                    intent.putExtra("stock",((Product) productList.get(k)).getStock());
                    startActivity(intent);
                }
            });
            promotion.addView(productLayout);
        }

        // recent purchase
        LinearLayout purchase = home_layout.findViewById(R.id.favLayout);
        for (int i=0; i<length; i++){
            int k = i;
            View productLayout = inflater.inflate(R.layout.individual_product,null);
            ShapeableImageView prod_main = productLayout.findViewById(R.id.product_main_img);
            if (i==0){
                prod_main.setImageResource(R.drawable.bread);
//                prod_main.setImageURI(Uri.parse((productsList.get(i)).getImage()));
            }
            else {prod_main.setImageResource(R.drawable.bread);}
            int resID = View.generateViewId();
            productLayout.setId(resID);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(380, 500);
            params.setMargins(50, 0, 20, 0);
            productLayout.setLayoutParams(params);
            productLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),ProductScreenActivity.class);
                    System.out.println(k);
//                    intent.putExtra("imgResource",((Product) productList.get(k)).getImageId());
                    startActivity(intent);
                }
            });
            purchase.addView(productLayout);
        }
    }
}


