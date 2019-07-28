package com.example.fragmentassignment;


import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFragmentClass extends Fragment
{
	View view;
	
	MyDataBase objMyDataBase;
	HashMap<String, RegistationDetail> objHashMap;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view=inflater.inflate(R.layout.displaytextview, container, false);
		objMyDataBase=new MyDataBase(getActivity().getApplicationContext());
		return view;
	}

	
	public void setTextMethod(String string) 
	{
		RegistationDetail obj;
		
		TextView tv1=(TextView)view.findViewById(R.id.textname);
		TextView tv2=(TextView)view.findViewById(R.id.textaddress);
		TextView tv3=(TextView)view.findViewById(R.id.textcourse);
		TextView tv4=(TextView)view.findViewById(R.id.textbranch);
		TextView tv5=(TextView)view.findViewById(R.id.textcollage);
		
		objHashMap=objMyDataBase.getDataUsingName(string);
		
		obj=objHashMap.get(string);
		
		tv1.setText(obj.name);
		tv2.setText(obj.address);
		tv3.setText(obj.course);
		tv4.setText(obj.branch);
		tv5.setText(obj.collage);
		
	}

}
