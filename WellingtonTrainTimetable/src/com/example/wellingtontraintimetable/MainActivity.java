package com.example.wellingtontraintimetable;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {
	protected static final String EXTRA_RESOURCE = null;
	private Button button;
	private String sMode;
	private String sRoute;
	private String sDirection;
	private List<String> bookmarks;
	private ArrayAdapter<String> bookmarksAdapter;

	//spinner array
	Spinner spm,spr,spd,bookmarksSpinner;
	ArrayAdapter<String> adapter;
	String mode[] = {"---","bus","school","train","other"};
	String route[] = {"---","HVL","JVL","KPL","MEL","NEX","PNL","WRL"};
	String direction[] = {"---","inbound","outbound"};
	String bookmark1[] = {};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final Context context = this;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//bookmark
		bookmarksSpinner = (Spinner) findViewById(R.id.bookmark_spinner);
		bookmarks = new ArrayList<String>();
		bookmarksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bookmarks);

		//get mode value
		spm = (Spinner)findViewById(R.id.mode_spinner);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mode);
		spm.setAdapter(adapter);
		spm.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3){
				Toast.makeText(getBaseContext(), spm.getSelectedItem().toString(),
				Toast.LENGTH_LONG).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		//get route value
		spr = (Spinner)findViewById(R.id.route_spinner);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, route);
		spr.setAdapter(adapter);
		spr.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3){
				Toast.makeText(getBaseContext(), spr.getSelectedItem().toString(),
				Toast.LENGTH_LONG).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		//get direction value
		spd = (Spinner)findViewById(R.id.direction_spinner);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, direction);
		spd.setAdapter(adapter);
		spd.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3){
				Toast.makeText(getBaseContext(), spd.getSelectedItem().toString(),
				Toast.LENGTH_LONG).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		button = (Button) findViewById(R.id.buttonUrl);
		button.setOnClickListener(new OnClickListener() {
		  public void onClick(View arg0) {
		    Intent intent = new Intent(context, WebViewActivity.class);
		    sMode = String.valueOf(spm.getSelectedItem());
			sRoute = String.valueOf(spr.getSelectedItem());
			sDirection = String.valueOf(spd.getSelectedItem());
			String resource[] = {sMode, sRoute, sDirection};
			intent.putExtra(EXTRA_RESOURCE, resource);
			startActivity(intent);
		  }
		});


		button = (Button) findViewById(R.id.add_bookmark);
		button.setOnClickListener(new OnClickListener() {
			  public void onClick(View arg0) {
				  	sMode = String.valueOf(spm.getSelectedItem());
					sRoute = String.valueOf(spr.getSelectedItem());
					sDirection = String.valueOf(spd.getSelectedItem());
					String bookmark = sMode + "/" + sRoute + "/" + sDirection;
					if(!bookmarks.contains(bookmark)) {
						bookmarks.add(bookmark);
					}
					//bookmarksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bookmarks);
					bookmarksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
					bookmarksSpinner.setAdapter(bookmarksAdapter);
			  }
		});

		button = (Button) findViewById(R.id.show_bookmark);
		button.setOnClickListener(new OnClickListener() {
		  public void onClick(View arg0) {
			  	Intent intent = new Intent(context, WebViewActivity.class);
			  	String bookmark = String.valueOf(bookmarksSpinner.getSelectedItem());
			    String resource[] = bookmark.split("/");
			    intent.putExtra(EXTRA_RESOURCE, resource);
			    startActivity(intent);
		  }

		});

		button = (Button) findViewById(R.id.delete_bookmark);
		button.setOnClickListener(new OnClickListener() {
		  public void onClick(View arg0) {
			  	String bookmark = String.valueOf(bookmarksSpinner.getSelectedItem());
			  	bookmarks.remove(bookmark);
				//bookmarksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bookmarks);
				bookmarksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				bookmarksSpinner.setAdapter(bookmarksAdapter);
		  }

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@SuppressWarnings("unused")
	private void addListenerOnSpinnerItemSelection() {
		// TODO Auto-generated method stub
		Spinner mode_spinner = (Spinner) findViewById(R.id.mode_spinner);
		mode_spinner.setOnItemSelectedListener((OnItemSelectedListener) new CustomOnItemSelectedListener());

		Spinner route_spinner = (Spinner) findViewById(R.id.route_spinner);
		route_spinner.setOnItemSelectedListener((OnItemSelectedListener) new CustomOnItemSelectedListener());

		Spinner direction_spinner = (Spinner) findViewById(R.id.direction_spinner);
		direction_spinner.setOnItemSelectedListener((OnItemSelectedListener) new CustomOnItemSelectedListener());
	}

	@SuppressWarnings("unused")
	private void addListenerOnButton() {
		// TODO Auto-generated method stub

	}
}
