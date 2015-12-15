package com.example.administrator.myfirst;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import java.io.File;
import java.util.logging.Handler;

public class MainActivity extends Activity {
    private int currentColor = 0;
    //定义一个颜色数组
    final int[] colors = new int[]{
            R.color.color7,
            R.color.color6,
            R.color.color5,
            R.color.color4,
            R.color.color3,
            R.color.color2,
            R.color.color1,
    };

    final int[] names = new int[] {
            R.id.View01,
            R.id.View02,
            R.id.View03,
            R.id.View04,
            R.id.View05,
            R.id.View06,
            R.id.View07,
    };
    TextView[] views = new TextView[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framelayout);
        setTitle("can you see me?");

        for (int i = 0; i < 7; i++) {
            views[i] = (TextView) findViewById(names[i]);
        }

    }


}
