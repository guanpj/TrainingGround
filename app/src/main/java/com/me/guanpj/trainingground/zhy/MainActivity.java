package com.me.guanpj.trainingground.zhy;

import android.app.Activity;
import android.os.Bundle;

import com.me.guanpj.trainingground.R;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity
{

	private List<String> mDatas = Arrays.asList("Android", "Java");

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhy);
		
		// setContentView(R.layout.activity_main);
//		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main,
//				R.id.id_txt, mDatas));

	}

}
