/*
package kr.ac.kookmin.androidproject;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class MyButton extends Button {

    private boolean isStart;
    default Imu imu;

    MyButton() {
        isStart = true; 
        imu = new Imu();
    }

    @Override
        public void setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                onStart();
                onStop();
                }
                })

    @Override
        private void onStart() {

            if(isStart) {
                imu.sensorsOn();
                this.setText("Stop");
            }
        }

    @Override
        private void onStop() {

            if(!isStart) {
                imu.sensorsOff();
                this.setText("Start");
            }
        }



}


*/
