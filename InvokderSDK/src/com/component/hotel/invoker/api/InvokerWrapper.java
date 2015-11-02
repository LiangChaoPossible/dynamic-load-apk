package com.component.hotel.invoker.api;


public class InvokerWrapper {
	public static class Holder {
		public static final InvokerApi instance = new InvokerApiImpl();
	}
	
	public static InvokerApi getInstance(){
		return Holder.instance;
	}
}
