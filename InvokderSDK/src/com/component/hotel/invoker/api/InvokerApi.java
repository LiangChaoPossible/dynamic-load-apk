package com.component.hotel.invoker.api;


import android.content.Context;

/**
 * 调起接口
 * @author liangchao04
 */
public interface InvokerApi {
	
	/**
	 * 调起sdk的方�?
	 * @param context
	 * @param target 目标参数
	 * @param param 业务参数
	 * @param callBack 调起的回�?
	 */
	public void invoke(Context context , String target , String param , InvokerCallBack callBack );

	/**
	 * sdk初始化的，同步方法�?
	 * @param context
	 * @return
	 */
	public boolean init(Context context);
	
	/**
	 * sdk初始化的，异步方法�?
	 * @param context
	 * @return
	 */
	public void initAsyncly(Context context , InvokerInitCallBack callBack);
}
