package com.component.hotel.invoker.api;

import java.io.File;

import android.content.Context;
import android.os.Environment;

/**
 * @author liangchao04
 *
 */
public class HotelPluginVerifyUtil {
	private static class Holder{
		public static HotelPluginVerifyUtil instance = new  HotelPluginVerifyUtil();
	}
	
	public static HotelPluginVerifyUtil getInstance(){
		return Holder.instance;
	}
	
	/**
	 * @param context
	 * @return
	 */
	public int isVerified(Context context){
		if(!isExist(context)){
			return Constant.ERROR_CODE_SDK_NOT_EXIST;
		}
		
		return Constant.APK_VERIFY_SUCCESS;
	}
	
	
	/**
	 * @param context
	 * @return
	 */
	public boolean isExist(Context context){
		if(context==null){
			return false;
		}
		
        String destFilePath = getDestHotelApkPath(context);
        File destFile = new File(destFilePath);
        
        return destFile!=null && destFile.exists();
	}
	
	/**
	 * TODO:添加版本控制，返回版本号�?��的apk
	 * @param context
	 * @return
	 */
	public String getDestHotelApkPath(Context context){
		
		if(context==null){
			return "";
		}
		
		if(Constant.isDebug){
			return Environment.getExternalStorageDirectory()+"/hotelsdk/"+Constant.APK_FILE_NAME;
		} else {
			return context.getFilesDir().getAbsolutePath()+"/hotelsdk/"+Constant.APK_FILE_NAME;
		}
	}
}
