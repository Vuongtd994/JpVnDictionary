package com.vuongtd.models.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by vuongtd on 11/10/2015.
 */
public class DBHelpterjapanesevietnamese {

    Context context;
    SQLiteDatabase db;
    public DBHelpterjapanesevietnamese(Context context) {
        this.context = context;
        japanesevietnamese assetDB=new japanesevietnamese(context);
        db=assetDB.StoreDatabase();
    }

    //sql là câu lệnh sqlite
    //selectionArgs là các điều kiện
    private ArrayList<japanvietnameseEntity> getword(String sql, String...selectionArgs){

        ArrayList<japanvietnameseEntity> arr=new ArrayList<>();
      //đọc từng cột từ data
        //nếu còn sẽ đọc tiếp
        japanvietnameseEntity entity=new japanvietnameseEntity();
        sql=("SELECT * FROM japanesevietnamese WHERE word LIKE '%"+entity.getWord()+"%'");
        Cursor cur=db.rawQuery(sql,selectionArgs);

        while (cur.moveToNext()){
            //lấy ra giá trị nơi con chuột và add vào mảng
            entity=new japanvietnameseEntity();
            entity.setWord(cur.getString(1));
            entity.setContent(cur.getString(2));
            arr.add(entity);
        }
        cur.close();
        //trả về mảng
        return arr;
    }


    //phương thức trả về 1 list các word có kí tự giống tìm kiếm
    public ArrayList<japanvietnameseEntity> listword(){

        String sql="SELECT * FROM japanesevietnamese WHERE word=? LIKE ''";
        return getword(sql);
    }
}
