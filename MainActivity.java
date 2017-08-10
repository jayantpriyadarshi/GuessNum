package com.example.guessnumber;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {
	Button b1,b2,b3,b4;
	boolean z=true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
               
        b2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(MainActivity.this,Second.class);
				startActivity(i);
			}
		});
        
        
        b4.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(z){
					Intent k=new Intent(MainActivity.this,MusicService.class);
					stopService(k);
					b4.setText("start music");
					z=false;
				}
				else{
					Intent l=new Intent(MainActivity.this,MusicService.class);
					startService(l);
					b4.setText("stop music");
					z=true;
				}
			}
		});
        b3.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity.this,MusicService.class);
				stopService(i);
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);			}
		});
    }
    
    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
    	Intent j = new Intent(MainActivity.this,MusicService.class);
        startService(j);
		super.onStart();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		Toast.makeText(getApplicationContext(), "Back button disables", Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
    	Intent i=new Intent(MainActivity.this,MusicService.class);
		stopService(i);
		super.onDestroy();
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
