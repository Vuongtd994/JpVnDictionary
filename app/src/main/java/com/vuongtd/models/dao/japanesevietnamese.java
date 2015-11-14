package com.vuongtd.models.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;

/**
 * Created by vuongtd on 11/10/2015.
 */
public class japanesevietnamese {



    public static final String DB_NAME="japanese_vietnamese.db";

    private Context mcontext;

    public static final Integer VERSION=1;

    public japanesevietnamese(Context context){
        this.mcontext=context;
    }

    public SQLiteDatabase StoreDatabase(){
        //đường dẫn lưu data
        String path="/data/data/com.vuongtd.models.dao/databases";
        //tạo file
        File pathdb=new File(path);
        try {
            //kiểm tra nếu có thư mục database thì tạo
            if (!pathdb.exists()){
                pathdb.mkdirs();
            }

            // kiểm tra file đó chưa tồn tại thì copy vào
            // điều kiện này tránh trường hợp mỗi lần mở ứng dụng sẽ copy vào.
            if (!new File(path + "/" + DB_NAME).exists()) {
                copyDatabase(path);
            }

        }catch (IOException ex){
            Log.i("IOException",ex.getMessage());
        }
        Log.i("DB",mcontext.getDatabasePath(DB_NAME).getPath());
        return SQLiteDatabase.openDatabase(mcontext.getDatabasePath(DB_NAME).getPath(),null,SQLiteDatabase.OPEN_READONLY);

    }



    public void copyDatabase(String path) throws IOException {

        //load database từ assets
        InputStream inputStream=mcontext.getAssets().open(DB_NAME);

        //tạo 1 output stream kiểu file
        OutputStream outputStream=new FileOutputStream(path + "/" + DB_NAME);

        //chuyển các ký tự từ input sang output
        byte[] buffer=new byte[1024];
        int lenght;
        //đọc và ghi vào thư mục databases sau khi copy ra
        while ((lenght= inputStream.read(buffer))>0){
            outputStream.write(buffer,0,lenght);

        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();


    }
}
