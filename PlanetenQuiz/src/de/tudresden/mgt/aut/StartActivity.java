package de.tudresden.mgt.aut;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import de.tud.planetenquiz.R;

public class StartActivity extends Activity {
	
	public static final String NAME_KEY = "Name"; 
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		Button button = (Button) findViewById(R.id.start);
		button.setOnClickListener(new MyButtonListener());
	}
	
	private class MyButtonListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			EditText edit = (EditText) findViewById(R.id.nameField);
			TextView name = (TextView) findViewById(R.id.enterName);
			if(edit.getText().length()==0) {
				name.setTextColor(Color.RED);
			} else {
				SharedPreferences p =
		                v.getContext().getSharedPreferences(SpinnerActivity.PREFERENCES_FILE, MODE_WORLD_READABLE);
		        SharedPreferences.Editor e = p.edit();
		        e.putStringSet(SpinnerActivity.ANSWERS_KEY, SpinnerActivity.getSetFromAnswersArray(new Boolean[9]));
		        e.commit();
				Intent intent = new Intent(v.getContext(), SpinnerActivity.class);
				startActivity(intent);
			}
		}
	}
	
	@Override
    public void onPause() {
		super.onPause();
		
		EditText edit = (EditText) findViewById(R.id.nameField);
		SharedPreferences p =
                this.getSharedPreferences(SpinnerActivity.PREFERENCES_FILE, MODE_WORLD_READABLE);
        SharedPreferences.Editor e = p.edit();
                
        e.putString(NAME_KEY, edit.getText().toString());
        e.commit();
    }
}
