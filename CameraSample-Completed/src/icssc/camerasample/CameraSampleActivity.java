package icssc.camerasample;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

//implement OnClickListener so that you can do something when a button is clicked
public class CameraSampleActivity extends Activity implements OnClickListener
{
	//Called when Activity is created
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b = (Button)findViewById(R.id.camerabutton);
        b.setOnClickListener(this);
        
        //retrieve the button in our layout via the R class and the findViewById(int id) method
        //then set the onclicklistener for the button to the keyword this
    }
    public void onClick(View v)
    {
    	if(v.getId() == R.id.camerabutton)
    	{
    		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    		intent.putExtra(MediaStore.EXTRA_OUTPUT, getOutputMediaFileUri());
    		startActivityForResult(intent, 1);
    	}
    }
    /*
    * all we need to do is include the necessary onClick(View view) method
    * all other methods we need are included here for you
    * 
    * The system will pass in the View that was just clicked on as the parameter
    * 
    * confirm that the view is the button we are looking for by comparing the id
    * 
    * create an intent that asks to open the camera app and take a picture
    * you can do this by by constructing a new Intent object with the parameter MediaStore.ACTION_IMAGE_CAPTURE
    * The MediaStore.ACTION_IMAGE_CAPTURE defines the action the intent is to do, which is take a picture using the camera
    * 
    * In order to take a picture, we want to specify where to save the image data, so we must also create a file path and 
    * give that to the intent so it knows where we want the picture to be stored
    * Do this by calling the method getOutputMediaFileUri(int type) implemented for you
    * After we have the Uri we are looking for, we can now store it in our intent by calling 
    * ourIntent.putExtra(MediaStore.Extra_Output, uriReturnedFromMethod);
    * The MediaStore.Extra_Output is a string that tells the intent that what we are putting in right now is part of what the camera
    * needs
    * 
    * Now that our intent is good to go, we can call the startActivityForResult(ourIntent, 1) method with the intent as a parameter.
    * The startActivityForResult method differs from the startActivity method because when we start an activity for a result, we
    * are notified when the activity we started ends via the onActivityResult method we can override.
    * The second parameter is an int we can arbitrarily choose that acts as an id for our activity
    * 
    * Now we are done implementing our onClick method!
    * 
    * When the activity we started ends, we are sent back information via the overrided onActivityResult method implemented for you
    * 
    * REMEBER!!! We need to declare the permissions for the camera to work
    * Don't forget to put this in the Android Manifest in between the manifest tags
    * 
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-feature android:name="android.hardware.camera" />
    <uses-feature android:name="android.hardware.camera.autofocus" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    *
    */
    
    
        
    /* Create a URI for saving an image*/
    private static Uri getOutputMediaFileUri(){
    	
    	//We create this file as the directory where we will save our pictures
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                  Environment.DIRECTORY_PICTURES), "MyCameraApp");

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }
        
        // Create a media file name and return the Uri
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
            "IMG_"+ timeStamp + ".jpg");

        return Uri.fromFile(mediaFile);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	//request code is the int we put in when we call startActivityForResult, if it is the same, we know 
    	//it is the correct activity that just finished
        if (requestCode == 1) {
        	//if the resultcode is ok, then we know that whatever we were doing with the activity
        	//ended ok
            if (resultCode == RESULT_OK) {
            	//Use the Toast to make a little message telling us that this is okay
                Toast.makeText(this, "Image taken", Toast.LENGTH_LONG).show();
            }
        }
    }
}