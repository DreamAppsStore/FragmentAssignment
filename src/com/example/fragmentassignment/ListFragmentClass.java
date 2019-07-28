package com.example.fragmentassignment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListFragmentClass extends ListFragment
{
	OnItemSelectAction onItemSelectAction;
	Context context;
	
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub

	return super.onCreateView(inflater, container, savedInstanceState);
}

@Override
public void onAttach(Activity activity) {
	// TODO Auto-generated method stub
	super.onAttach(activity);
	context=activity.getApplicationContext();
	
	if(activity instanceof OnItemSelectAction)
	{
		onItemSelectAction=(OnItemSelectAction)activity;
	}
	else 
	{
		throw new ClassCastException(activity.toString()+" ________-------________Exception");
	}
	
}


@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		onItemSelectAction.selectOnClick(position);

		
		
	}

public interface OnItemSelectAction
{
	public	void selectOnClick(int position);
}

}
