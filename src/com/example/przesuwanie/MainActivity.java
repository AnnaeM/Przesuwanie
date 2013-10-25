package com.example.przesuwanie;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// tworzenie przykladowej listy
        Spinner spinnerCountries = (Spinner) findViewById(R.id.spinner_country);
        ArrayAdapter countryArrayAdapter = new ArrayAdapter(this,
                    android.R.layout.simple_spinner_dropdown_item,
                    new String[] { "Canada", "USA" });
        spinnerCountries.setAdapter(countryArrayAdapter);
        
        Button buttonNext = (Button) findViewById(R.id.Button_next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                
                ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
                vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.card_flip_left_in));
                vf.showNext(); 
        }
        });
        
        Button buttonPrevious = (Button) findViewById(R.id.Button_previous);
        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
                vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.card_flip_left_out));
                vf.showPrevious();
        }

        });        
        
        
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
