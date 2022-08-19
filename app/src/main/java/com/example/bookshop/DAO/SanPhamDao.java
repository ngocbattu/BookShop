package com.example.bookshop.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.bookshop.Model.SanPham;

import java.util.List;

@Dao
public interface SanPhamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsetSanPham(SanPham sanPham);

    @Query("select * from SanPham")
    List<SanPham> getSanPham();
}
