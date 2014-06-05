package com.example.sgdriverdiary;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Search extends ActionBarActivity {
	private Spinner spinner1, spinner2;
	private Button btnSearch;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_search);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		btnSearch = (Button) findViewById(R.id.btnSearch);
		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		spinner2.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	
	}
	public void ButtonClickHandler(View v)
	{
	
		if (spinner1.getSelectedItem().toString().equals("Caltec") && spinner2.getSelectedItem().toString().equals("North")){
			Intent intent = new Intent(this, Record.class);
			startActivity(intent);	
		}
				
			
				
	}
		
	
	

}
