package com.example.sgdriverdiary;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {
	//Button button2, button3, button4, button1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cal);
		 //button2 = (Button) findViewById(R.id.button2);
		 //button3 = (Button) findViewById(R.id.button3);
		 //button4 = (Button) findViewById(R.id.button4);
		 //button1 = (Button) findViewById(R.id.button1);
		 //button2.setOnClickListener((OnClickListener) this);
		 //button3.setOnClickListener(this);
		 //button4.setOnClickListener(this);
		 //button1.setOnClickListener(this);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
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
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	public void cal (View v){
		Intent intent = new Intent(this, Cal.class);
		startActivity(intent);
	}
	public void rate (View v){
		Intent intent = new Intent(this, Rate.class);
		startActivity(intent);
	}
	public void search (View v){
		Intent intent = new Intent(this, Search.class);
		startActivity(intent);
	}
	public void record (View v){
		Intent intent = new Intent(this, Record.class);
		startActivity(intent);
	}
	/*public void onClick(View v){
		Intent intent = new Intent();
		
		if(v == button3)
			intent.setClass(this, Cal.class);
		else if(v == button1)
			intent.setClass(this, Rate.class);
		else if(v == button4)
			intent.setClass(this, Search.class);
		else if(v== button2)
			intent.setClass(this, Record.class);
		else
			return;
		startActivity(intent);
	}*/
	
}

