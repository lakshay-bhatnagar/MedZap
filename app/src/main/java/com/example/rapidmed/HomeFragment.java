package com.example.rapidmed;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    private Button addToCartButton;
    private LinearLayout quantityLayout;
    private Button incrementButton, decrementButton;
    private TextView quantityText;
    private int quantity = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize views
        addToCartButton = view.findViewById(R.id.add_to_cart_button);
        quantityLayout = view.findViewById(R.id.quantity_layout);
        incrementButton = view.findViewById(R.id.increment_button);
        decrementButton = view.findViewById(R.id.decrement_button);
        quantityText = view.findViewById(R.id.quantity_text);

        // Set click listener for "Add to Cart" button
        addToCartButton.setOnClickListener(v -> {
            // Hide "Add to Cart" button and show quantity controls
            addToCartButton.setVisibility(View.GONE);
            quantityLayout.setVisibility(View.VISIBLE);
        });

        // Increment button click listener
        incrementButton.setOnClickListener(v -> {
            quantity++;
            quantityText.setText(String.valueOf(quantity));
        });

        // Decrement button click listener
        decrementButton.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                quantityText.setText(String.valueOf(quantity));
            } else if (quantity == 1) {
                // Hide quantity controls and show "Add to Cart" button
                quantity = 0;  // Set quantity to 0 to signify that item is removed from cart
                quantityLayout.setVisibility(View.GONE);
                addToCartButton.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}
