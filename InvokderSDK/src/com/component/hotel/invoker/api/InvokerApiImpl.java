package com.component.hotel.invoker.api;

import java.lang.ref.SoftReference;

import com.ryg.dynamicload.internal.DLIntent;
import com.ryg.dynamicload.internal.DLPluginInfo;
import com.ryg.dynamicload.internal.DLPluginManager;

import android.content.Context;
import android.os.AsyncTask;

class InvokerApiImpl implements InvokerApi{

	/** 指向被load起来的酒店apk */
	private SoftReference<DLPluginInfo> mDestLoadedApk = null;
	
	@Override
	public void invoke(Context context, String target, String param,
			InvokerCallBack callBack) {
		
		if(mDestLoadedApk==null || mDestLoadedApk.get()==null){
			boolean initRes = init(context);
			
			if(!initRes){
				if(callBack!=null){
					callBack.onFail(Constant.ERROR_CODE_INIT_ERROR);
				}
				return;
			}
		}
		
		DLPluginInfo destHotelApk = mDestLoadedApk.get();
		
		DLPluginManager.getInstance(context).startPluginActivity(
				context,
				new DLIntent(destHotelApk.packageInfo.packageName,
						destHotelApk.defaultActivity));
		
		if(callBack!=null){
			callBack.onSuccess();
		}
	}

	/**
	 * 同步初始�?
	 */
	@Override
	public boolean init(Context context) {
		if(context == null){
			return false;
		}
		
		int verifyRes = HotelPluginVerifyUtil.getInstance().isVerified(context);
		
		if(Constant.APK_VERIFY_SUCCESS != verifyRes){
			return false;
		}	
		
		DLPluginInfo destPack = DLPluginManager.getInstance(context)
				.loadApk(
						HotelPluginVerifyUtil.getInstance()
								.getDestHotelApkPath(context));
		
		if(destPack==null || destPack.assetManager==null){
			return false;
		}
		
		mDestLoadedApk = new SoftReference<DLPluginInfo>(destPack);
		
		return true;
	}
	
	/**
	 * 异步初始�?
	 * @param context
	 * @param callBack
	 */
	public void initAsyncly(Context context , InvokerInitCallBack callBack){
		new InitAsyncTask(context, callBack).execute();
	}
	
	private class InitAsyncTask extends AsyncTask<Void, Integer, Boolean>{

		public InitAsyncTask(Context context , InvokerInitCallBack callBack){
			mContext = context;
			mCallBack = callBack;
		}
		
		private Context mContext;
		private InvokerInitCallBack mCallBack;
		
		@Override
		protected Boolean doInBackground(Void... arg0) {
			return init(mContext);
		}

		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			
			if(result && mCallBack!=null){
				mCallBack.onSuccess();
			} else if(!result && mCallBack!=null){
				mCallBack.onFail(Constant.ERROR_CODE_INIT_ERROR);
			}
		}
		
		
	}
}
