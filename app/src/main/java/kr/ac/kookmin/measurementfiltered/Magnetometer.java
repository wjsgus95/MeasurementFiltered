package kr.ac.kookmin.measurementfiltered;


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

public class Magnetometer implements SensorEventListener {

    public MyLog log;

    Magnetometer(Context applicationContext) {
        log = new MyLog(setFilename(), applicationContext);
    }

    @Override
        public void onSensorChanged(SensorEvent event) {
        try {
            log.raw(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            log.lowpass(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            log.avg(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            log.mvavg(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    public String setFilename() {

        //Gregorian Date and Time Instacne Declaration
        Calendar c = Calendar.getInstance();

        String LOG = "M";

        LOG += String.valueOf(c.get(Calendar.YEAR)).substring(2);

        if (c.get(Calendar.MONTH) < 10)
            LOG += "0";
        LOG += c.get(Calendar.MONTH) + 1;

        if (c.get(Calendar.DATE) < 10)
            LOG += "0";
        LOG += c.get(Calendar.DATE);

        LOG += "-";

        if (c.get(Calendar.HOUR_OF_DAY) < 10)
            LOG += "0";
        LOG += c.get(Calendar.HOUR_OF_DAY);

        LOG += ":";

        if (c.get(Calendar.MINUTE) < 10)
            LOG += "0";
        LOG += c.get(Calendar.MINUTE);

        return LOG;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

