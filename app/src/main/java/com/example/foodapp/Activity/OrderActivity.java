package com.example.foodapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Adapter.CartAdapter;
import com.example.foodapp.Adapter.OrderAdapter;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.ManagmentCart;
import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityCartBinding;
import com.example.foodapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends BaseActivity {
    private ActivityOrderBinding binding;
    private RecyclerView.Adapter adapter;
    private double tax;
    private ArrayList<Foods> listFood ;
    private double fee;
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        order = findViewById(R.id.orderBtn);

        initList();
        setVariable();
        caculateCart();
        oderButton();
    }

    private void oderButton() {
        order.setOnClickListener(view -> {
            if(binding.consigneeEdt.getText().toString().isEmpty()){
                Toast.makeText(OrderActivity.this,"Vui lòng nhập tên người nhận.",Toast.LENGTH_SHORT).show();
                binding.consigneeEdt.requestFocus();
                return;
            }
            if(binding.consigneePhoneEdt.getText().toString().isEmpty()){
                Toast.makeText(OrderActivity.this,"Vui lòng nhập số điện thoại người nhận.",Toast.LENGTH_SHORT).show();
                binding.consigneePhoneEdt.requestFocus();
                return;
            }
            if(binding.addressEdt.getText().toString().isEmpty()){
                Toast.makeText(OrderActivity.this,"Vui lòng nhập địa chỉ người nhận.",Toast.LENGTH_SHORT).show();
                binding.addressEdt.requestFocus();
                return;
            }
            if(binding.payGroupRbt.getCheckedRadioButtonId() == -1){
                Toast.makeText(OrderActivity.this,"Vui lòng chọn phương thức thanh toán.",Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(OrderActivity.this,StatusActivity.class);
            startActivity(intent);
        });
    }

    private void setVariable() {
        binding.backOrder.setOnClickListener(view -> finish());
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.orderView.setLayoutManager(linearLayoutManager);
        listFood = (ArrayList<Foods>) getIntent().getSerializableExtra("listcart");
        fee =  getIntent().getDoubleExtra("totalfee",0.0);
        adapter = new OrderAdapter(listFood, this, () -> caculateCart());
        binding.orderView.setAdapter(adapter);
    }

    private void caculateCart() {
        double percentTax = 0.02; //percent 2% tax
        double delivery = 10; // 10 dollar

        tax = Math.round(fee * percentTax);
        double total = Math.round(fee + tax + delivery);
        double itemTotal = Math.round(fee);
        binding.totalFeeTxt1.setText("$" + itemTotal);
        binding.taxTxt1.setText("$" + tax);
        binding.deliveryTxt1.setText("$" + delivery);
        binding.totalTxt1.setText("$" + total);
    }
}