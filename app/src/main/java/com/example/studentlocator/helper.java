package com.example.studentlocator;

import android.content.Context;
import android.graphics.Color;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class helper {
    private static SweetAlertDialog pDialog;

    public static void showSweetDialog(Context context , int PROGRESS_TYPE , String color ,
                                       String title, Boolean canceble){
        pDialog = new SweetAlertDialog(context,PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor(color));
        pDialog.setTitleText(title);
        pDialog.setCancelable(canceble);
        pDialog.show();
    }

    public static void closeDialog (){

        pDialog.cancel();
    }
}
