package de.tud.planetenquiz;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.end);
		
		SharedPreferences p = this.getSharedPreferences(SpinnerActivity.PREFERENCES_FILE, MODE_WORLD_READABLE);
        String name = p.getString(StartActivity.NAME_KEY, "");
        Set<String> answers = p.getStringSet(SpinnerActivity.ANSWERS_KEY, null);
        String correct = "";
        if(answers != null) {
        	Boolean[] answersArray = SpinnerActivity.getAnswersArrayFromSet(answers);
        	int correctCnt = 0;
        	int notAnswered = 0;
        	for (int i=0; i<9; i++) {
        		if(answersArray[i] == null) {
        			notAnswered++;
        		} else if (answersArray[i]) {
        			correctCnt++;
        		}
        	}    
        	//Fehler eingebaut: anzahl falscher Antworten wird angezeigt
        	correct = name + " du hast " + (9 - correctCnt - notAnswered) + " von 9 Fragen richtig beantwortet.";
        	if(notAnswered>0) {
        		correct =  correct + " " +  notAnswered + " Fragen wurden noch nicht beantwortet.";
        	}
        } else {
        	correct = "AppFehler.";
        }
        TextView text = (TextView) findViewById(R.id.summary);
        text.setText(correct);
		Button restart = (Button) findViewById(R.id.restart);
		Button viewResults = (Button) findViewById(R.id.viewResult);
		restart.setOnClickListener(new MyButtonListener());
		viewResults.setOnClickListener(new MyButtonListener());
	}
	
	private class MyButtonListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			if(v.getId() == R.id.restart) {
				Intent intent = new Intent(v.getContext(), StartActivity.class);
				startActivity(intent);
			}
			if(v.getId() == R.id.viewResult) {
				Intent intent = new Intent(v.getContext(), SpinnerActivity.class);
				startActivity(intent);
			}
		}
	}	
}
