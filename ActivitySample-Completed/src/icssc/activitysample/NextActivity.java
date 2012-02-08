package icssc.activitysample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends Activity
{
	public void onCreate(Bundle b)
	{
		super.onCreate(b);
		setContentView(R.layout.other);
		
		TextView tv = (TextView)findViewById(R.id.result);
		
		Intent intent = getIntent();
		
		if(intent.getIntExtra("CORRECT", 0) == intent.getIntExtra("BUTTON", 0))
			tv.setText("Correct!");
		else
			tv.setText("Incorrect!");
		/*
		 * First, let's find the TextView we will be editing from the layout
		 * use findViewById(int id) and R class to find and cast the View
		 *  to a TextView. The id is result
		 *  
		 *  Next, retrieve the Intent we just sent over to this Activity via
		 *  the getIntent() method.
		 *  
		 *  Now, retrieve the two int packaged along with the Intent.
		 *  
		 *  intent.getIntExtra("BUTTON", 0) retrieves the int data with name "BUTTON" 
		 *  and sets it to a default of 0 if it cannot find it
		 *  Do the same thing with "CORRECT"
		 *  
		 *  Test to see if the correct button has been pressed,
		 *  call tv.setText("") to set the text accordingly.
		 *  
		 *  Note that we are in a new Activity. Although it has been done for you,
		 *  remember that all new Activities must be declared in the Android Manifest before you
		 *  start it. It is advisable to look at how it is done in the Android Manifest
		 */
			
	}
}
