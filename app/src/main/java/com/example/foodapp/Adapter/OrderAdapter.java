package com.example.foodapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodapp.Activity.OrderActivity;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.ChangeNumberItemsListener;
import com.example.foodapp.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewholder>{
    ArrayList<Foods> list;
    private OrderActivity managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public OrderAdapter(ArrayList<Foods> list, OrderActivity managmentCart, ChangeNumberItemsListener changeNumberItemsListener) {
        this.list = list;
        this.managmentCart = managmentCart;
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public OrderAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_order,parent,false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.viewholder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.totalEachItem.setText(list.get(position).getNumberInCart() + " * $" + (list.get(position).getPrice()));
        holder.num.setText(list.get(position).getNumberInCart() + "");
        holder.feeEachItem.setText("$" + String.format("%.2f", list.get(position).getPrice() * list.get(position).getNumberInCart()));

        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem;
        ImageView pic;
        TextView totalEachItem, num;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt1);
            feeEachItem = itemView.findViewById(R.id.feeEachItem1);
            totalEachItem = itemView.findViewById(R.id.totalEachItem1);
            num = itemView.findViewById(R.id.numberItemTxt1);
            pic = itemView.findViewById(R.id.pic1);
        }
    }
}
