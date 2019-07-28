package com.example.fragmentassignment;


import java.util.ArrayList;

import com.example.fragmentassignment.DialogFragmentClass.AddToDataBase;
import com.example.fragmentassignment.ListFragmentClass.OnItemSelectAction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AddToDataBase , OnItemSelectAction{

	ImageButton button_add;
	
	MyDataBase objMyDataBase;

	ArrayList<String> objArrayList;
	ArrayAdapter< String> objArrayAdapter;
	
	FragmentManager objFragmentManager;
	
	
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  
		objMyDataBase=new MyDataBase(this);
		
		objArrayList=objMyDataBase.getAllStudentFromDataBase();
		objArrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, objArrayList);
		
		objFragmentManager=getSupportFragmentManager();
		ListFragmentClass objListFragmentClass=(ListFragmentClass)objFragmentManager.findFragmentById(R.id.list_id);
		objListFragmentClass.setListAdapter(objArrayAdapter);		
        
        button_add=(ImageButton)findViewById(R.id.addtolist);
        button_add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				DialogFragment objDialogFragment=new DialogFragmentClass();
				objDialogFragment.show(getSupportFragmentManager(), "Dialog Fragment");
			}
		});
        
    }
    
    
    public void addMethod(String n)
    {
//    	objArrayList=objMyDataBase.getAllStudentFromDataBase();
    	objArrayList.add(n);
    	objArrayAdapter.notifyDataSetChanged();
    	
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        
        if(id == R.id.add_on_click)
        {
        	DialogFragment objDialogFragment=new DialogFragmentClass();
        	objDialogFragment.show(getSupportFragmentManager(), "Dialog Fragment");
        }
        
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void selectOnClick(int position) {
		
	Toast.makeText(this,objArrayList.get(position).toString()+" Item Selected At Position  "+position, Toast.LENGTH_SHORT).show();
		
		if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE)
		{
			DetailFragmentClass objDetailFragmentClass=(DetailFragmentClass)objFragmentManager.findFragmentById(R.id.detailTextView);

			objDetailFragmentClass.setTextMethod(objArrayList.get(position).toString()); 
			
		}
		if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT)
		{
			Intent intent3=new Intent(this,DetailClass.class);
			intent3.putExtra("n2", objArrayList.get(position).toString());
			startActivity(intent3);
			
		}
		
	}    
    
    


}
