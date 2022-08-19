package com.example.bookshop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookshop.Model.SanPham;
import com.example.bookshop.R;

import java.util.List;

public class AdapterSanPham extends RecyclerView.Adapter<AdapterSanPham.ViewHodelSanPham>{
    private Context context;
    private List<SanPham> list;

    public AdapterSanPham(Context context, List<SanPham> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodelSanPham onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recy_san_pham,null);
        return new ViewHodelSanPham(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodelSanPham holder, int position) {
        SanPham sanPham = list.get(position);
        Glide.with(context).load(sanPham.getAnhSP()).into(holder.imageView);
        holder.txt_ten_sp.setText(sanPham.getTenSP());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHodelSanPham extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt_ten_sp;
        public ViewHodelSanPham(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_sp_trang_chu);
            txt_ten_sp = itemView.findViewById(R.id.txt_ten_sp_trang_chu);
        }
    }
}
