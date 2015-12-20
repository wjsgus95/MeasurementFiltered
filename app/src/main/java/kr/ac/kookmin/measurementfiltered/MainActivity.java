package kr.ac.kookmin.measurementfiltered;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;

    Sensor accelerometerSensor;
    Sensor gyroscopeSensor;
    Sensor magnetometerSensor;

    Accelerometer accelerometer;
    Gyroscope gyroscope;
    Magnetometer magnetometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED);
        magnetometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        accelerometer = new Accelerometer();
        gyroscope = new Gyroscope();
        magnetometer = new Magnetometer();

        sensorsOn();
    }

    public void sensorsOn() {

        accelerometer.log.start();
        gyroscope.log.start();
        magnetometer.log.start();

        //sensorManager.registerListener(accelerometer, accelerometerSensor, SensorManager.SENSOR_DELAY_FASTEST);
        //sensorManager.registerListener(gyroscope, gyroscopeSensor, SensorManager.SENSOR_DELAY_FASTEST);
        //sensorManager.registerListener(magnetometer, magnetometerSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    public void sensorsOff() {

        sensorManager.unregisterListener(accelerometer);
        sensorManager.unregisterListener(gyroscope);
        sensorManager.unregisterListener(magnetometer);

        accelerometer.log.stop();
        gyroscope.log.stop();
        magnetometer.log.stop();
    }

}
