package com.example.PickBeforeGo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.PickBeforeGo.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InStockProductCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InStockProductCardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InStockProductCardFragment() {
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
    public static InStockProductCardFragment newInstance(String param1, String param2) {
        InStockProductCardFragment fragment = new InStockProductCardFragment();
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

        // TODO: if pass in info that there is no stock, use this return inflater.inflate(R.layout.fragment_product_card_no_stock, container, false);
        Intent i = getActivity().getIntent();
        String imgResource = i.getStringExtra("imgResource");
        boolean stock = i.getBooleanExtra("stock",true);
        String name = i.getStringExtra("name");
        boolean promotion = i.getBooleanExtra("isPromotion",false);
        String price = i.getStringExtra("price");
        int discountPercent = (int) i.getDoubleExtra("discountPercent",0);

        View product_card = null;
        if (promotion){
            product_card = inflater.inflate(R.layout.fragment_inner_product_card_promo,container,false);
            ImageView productImg = product_card.findViewById(R.id.imgPicture);
            Picasso.get().load(imgResource).into(productImg);
            TextView discountPercentText = product_card.findViewById(R.id.txtPromo);
            discountPercentText.setText("Promo "+discountPercent);
            TextView nameText = product_card.findViewById(R.id.txtName);
            nameText.setText(name);
            TextView priceText = product_card.findViewById(R.id.txtPrice);
            priceText.setText("$"+price);
        }
        else if (stock){
            product_card = inflater.inflate(R.layout.fragment_inner_product_card_in_stock,container,false);
            ImageView productImg = product_card.findViewById(R.id.imgPicture);
            Picasso.get().load(imgResource).into(productImg);
            TextView nameText = product_card.findViewById(R.id.txtName);
            nameText.setText(name);
            TextView priceText = product_card.findViewById(R.id.txtPrice);
            priceText.setText("$"+price);

        }
        else{
            product_card = inflater.inflate(R.layout.fragment_inner_product_card_no_stock,container,false);
            ImageView productImg = product_card.findViewById(R.id.imgPicture);
            Picasso.get().load(imgResource).into(productImg);
            TextView nameText = product_card.findViewById(R.id.txtName);
            nameText.setText(name);
            TextView priceText = product_card.findViewById(R.id.txtPrice);
            priceText.setText("$"+price);
        }

        return product_card;    }
}