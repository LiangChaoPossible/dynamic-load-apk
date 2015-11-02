package com.component.hotel.invoker;

import com.component.hotel.invoker.api.InvokerCallBack;
import com.component.hotel.invoker.api.InvokerInitCallBack;
import com.component.hotel.invoker.api.InvokerWrapper;

import android.content.Context;

/**
 * 调起方的调起入口�?
 * @author liangchao04
 *
 */
public class SDKInvoker {
	
	public static void invoke(Context context , String target , String param , InvokerCallBack callBack){
		InvokerWrapper.getInstance().invoke(context, target, param, callBack);
	}
	
	/**
	 * 同步初始�?
	 * @param context
	 */
	public static void init(Context context){
		InvokerWrapper.getInstance().init(context);
	}
	
	/**
	 * 异步初始�?
	 * @param context
	 */
	public static void initAsyncly(Context context , InvokerInitCallBack callBack){
		InvokerWrapper.getInstance().initAsyncly(context,callBack);
	}

	
	
}
