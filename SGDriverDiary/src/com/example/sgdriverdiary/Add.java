package com.example.sgdriverdiary;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends ActionBarActivity {
	private EditText editText1, editText2, editText3, editText4, editText5;
	private Button cancel, save;
	private ArrayList<Mile> miles;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		editText1 = (EditText) findViewById(R.id.editText10);
		editText2 = (EditText) findViewById(R.id.editText11);
		editText3 = (EditText) findViewById(R.id.editText12);
		editText4 = (EditText) findViewById(R.id.editText13);
		editText5 = (EditText) findViewById(R.id.editText14);
		save = (Button) findViewById(R.id.button1);
		cancel = (Button) findViewById(R.id.button2);
		miles = new ArrayList<Mile>();
	}

	

	
	public void cancel(View v)
	{
		finish();
	}
	public void save(View v) {
	
		
			// Get the values provided by the user via the UI
			String date = editText1.getText().toString();
			Double mile = Double.parseDouble(editText2.getText().toString());
			String kiosk = editText3.getText().toString();
			String petrol = editText4.getText().toString();
			Double rate = Double.parseDouble(editText5.getText().toString());
			

			// Pass above values to the setter methods in POJO class
			Mile Miles = new Mile();
			Miles.setDate(date);
			Miles.setMile(mile);
			Miles.setKiosk(kiosk);
			Miles.setPetrol(petrol);
			Miles.setRate(rate);

			// Add an undergraduate with his all details to a ArrayList
			miles.add(Miles);

			// Inserting undergraduate details to the database is doing in a separate method
			insertMile(Miles);

			// Release from the existing UI and go back to the previous UI
			finish();
		}
	

	public void insertMile(Mile paraUndergraduateDetailsPojoObj){

		// First we have to open our DbHelper class by creating a new object of that
		MySQLiteHelper androidOpenDbHelperObj = new MySQLiteHelper(this);

		// Then we need to get a writable SQLite database, because we are going to insert some values
		// SQLiteDatabase has methods to create, delete, execute SQL commands, and perform other common database management tasks.
		SQLiteDatabase sqliteDatabase = androidOpenDbHelperObj.getWritableDatabase();

		// ContentValues class is used to store a set of values that the ContentResolver can process. 
		ContentValues contentValues = new ContentValues();

		// Get values from the POJO class and passing them to the ContentValues class
		contentValues.put(MySQLiteHelper.COLUMN_NAME_DATE, paraUndergraduateDetailsPojoObj.getDate());
		contentValues.put(MySQLiteHelper.COLUMN_NAME_MILE_TRAVELLED, paraUndergraduateDetailsPojoObj.getMile());
		contentValues.put(MySQLiteHelper.COLUMN_NAME_KIOSK_COMPANY, paraUndergraduateDetailsPojoObj.getKiosk());
		contentValues.put(MySQLiteHelper.COLLUMN_NAME_PETROL_TYPE, paraUndergraduateDetailsPojoObj.getPetrol());
		contentValues.put(MySQLiteHelper.COLUMN_NAME_RATE, paraUndergraduateDetailsPojoObj.getRate());
		// Now we can insert the data in to relevant table
		// I am going pass the id value, which is going to change because of our insert method, to a long variable to show in Toast
		long affectedColumnId = sqliteDatabase.insert(MySQLiteHelper.TABLE_NAME_Mile, null, contentValues);

		// It is a good practice to close the database connections after you have done with it
		sqliteDatabase.close();

		// I am not going to do the retrieve part in this post. So this is just a notification for satisfaction ;-)
		Toast.makeText(this, "Values inserted column ID is :" + affectedColumnId, Toast.LENGTH_SHORT).show();
}
	}
