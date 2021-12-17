package net.smallacademy.qrapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "QRdata.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table QRData(qrcode VARCHAR unique)");
        DB.execSQL("insert into QRData values('abc')");
        DB.execSQL("insert into QRData values('123')");
        DB.execSQL("insert into QRData values('0x8ca3288e2e736f39cfeb4480ef5a10cc98fa34982c6ce84b42cd1b199ee5aace')");
        DB.execSQL("insert into QRData values('0x5bd06c4170fba1ce32bbcfbf30e819ec6990898c2835334b8da415fec42e06ee')");
        DB.execSQL("insert into QRData values('0x5b725f4771dab2676481f79a3360f0f51ced1b45395e17b4fa5e13107f139dad')");
        DB.execSQL("insert into QRData values('0x468fd9a6ec0ad195706a102454ea305bc323d154bdf994085fa8c8f03803fa3b')");
        DB.execSQL("insert into QRData values('0x9521648f569abc1199ec06b746eca1ab7f47db67300bdee27cf61ddef905bec0')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists QRData");
        onCreate(DB);
    }

//    public Cursor checkData(String code)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select exists (select * from QRData where qrcode = " +code + ")"+ ")", null);
//        return cursor;
//    }

    public boolean checkData(String code) {
        SQLiteDatabase db = this.getWritableDatabase();
//        String Query = "Select * from " + "QRData" + " where " + "qrcode" + " = " + code;
//        Cursor cursor = db.rawQuery(Query, null);
        //Cursor cursor = db.rawQuery("select exists (select * from QRData where qrcode = " + "'"+ code +"'" +")", null);
        Cursor cursor = db.rawQuery("select * from QRData where qrcode = " + "'" +code+ "'" , null);
        if(cursor.getCount() == 0){
            Log.d("helpcount", "checkData: " + cursor.getCount());
            cursor.close();
            return false;
        }
        else{
            //Log.d("helpcount", "checkData: " + cursor.getCount());
            cursor.close();
            return true;
        }
    }

//    public boolean checkData(String code) {
//        SQLiteDatabase db = this.getReadableDatabase();
////        String Query = "Select * from " + "QRData" + " where " + "qrcode" + " = " + code;
////        Cursor cursor = db.rawQuery(Query, null);
//        Cursor cursor = db.rawQuery("select * from QRData where qrcode = " + "'" +code+ "'" , null);
//
//        if (cursor != null)
//        {
//            Log.d("helpcount", "checkData: " + cursor.getCount());
//            return true;
//            /* record exist */
//        }
//        else
//        {
//            //Log.d("helpcount1", "checkData: " + cursor.getCount());
//            return false;
//            /* record not exist */
//        }
//    }


}
