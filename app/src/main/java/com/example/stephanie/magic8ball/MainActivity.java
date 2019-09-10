package com.example.stephanie.magic8ball;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;


import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private String list [] = new String[20];
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            populateArray();
            System.out.println("Opened File");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        button = findViewById(R.id.button);
////        button.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view)
////            {
////                int number = (int) (Math.random()*20);
////                text = findViewById(R.id.textView);
////                text.setText(list[number]);
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    public void run() {
//                        text.setText(" ");
//                    }
//                }, 5000);
////            }
////        });

        final SensorManager mngr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        final Sensor accel = mngr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        final SensorEventListener listener = new SensorEventListener(){
            public void onAccuracyChanged(Sensor sensor, int accuracy){}

            public void onSensorChanged(SensorEvent event){
//                int number = (int) (Math.random()*20);
//                text = findViewById(R.id.textView);
//                text.setText(list[number]);
                  if(event.values[1] >4 && event.values[2] <-5){
                          int number = (int) (Math.random() * 20);
                          text = findViewById(R.id.textView);
                          text.setText(list[number]);
                          Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                    public void run() {
                        text.setText(" ");
                    }
                }, 5000);

                  }
                  else if (event.values[1]==9.80 ){
                      text.setText(" ");

                  }

            }
        };

        mngr.registerListener( listener, accel, SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void populateArray() throws FileNotFoundException {
//        File file = new File("answer.txt");

//        Scanner scan = new Scanner(file);
//        for(int i =0; i<list.length; i++){
//            list[i]= scan.next();
//            System.out.println(scan.next());
//        }
        list[0]="It is certain\n";
        list[1]="It is decidedly so\n";
        list[2]="Without a doubt\n";
        list[3]="Yes definitely\n";
        list[4]="You may rely on it\n";
        list[5]="As I see it yes\n";
        list[6]="Most likely\n";
        list[7]="Outlook good\n";
        list[8]="Yes";
        list[9]="Signs point to yes\n";
        list[10]="Reply hazy try again\n";
        list[11]="Ask again later\n";
        list[12]="Better not tell you now\n";
        list[13]="Cannot predict now\n";
        list[14]="Concentrate and ask again\n";
        list[15]="Don't count on it\n";
        list[16]="My reply is no\n";
        list[17]="My sources say no\n";
        list[18]="Outlook not so good\n";
        list[19]="Very doubtful\n";
    }

}
