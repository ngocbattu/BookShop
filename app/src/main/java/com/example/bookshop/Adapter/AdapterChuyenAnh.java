package com.example.bookshop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.bookshop.Model.AnhQuangCao;
import com.example.bookshop.R;

import java.util.List;

public class AdapterChuyenAnh extends PagerAdapter {
    private Context context;
    private List<AnhQuangCao> list;

    public AdapterChuyenAnh(Context context, List<AnhQuangCao> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size ();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from (container.getContext ()).inflate (R.layout.iten_chuyen_anh,container,false);
        ImageView imageView = view.findViewById (R.id.image_anh_chuyen);

        AnhQuangCao quangCao = list.get (position);
        Glide.with (context).load (quangCao.getImage_anh()).into (imageView);

        container.addView (view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView ((View) object);

    }
}
