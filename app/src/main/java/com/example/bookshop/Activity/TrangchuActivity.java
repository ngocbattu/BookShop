package com.example.bookshop.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;

import com.example.bookshop.Adapter.AdapterChuyenAnh;
import com.example.bookshop.Adapter.AdapterSanPham;
import com.example.bookshop.Database.SanPhamDatabase;
import com.example.bookshop.Fragment.GioHangFragment;
import com.example.bookshop.Fragment.HoaDonFragment;
import com.example.bookshop.Fragment.SanPhamFragment;
import com.example.bookshop.Fragment.TrangChuFragment;
import com.example.bookshop.Model.AnhQuangCao;
import com.example.bookshop.Model.SanPham;
import com.example.bookshop.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TrangchuActivity extends AppCompatActivity {
    Toolbar toolbar;

    NavigationView navigationView;
    DrawerLayout mDrawerLayout;
    FragmentManager fragmentManager;
    SanPhamFragment sanPhamFragment;
    GioHangFragment gioHangFragment;
    HoaDonFragment hoaDonFragment;
    TrangChuFragment trangChuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        toolbar = findViewById(R.id.toolbar_trang_chu);

        navigationView = findViewById(R.id.navigation_view);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(navigationView);
            }
        });


        NaVi();

    }


    public void NaVi(){
        fragmentManager = getSupportFragmentManager();
        sanPhamFragment = new SanPhamFragment();
        gioHangFragment = new GioHangFragment();
        hoaDonFragment = new HoaDonFragment();
        trangChuFragment = new TrangChuFragment();
        fragmentManager.beginTransaction().add(R.id.fragmnet_contenview,trangChuFragment).commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){
                        case R.id.item_trang_chu:
                            fragmentManager.beginTransaction().replace(R.id.fragmnet_contenview,trangChuFragment).commit();
                            break;
                        case R.id.item_sanpham:

                            fragmentManager.beginTransaction().replace(R.id.fragmnet_contenview,sanPhamFragment).commit();
                            break;
                        case R.id.item_gio_hang:

                            fragmentManager.beginTransaction().replace(R.id.fragmnet_contenview,gioHangFragment).commit();
                            break;
                        case R.id.item_hoa_don:

                            fragmentManager.beginTransaction().replace(R.id.fragmnet_contenview,hoaDonFragment).commit();
                            break;
                        case R.id.item_dang_xuat:
                            startActivity(new Intent(TrangchuActivity.this,LoginActivity.class));
                            break;
                    }
                mDrawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}