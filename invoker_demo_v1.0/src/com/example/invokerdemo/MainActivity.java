package com.example.invokerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.component.hotel.invoker.SDKInvoker;
import com.example.invokerdemo.R;

public class MainActivity extends Activity {
	
	private Button invokeBtn;
	private Button startAct2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
	}
	
	private void initView(){
		invokeBtn = (Button)findViewById(R.id.invoke_btn);
		startAct2 = (Button)findViewById(R.id.startActivity2);
		
		invokeBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				SDKInvoker.initAsyncly(MainActivity.this , null);

				SDKInvoker.invoke(MainActivity.this, "target", "param", null);
			}
		});
		
		startAct2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, MainActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
	}

}
