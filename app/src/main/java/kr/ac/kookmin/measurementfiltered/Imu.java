/*
package kr.ac.kookmin.measurementfiltered;


import java.lang.String;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.*;
import java.io.*;
import android.hardware.*;

public class Imu {

    SensorManager sensorManager;

    Sensor accelerometerSensor;
    Sensor gyroscopeSensor;
    Sensor magnetometerSensor;

    Accelerometer accelerometer;
    Gyroscope gyroscope;
    Magnetometer magnetometer;

    Imu() {
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        accelerometer = new Accelerometer();
        gyroscope = new Gyroscope();
        magnetometer = new Magnetometer();

        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE_UNCALIBRATED);
        magnetometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    public void sensorsOn() {

        sensorManager.registerListener(accelerometer, accelerometerSensor, SensorManager.SENSOR_DELAY_FASTEST);
        sensorManager.registerListener(gyroscope, gyroscopeSensor, SensorManager.SENSOR_DELAY_FASTEST);
        sensorManager.registerListener(magnetometer, magnetometerSensor, SensorManager.SENSOR_DELAY_FASTEST);

        accelerometer.log.start();
        gyroscope.log.start();
        magnetometer.log.start();
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
*/

