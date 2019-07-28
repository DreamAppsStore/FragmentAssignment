package com.example.fragmentassignment;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper {
	
	SQLiteDatabase db;
	
	private static final String DB_name="MYDATABASE";
	private static final int DB_version=1;
	
	

	public MyDataBase(Context context) {
		super(context, DB_name, null, DB_version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		String queary;
		queary="CREATE TABLE STUDENT(NAME TEXT NOT NULL,ADDRESS TEXT,COURSE TEXT,BRANCH TEXT,COLLAGE TEXT)";
		db.execSQL(queary);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public void insertDataIntoDataBase(String s1,HashMap<String, RegistationDetail> objHashMap)
	{
		db=this.getWritableDatabase();
		ContentValues objContentValues=new ContentValues();
		RegistationDetail obj=objHashMap.get(s1);
		objContentValues.put("NAME", obj.name);
		objContentValues.put("ADDRESS", obj.address);
		objContentValues.put("COURSE", obj.course);
		objContentValues.put("BRANCH", obj.branch);
		objContentValues.put("COLLAGE", obj.collage);
		db.insert("STUDENT", null, objContentValues);
		db.close();
	}

	public ArrayList<String> getAllStudentFromDataBase() 
	{
		ArrayList<String> objArrayList1;
		objArrayList1=new ArrayList<String>();
		String quary1="SELECT * FROM STUDENT";
		db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(quary1, null);
		if(cursor.moveToFirst())
		{
			do {
				objArrayList1.add(cursor.getString(0));
			} while (cursor.moveToNext());
			
		}
		
		return objArrayList1;
	}

	public HashMap<String, RegistationDetail> getDataUsingName(String string)
	{
		HashMap<String, RegistationDetail> objHashMap1=new HashMap<String, RegistationDetail>();
		SQLiteDatabase db1=this.getReadableDatabase();
		String  query2="SELECT * FROM STUDENT WHERE NAME='"+string+"'";
		Cursor cursor=db1.rawQuery(query2, null);
		if(cursor.moveToFirst())
		{
			do {
				RegistationDetail r1=new RegistationDetail(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
				objHashMap1.put(cursor.getString(0), r1);
				
				
			} while (cursor.moveToNext());
			
		}
		
		
		return objHashMap1;
	}
	
	
	
}

