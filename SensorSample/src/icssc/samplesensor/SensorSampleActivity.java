package icssc.samplesensor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.TextView;

//implement an SensorEventListener so that we can use it to read the events of the sensor
public class SensorSampleActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
	  
		super.onCreate(savedInstanceState);
		/*create an instance of the SensorManager
		 *Accelerometer is one type of sensor, there a variety we can use
		 *
		 *getSystemService(SENSOR_SERVICE) returns the sensor manager we are looking for
		 *simply cast that to the SensorManager class and we are ready to use it
		 *
		 *call mySensorManager.registerListener(this, 
		 *			mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
		 *			SensorManager.SENSOR_DELAY_NORMAL)
		 *first parameter is the context in which the sensor will live in
		 *second parameter is the sensor we will be using, the Sensor.TYPE_ACCELEROMETER specifies that
		 *	we will be using the acceleromter sensor
		 *third parameter is the delay in between sensor readings
		 *
		 *Now we are ready to start reading sensor events
		 */
	}

	/*implement two methods, the public void onSensorChanged(SensorEvent event) method
	 *and the public void onAccuracyChanged(Sensor sensor, int accuracy) method
	 *the second method is not used in this example but will be called when the sensor's accuracy
	 *changes for any reason
	 *
	 *In the onSensorChanged method, the system passes in a SensorEvent object that contains the information we want
	 *
	 *first, we should test to see if the event.sensor.getType() is equal to the Sensor.TYPE_ACCELEROMETER
	 *	if it is, then that means the accelerometer is returning the event
	 *
	 *next, we retrieve the values of the sensor event from the event.values. The values are stored in a float[]
	 *
	 *Depending on which kind of sensor we are reading, the values will be formatted differently
	 *To learn how each sensor formats its data, see 
	 *http://developer.android.com/reference/android/hardware/SensorEvent.html#values
	 *
	 *When we are dealing with accelerometer, the first value is the x accleration
	 *the second value is y accleration
	 *the third value is z accleration
	 *
	 *For an excercise, retrieve the empty TextView in our layout using R class and findViewById(int id) method
	 *id is sensortext
	 *
	 *Then set the text to display the information of the accelerometer values
	 **NOTE* if you are using an emulator, you won't really be able to test your sensor
	 * to test your sensors, you should load onto your phone
	 */
}