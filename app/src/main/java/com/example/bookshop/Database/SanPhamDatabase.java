package com.example.bookshop.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bookshop.DAO.SanPhamDao;
import com.example.bookshop.Model.SanPham;

@Database(entities = {SanPham.class},version = 1)
public abstract class SanPhamDatabase extends RoomDatabase {
    private static final  String DatabaseName = "sp.db";
    private static SanPhamDatabase ins;
    public static synchronized SanPhamDatabase getInstance(Context context){
        if(ins == null){
            ins = Room.databaseBuilder(context.getApplicationContext(),SanPhamDatabase.class,DatabaseName)
                    .allowMainThreadQueries()
                    .build();
        }
        return ins;
    }
    public abstract SanPhamDao sanPhamDao();

}
