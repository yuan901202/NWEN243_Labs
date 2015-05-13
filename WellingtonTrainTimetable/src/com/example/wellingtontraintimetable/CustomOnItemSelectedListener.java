package com.example.wellingtontraintimetable;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CustomOnItemSelectedListener implements OnItemClickListener {

	public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
		Toast.makeText(parent.getContext(),
			"OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
			Toast.LENGTH_SHORT).show();
	  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}
