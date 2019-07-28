package com.example.fragmentassignment;



import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DialogFragmentClass extends DialogFragment
{
	MyDataBase objMyDataBase;
	EditText edname,edaddress,edcourse,edbranch,edcollage;
	Button button_clean,button_cancel,button_ok;
	String s1,s2,s3,s4,s5;
	
	AddToDataBase add;
	
	Context context;
	
	HashMap<String,RegistationDetail> objHashMap;

	FragmentManager objFragmentManager;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		context=activity.getApplicationContext();
		objMyDataBase=new MyDataBase(activity.getApplicationContext());
		
		if(activity instanceof AddToDataBase)
		{
			add=(AddToDataBase)activity;
		}
		else
		{
			throw new ClassCastException("AddToDataBase ->>>> add  not created");
		}
		
	}
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		objHashMap=new HashMap<String,RegistationDetail>();
		
		View view=inflater.inflate(R.layout.dialog_fragment, container, false);
		
		edname=(EditText)view.findViewById(R.id.name);
		edaddress=(EditText)view.findViewById(R.id.address);
		edcourse=(EditText)view.findViewById(R.id.course);
		edbranch=(EditText)view.findViewById(R.id.branch);
		edcollage=(EditText)view.findViewById(R.id.collage);
		
		button_ok=(Button)view.findViewById(R.id.ok);
		button_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				s1=edname.getText().toString();
				s2= edaddress.getText().toString();
				s3=edcourse.getText().toString();
				s4=edbranch.getText().toString();
				s5=edcollage.getText().toString();
				
				RegistationDetail r1=new RegistationDetail(s1,s2,s3,s4,s5);
				objHashMap.put(s1, r1);
				
				objMyDataBase.insertDataIntoDataBase(s1,objHashMap);
				
				add.addMethod(s1);
				
				dismiss();
				
			}
		});

		button_cancel=(Button)view.findViewById(R.id.cancel);
		button_cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		

		button_clean=(Button)view.findViewById(R.id.clean);
		button_clean.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				edname.getText().clear();
				edaddress.getText().clear();
				edcourse.getText().clear();
				edbranch.getText().clear();
				edcollage.getText().clear();
			}
		});
		
		
		return view;
	}
	
	public interface  AddToDataBase
	{
		public void addMethod(String n);
		
	}
	
}
