package com.example.administrator.myfirst;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Notification.Builder;


public class TestActivity extends Activity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private ArrayAdapter<String> arrAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> datalist;
    private NotificationManager nManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Log.v("debug", "can you see me?");
        Log.d("test", "can you see me?");
        Log.i("test", "can you see me?");
        Log.w("debug", "can you see me?");
        Log.e("test", "can you see me?");
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        String[] lis = {"第一个标题...","第二个标题...","第三个标题...","第四个标题...","第无个标题..."};
        datalist = new ArrayList<Map<String, Object>>();
        simpleAdapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"pic","text"},new int[]{R.id.pic,R.id.text});
        arrAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,lis);
        //listView.setAdapter(arrAdapter);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);

    }

    private List<Map<String,Object>> getData() {
        for (int i=0; i<20; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic",R.drawable.test);
            map.put("text","第"+i+"标题...");
            datalist.add(map);
        }
        return datalist;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String pos =  listView.getItemAtPosition(position)+" ";
        Toast toast = Toast.makeText(this, "position=" + position + "text=" + pos, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Builder builder = new Notification.Builder(this);
        builder.setTicker("hello world");
        builder.setSmallIcon(R.drawable.test);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("通知栏通知");
        builder.setContentText("can you see");
        //builder.setDefaults(Notification.DEFAULT_SOUND);
        //builder.setDefaults(Notification.DEFAULT_LIGHTS);
        //builder.setDefaults(Notification.DEFAULT_VIBRATE);
        Notification notification = builder.build();

        nManager.notify(2,notification);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
