package com.component.hotel.invoker.api;

/**
 * 调起的回调�?
 * @author liangchao04
 */
public interface InvokerCallBack {
	public void onSuccess();
	public void onFail(int errorCode);
}
