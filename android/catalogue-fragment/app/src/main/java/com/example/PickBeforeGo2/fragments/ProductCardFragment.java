package com.example.PickBeforeGo2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.PickBeforeGo2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductCardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int imgResource;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductCardFragment(Integer imgResource) {
        // Required empty public constructor
        this.imgResource = imgResource;
    }
    public ProductCardFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductCard.
     */
    // TODO: Rename and change types and number of parameters
//    public static ProductCardFragment newInstance(String param1, String param2) {
//
//        // TODO: BRAINSTORMING ONLY. BUT I THINK HERE CAN ADD IN BOOLEAN TO SAY WHETHER IN STOCK/NO STOCK. FROM THERE, CHANGE THE INFLATE USING IFELSE?
//        ProductCardFragment fragment = new ProductCardFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

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
        // TODO: if pass in info that there is no stock, use this return inflater.inflate(R.layout.fragment_product_card_no_stock, container, false);
        //      get the data from main

        Intent i = getActivity().getIntent();
        int imgId = i.getIntExtra("imgResource",0);
        boolean stock = i.getBooleanExtra("stock",true);
        View product_card = null;
        if (stock){
            product_card = inflater.inflate(R.layout.fragment_product_card,container,false);
            ImageView productImg = product_card.findViewById(R.id.productImg_frag);
            productImg.setImageResource(imgId);
        }
        else{
            product_card = inflater.inflate(R.layout.fragment_product_card_no_stock,container,false);
            ImageView productImg = product_card.findViewById(R.id.productImg_frag_nostock);
            productImg.setImageResource(imgId);
        }

        return product_card;
    }
}