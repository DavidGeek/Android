package com.example.sgdriverdiary;


import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends Activity{

	private EditText editText1, editText2, editText3, editText4, editText5;
	private Button cancel, delete, update;
	private String bundleMile, bundleKiosk, bundlepetrol, bundlerate,bundledate;
	private Double bundlerateDouble, bundleMileDouble;
	private String kiosktext, petroltext, datetext;
	private Double miletext,ratetext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);

		editText1 = (EditText) findViewById(R.id.editText10);
		editText2 = (EditText) findViewById(R.id.editText11);
		editText3 = (EditText) findViewById(R.id.editText12);
		editText4 = (EditText) findViewById(R.id.editText13);
		editText5 = (EditText) findViewById(R.id.editText14);
		delete = (Button) findViewById(R.id.button1);
		cancel = (Button) findViewById(R.id.button2);
		update = (Button) findViewById(R.id.button3);

		

		Bundle takeBundledData = getIntent().getExtras();

		// First we need to get the bundle data that pass from the UndergraduateListActivity
		bundledate = takeBundledData.getString("clickedDate");
		bundleKiosk = takeBundledData.getString("clickedKiosk");
		bundlepetrol = takeBundledData.getString("clickedPetrol");
		// setText method ask for a String value
		//But getDouble method returns a Double value
		bundleMileDouble = takeBundledData.getDouble("clickedMile");
		bundleMileDouble = takeBundledData.getDouble("clickedRate");
		//So we need to convert that Double value to String value
		bundleMile = Double.toString(bundleMileDouble);
		bundlerate = Double.toString(bundleMileDouble);
		// Set the values that we extracted from the Bundle in the EditText fields
		editText1.setText(bundledate);
		editText2.setText(bundleMile);
		editText3.setText(bundleKiosk);
		editText4.setText(bundlepetrol);
		editText5.setText(bundlerate);
	
	}
		public void delete(View v)
		{

		// We need to update or delete details which is in the EditText fields after user edit the values		
		// These values are the ContentValues that we are going to use in future
		datetext = editText1.getText().toString();
		kiosktext = editText3.getText().toString();
		petroltext = editText3.getText().toString();

		String mileStr = editText2.getText().toString();
		miletext = Double.valueOf(mileStr);
		
		String ratestr = editText5.getText().toString();
		ratetext = Double.valueOf(ratestr);

		// It is easy to set values to the POJO class and pass the class instance to the updateUgraduateDetails() method
		Mile miles = new Mile();

		miles.setDate(datetext);
		miles.setKiosk(kiosktext);
		miles.setPetrol(petroltext);

		// POJO class ask for a double value for the GPA
		//So we have to convert the EditText value to Double value
		Double mileDouble = Double.parseDouble(bundleMile);
		miles.setMile(mileDouble);
		
		Double rateDouble = Double.parseDouble(bundlerate);
		miles.setRate(rateDouble);
		
	    deleteUgraduateDetails(miles);
	}
		public void cancel(View v)
		{
			finish();
		}
	
	


	

	private void deleteUgraduateDetails(Mile deleteUndergraduateDetailsPojo) {

		MySQLiteHelper androidOpenDbHelper = new MySQLiteHelper(this);
		SQLiteDatabase sqliteDatabase = androidOpenDbHelper.getWritableDatabase();

		String[] whereClauseArgument = new String[1];
		whereClauseArgument[0] = deleteUndergraduateDetailsPojo.getDate();

		// Only difference between UPDATE and DELETE is
		//DELETE does not have ContentValues part
		sqliteDatabase.delete(MySQLiteHelper.TABLE_NAME_Mile, MySQLiteHelper.COLUMN_NAME_DATE+"=?", whereClauseArgument);

		sqliteDatabase.close();
		finish();
	}
}