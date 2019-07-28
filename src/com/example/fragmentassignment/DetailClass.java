package com.example.fragmentassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

public class DetailClass extends ActionBarActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.detailfragment);
		
		Intent intent=getIntent();
		String s1=intent.getStringExtra("n2");
		
		FragmentManager objFragmentManager=getSupportFragmentManager();
		DetailFragmentClass objDetailFragmentClass=(DetailFragmentClass)objFragmentManager.findFragmentById(R.id.detailTextView);
		objDetailFragmentClass.setTextMethod(s1);
		
	}

}
