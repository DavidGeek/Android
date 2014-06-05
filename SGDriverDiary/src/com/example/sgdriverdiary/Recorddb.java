package com.example.sgdriverdiary;

import java.util.List;


import android.app.Activity;
import android.os.Bundle;

public class Recorddb extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_recorddb);


		MySQLiteHelper db = new MySQLiteHelper(this);
        
        /**
         * CRUD Operations
         * */
        // add Books
        //db.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));   
       // db.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));       
       // db.addBook(new Book("Learn Android App Development", "Wallace Jackson"));
        
        // get all books
       // List<Mile> list = db.getAllMile();
        
        // delete one book
        //db.deleteMile(list.get(0));
        
        // get all books
        //db.getAllMile();

        
	}

}