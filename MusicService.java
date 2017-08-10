package com.example.guessnumber;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
MediaPlayer mp;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mp=MediaPlayer.create(getApplicationContext(),R.raw.abc);
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		if(mp!=null)
			mp.stop();
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		if(mp!=null)
			mp.start();
		super.onStart(intent, startId);
	}
	

}
