package com.example.PickBeforeGo2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PickBeforeGo2.MainActivity;
import com.example.PickBeforeGo2.R;
import com.example.PickBeforeGo2.adapters.ProductRVAdapter;
import com.example.PickBeforeGo2.components.Product;

import java.util.ArrayList;

public class CatalogueFragment extends Fragment {
    private final int position;
    private ArrayList<Product> productArrayList;

    public CatalogueFragment(int position){
        this.position = position;
    }
    private ArrayList productList = ((MainActivity)getActivity()).getAllProductArrayList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_catalogue,null);

        ArrayList<Product> productArrayList = new ArrayList<Product>();

        RecyclerView productRV = rootView.findViewById(R.id.product_rv);

        //All Tab

        System.out.println("product catalogue: "+productArrayList.size());
        if (position == 0){
            //get data from database and populate catalogue here
//            productArrayList.add(new Product("White Bread", "500g", "Gardenia",true, R.drawable.milk_soap));
//            productArrayList.add(new Product("Tissue", "light", "Kleenex", true,R.drawable.tissue));
//            productArrayList.add(new Product("Soap", "200g", "Meril", true,R.drawable.milk_soap));
//            productArrayList.add(new Product("BOY", "TALL", "HUMAN", true,R.drawable.bread));
//            productArrayList.add(new Product("BOY", "TALL", "HUMAN", true,R.drawable.bread));
//            productArrayList.add(new Product("BOY", "TALL", "HUMAN", true,R.drawable.bread));
//            productArrayList.add(new Product("BOY", "TALL", "HUMAN", true,R.drawable.bread));
        }
        // Favourites Tab
        else if (position == 1){
            //get data from database and populate catalogue here
//            productArrayList.add(new Product("White Bread", "500g", "Gardenia", true,R.drawable.milk_soap));
//            productArrayList.add(new Product("Tissue", "light", "Kleenex", true,R.drawable.milk_soap));
//            productArrayList.add(new Product("Soap", "200g", "Meril", true,R.drawable.milk_soap));
        }

        ProductRVAdapter productRVAdapter = new ProductRVAdapter(getActivity(), productArrayList);

        int numOfColumns = 2;
        productRV.setLayoutManager(new GridLayoutManager(getActivity(), numOfColumns));

        productRV.setAdapter(productRVAdapter);

        // Inflate the layout for this fragment
        return rootView;
    }
}
