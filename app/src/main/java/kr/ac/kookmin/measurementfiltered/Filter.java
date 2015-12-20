package kr.ac.kookmin.measurementfiltered;


import android.os.Bundle;
import android.os.SystemClock;
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

public class Filter {

    private float[] values; // Universal use
    private float[] sum; // Moving avergae filter

    private float alpha = (float)0.8; // Low-pass filter

    private float[] xrecord; // Moving average filter
    private float[] yrecord; // Moving average filter
    private float[] zrecord; // Moving avergae filter

    private int i = 0; // Moving average filter
    private long n = 0; // Average filter

    Filter() {
        values = new float[3];
        xrecord = new float[10];
        yrecord = new float[10];
        zrecord = new float[10];

        sum = new float[3];
    }

    float[] raw(SensorEvent event) {
        
        values[0] = event.values[0];
        values[1] = event.values[1];
        values[2] = event.values[2];

        return values;
    }

    float[] lowpass(SensorEvent event) {

        values[0] = alpha * values[0] + (1 - alpha) * event.values[0];
        values[1] = alpha * values[1] + (1 - alpha) * event.values[1];
        values[2] = alpha * values[2] + (1 - alpha) * event.values[2];

        return values;
    }

    float[] avg(SensorEvent event) {

        values[0] = (n * values[0] + event.values[0]) / (n + 1);
        values[1] = (n * values[1] + event.values[1]) / (n + 1);
        values[2] = (n * values[2] + event.values[2]) / (n + 1);

        n++; 

        return values;
    }   // Changing filter type might mess up the n values

    float[] mvavg(SensorEvent event) {

		sum[0] = sum[1] = sum[2] = 0;

        for(i = 0; i < 9; i++) {
			xrecord[i] = xrecord[i+1]; 
			yrecord[i] = yrecord[i+1];
			zrecord[i] = zrecord[i+1];

			sum[0] += sum[0] + xrecord[i]; // Sum of index 0 to 8
			sum[1] += sum[1] + yrecord[i]; // Sum of index 0 to 8 
			sum[2] += sum[2] + zrecord[i]; // Sum of index 0 to 8
        }

        xrecord[9] = event.values[0];
        yrecord[9] = event.values[1];
        zrecord[9] = event.values[2];
		
		values[0] = (sum[0] + xrecord[9]) / 10;
		values[1] = (sum[1] + yrecord[9]) / 10;
		values[2] = (sum[2] + zrecord[9]) / 10;
		
		return values;
	}
}
        
