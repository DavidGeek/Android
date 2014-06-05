package com.example.sgdriverdiary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

// A helper class to manage database creation and version management. 
public class MySQLiteHelper extends SQLiteOpenHelper {
	// Database attributes
	public static final String DB_NAME = "Mileage_Record_db";
	public static final int DB_VERSION = 1;

	// Table attributes
	public static final String TABLE_NAME_Mile = "Mileage_details_table";
	public static final String COLUMN_NAME_DATE = "date_column";
	public static final String COLUMN_NAME_MILE_TRAVELLED = "mile_travelled_column";
	public static final String COLUMN_NAME_KIOSK_COMPANY = "kiosk_company_column";
	public static final String COLLUMN_NAME_PETROL_TYPE= "petrol_type_column";
	public static final String COLUMN_NAME_RATE = "rate_column";

	public MySQLiteHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	// Called when the database is created for the first time. 
	//This is where the creation of tables and the initial population of the tables should happen.
	@Override
	public void onCreate(SQLiteDatabase db) {
		// We need to check whether table that we are going to create is already exists.
		//Because this method get executed every time we created an object of this class. 
		//"create table if not exists TABLE_NAME ( BaseColumns._ID integer primary key autoincrement, FIRST_COLUMN_NAME text not null, SECOND_COLUMN_NAME integer not null);"
		String sqlQueryToCreateUndergraduateDetailsTable = "create table if not exists " + TABLE_NAME_Mile + " ( " + BaseColumns._ID + " integer primary key autoincrement, "
																+ COLUMN_NAME_DATE + "text not null, "
																+ COLUMN_NAME_MILE_TRAVELLED + " real not null, "
																+ COLUMN_NAME_KIOSK_COMPANY + " text not null, "
																+ COLLUMN_NAME_PETROL_TYPE + "text not null , "
																+ COLUMN_NAME_RATE + " real not null);";
		// Execute a single SQL statement that is NOT a SELECT or any other SQL statement that returns data.
		db.execSQL(sqlQueryToCreateUndergraduateDetailsTable);
	}

	// onUpgrade method is use when we need to upgrade the database in to a new version
	//As an example, the first release of the app contains DB_VERSION = 1
	//Then with the second release of the same app contains DB_VERSION = 2
	//where you may have add some new tables or alter the existing ones
	//Then we need check and do relevant action to keep our pass data and move with the next structure
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if(oldVersion == 1 && newVersion == 2){
			// Upgrade the database
		}		
	}
}