package kr.ac.kookmin.measurementfiltered;


import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Environment;
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

public class MyLog {

    private long startTime;
    private long currentTime;

    private float values[];

    String filename;
    String sensorValue;

    Filter filter;

    File rawFile, lowpassFile, avgFile, mvavgFile;
    FileOutputStream rawOut, lowpassOut, avgOut, mvavgOut;

    Context context;

    MyLog(String filename, Context applicationContext) {
        filter = new Filter();
        this.filename = filename;
        values = new float[3];

        context = applicationContext;
    }

    public void start() {

        startTime = SystemClock.uptimeMillis();

        createFileRaw();
        createFileLowpass();
        createFileAvg();
        createFileMvavg();
    }

    public void stop() {

        try {
            rawOut.close();

            lowpassOut.close();

            avgOut.close();

            mvavgOut.close();
        } catch (Exception e) {
        }
    }

    private void createFileRaw() {
        // String 'filename' format : [SensorTypeSymbol]yymmdd-hour:minute
        // Example : G151219-14:27
        try {
            rawFile = new File(context.getExternalFilesDir(null), filename + "raw.csv");

            rawOut = new FileOutputStream(rawFile, true);
        }
        catch (Exception e) {
        }
    }

    private void createFileLowpass() {

        try {
            lowpassFile = new File(context.getExternalFilesDir(null), filename + "lowpass.csv");

            lowpassOut = new FileOutputStream(lowpassFile, true);
        }
        catch (Exception e) {
        }
    }

    private void createFileAvg() {

        try {
            avgFile = new File(context.getExternalFilesDir(null), filename + "avg.csv");

            avgOut = new FileOutputStream(avgFile, true);
        }
        catch (Exception e) {
        }
    }

    private void createFileMvavg() {

        try {
            mvavgFile = new File(context.getExternalFilesDir(null), filename + "mvavg.csv");

            mvavgOut = new FileOutputStream(mvavgFile, true);
        }
        catch (Exception e) {
        }
    }


    public void raw(SensorEvent event) throws IOException {

        values = filter.raw(event);

        currentTime = SystemClock.uptimeMillis() - startTime;
        sensorValue = currentTime + "," + values[0] + "," + values[1] + "," + values[2] + "\n";
        rawOut.write(sensorValue.getBytes());
    }

    public void lowpass(SensorEvent event) throws IOException {

        values = filter.lowpass(event);

        currentTime = SystemClock.uptimeMillis() - startTime;
        sensorValue = currentTime + "," + values[0] + "," + values[1] + "," + values[2] + "\n";
        lowpassOut.write(sensorValue.getBytes());
    }

    public void avg(SensorEvent event) throws IOException {

        values = filter.avg(event);

        currentTime = SystemClock.uptimeMillis() - startTime;
        sensorValue = currentTime + "," + values[0] + "," + values[1] + "," + values[2] + "\n";
        avgOut.write(sensorValue.getBytes());
    }

    public void mvavg(SensorEvent event) throws IOException {

        values = filter.mvavg(event);

        currentTime = SystemClock.uptimeMillis() - startTime;
        sensorValue = currentTime + "," + values[0] + "," + values[1] + "," + values[2] + "\n";
        mvavgOut.write(sensorValue.getBytes());
    }
}

