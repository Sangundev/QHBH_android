package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ProductAdapter;

import com.example.myapplication.Class.product;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<product> productList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();
        productList.add(new product("Coffee", "Delicious coffee",R.drawable.product));
        productList.add(new product("Tea", "Refreshing tea",R.drawable.product));
        productList.add(new product("Coffee", "Delicious coffee", R.drawable.product));
        productList.add(new product("Tea", "Refreshing tea",R.drawable.product));
        productList.add(new product("Coffee", "Delicious coffee", R.drawable.product));
        productList.add(new product("Tea", "Refreshing tea",R.drawable.product));
        productList.add(new product("Coffee", "Delicious coffee", R.drawable.product));
        productList.add(new product("Tea", "Refreshing tea",R.drawable.product));
        productList.add(new product("Coffee", "Delicious coffee", R.drawable.product));
        productList.add(new product("Tea", "Refreshing tea",R.drawable.product));

        // Add more products here

        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);
    }
}
