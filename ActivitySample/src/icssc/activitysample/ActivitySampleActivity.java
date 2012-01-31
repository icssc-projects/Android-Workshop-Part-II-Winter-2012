package icssc.activitysample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//implement OnClickListener so that we can know when the buttons are pressed
public class ActivitySampleActivity extends Activity
{
	private int id;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*There are 5 buttons, for each one, use findViewById(int id) and the R class
         * to find the button in the layout. b1, b2, b3 ...
         * This returns a view which we cast into the Button class.
         * We then setOnClickListener of this button to this, meaning that this
    	 * Activity acts as the OnClickListener for the button.
         */
        
        id =  (int)(Math.random() * 5) + 1;
        /*
         * id is a random number from 1 to 5
         * This corresponds to which button the user should pick
         * Next, retrieve the TextView the same way you found a Button.
         * The id is text
         * Now, setText so that it is "Click On Button # " + id
         */
    }
    /*
     * create a method required by OnClickListener called public void onClick(View v)
     * View is the view that was just clicked on.
     * 
     * First, test to see which button was pressed. If the id of the view in the parameter
     * matches the id of the button, then that button was pressed
     * Set an int to a number corresponding to which button was pressed
     * (the random number generated is between 1 to 5, so it's recommended that the int
     * you set is between 1 and 5)
     * 
     * next, if the int has been set e.g. a button has been pressed, construct an Intent object to start an Activity
     * The Activity we are starting will simply have the text correct or incorrect, corresponding to which button we pressed
     * 
     * The constructor we will type in for an Intent to start an Activity is new Intent(this, NextActivity.class);
     * first parameter, this, refers to the parent Activity that the new Activity will be started from
     * second parameter, NextActivity.class, refers to the class of the Activity we will be starting, NextActivity
     * 
     * Now, as practice, we will let NextActivity determine whether or not we have pressed the right button
     * To do so, we must send over the id int we have onCreate and the int we set that corresponds to which button was pressed
     * preferably, you have made it so that if you clicked on the right button, the two int are the same
     * To send data to the child Activity, you must put it into the Intent object you just created.
     * 
     * call intent.putExtra("BUTTON", bId) where "BUTTON" is the name of the data and bId is the int that you set
     * then call intent.putExtra("CORRECT", id); where "CORRECT" is the name of the data and id is the int we generated
     * onCreate
     * 
     * Now that your intent is all set, call startActivity(intent) to start the child Activity
     * 
     * Now move to implement the last part in the NextActivity class
     * 
     */
}