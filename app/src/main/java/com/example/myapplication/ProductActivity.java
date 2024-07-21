package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ProductAdapter;
import com.example.myapplication.Class.product;
import com.example.myapplication.SQlite.DatabaseHelper;

import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<product> productList;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        dbHelper = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lấy dữ liệu từ SQLite
        productList = dbHelper.getAllProducts();

        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);

        // Hiển thị số lượng sản phẩm
        int productCount = dbHelper.getCount("SANPHAM");
        Toast.makeText(this, "Total products: " + productCount, Toast.LENGTH_SHORT).show();
    }
}
