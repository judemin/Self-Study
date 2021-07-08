package com.nextop.project.sentihandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int _cnt = 0;
    private TextView tv;
    private Handler _handler = new Handler();
    private Runnable _runnable = new Runnable() {
        @Override
        public void run() {
            _cnt++;
            tv.setText("" + _cnt);

            if(_cnt < 5) {
                _handler.postDelayed(this, 1000); // 1000밀리 세컨드이후 post
            } else{
                _handler.removeCallbacks(_runnable);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.act_main_tv);

        _handler.postDelayed(_runnable,1000); // 1000밀리 세컨드이후 post
    }
}
