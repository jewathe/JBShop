package learn.android.w14exampratiquejean.service;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ConnectionDB {
    private static int version = 1;
    private static String dbName = "exambdandroid.db";
    private static SQLiteDatabase bd = null;
    private static ExamBDHelper helper;

    public static SQLiteDatabase getBd(Context context){
        if(helper == null){
            helper = new ExamBDHelper(context, dbName, null, version);
        }
        bd = helper.getWritableDatabase();
        return bd;
    }
    public static void close(){
        if(bd!= null &&  !bd.isOpen()){
            bd.close();
        }
    }
    public static void cpyDataBaseFromAsset(Context context){
        File file =context.getDatabasePath(dbName);
        if(!file.exists()){
            try {
                InputStream in = context.getAssets().open("bd/"+dbName);
                OutputStream outputStream = new FileOutputStream(file);
                byte[] buffer = new byte[256];
                while (in.read(buffer)!= -1){
                    outputStream.write(buffer);
                    buffer = new byte[256];
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
