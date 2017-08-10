package com.example.guessnumber;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Second extends Activity {
Spinner s;
 int a;
Button b,bb;
 int x;
static int y =0;
 //String rand_nums[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		Random r = new Random();
		//View layout=findViewById(R.layout.second);
	     a = r.nextInt(20);
	     System.out.print(a);
		b=(Button)findViewById(R.id.button1);
		bb=(Button)findViewById(R.id.button2);
		s=(Spinner) findViewById(R.id.spinner1);
	//    s.setOnItemSelectedListener((OnItemSelectedListener) this);

		ArrayAdapter<CharSequence> ad=ArrayAdapter.createFromResource(this,R.array.rand_nums, android.R.layout.simple_spinner_item);
		ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(ad);
	
		
		b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				y++;
				x=Integer.parseInt(s.getSelectedItem().toString());
				if(x==a){
					y=0;
					//Toast.makeText(getApplicationContext(), "You won",Toast.LENGTH_SHORT).show();
					Intent i=new Intent(Second.this,Third.class);
					startActivity(i);
				}
				else if(x>a){
					Toast.makeText(getApplicationContext(), "Too large", Toast.LENGTH_SHORT).show();
					
				}
				else
					Toast.makeText(getApplicationContext(), "Too small", Toast.LENGTH_SHORT).show();
				if(y==4){
					final AlertDialog dialog=new AlertDialog.Builder(Second.this).create();
					dialog.setTitle("Warning");
					dialog.setMessage("Your Last Chance");
					dialog.setButton("OK", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
					dialog.show();
				}
				if(y==5){
					y=0;
					Intent i=new Intent(Second.this,Forth.class);
					startActivity(i);
				}
			}
		});
bb.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				y=0;
				Intent i=new Intent(Second.this,MainActivity.class);
				startActivity(i);
			}
		});
		
		}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		Toast.makeText(getApplicationContext(), "Back button disables", Toast.LENGTH_LONG).show();
	}

	}
	


