package com.example.invokerdemo;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	private static final boolean isToastShown = true;
	
	public static void showToast(Context context , String msg){
		if(!isToastShown){
			return;
		}
		
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
}
