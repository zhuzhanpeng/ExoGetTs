package com.onairm.hd4tv.online.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;



import com.onairm.hd4tv.online.R;


public class MainActivity extends AppCompatActivity {

    private FocusLinearLayout rlHunan;
    public static String sendJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlHunan = (FocusLinearLayout) findViewById(R.id.rlHunan);

        rlHunan.requestFocus();
        rlHunan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://1.202.169.179/channels/tvie/hnhp/m3u8:sd";
                jumpToExoPlayerActivity(MainActivity.this, url, 1);
            }
        });
    }

    private static void jumpToExoPlayerActivity(Context context,String url,int type){
        Intent intent = new Intent(context, ExoPlayerActivity.class)
                .setData(Uri.parse(url))
                .putExtra("type", type);
        context.startActivity(intent);
    }
}
