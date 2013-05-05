/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.tudresden.mgt.aut;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import de.tud.planetenquiz.R;

/**
 * Displays an Android spinner widget backed by data in an array. The
 * array is loaded from the strings.xml resources file.
 */
public class SpinnerActivity extends Activity {

    /**
     * Fields to contain the current position and display contents of the spinner
     */
    protected int mPos;
    protected String mSelection;

    /**
     * ArrayAdapter connects the spinner widget to array-based data.
     */
    protected ArrayAdapter<CharSequence> mAdapter;    
    private int[] moonsArray;
    
    private Boolean[] answerArray;
    
    private boolean next;

    /**
     *  The initial position of the spinner when it is first installed.
     */
    public static final int DEFAULT_POSITION = 0;

    public static final String PREFERENCES_FILE = "SpinnerPrefs";
    public static final String PROPERTY_DELIMITER = "=";
    public static final String POSITION_KEY = "Position";
    public static final String SELECTION_KEY = "Selection";
    public static final String ANSWERS_KEY = "Answers";
    public static final String POSITION_MARKER =
            POSITION_KEY + PROPERTY_DELIMITER;

    public static final String SELECTION_MARKER =
            SELECTION_KEY + PROPERTY_DELIMITER;

    /**
     * Initializes the application and the activity.
     * 1) Sets the view
     * 2) Reads the spinner's backing data from the string resources file
     * 3) Instantiates a callback listener for handling selection from the
     *    spinner
     * Notice that this method includes code that can be uncommented to force
     * tests to fail.
     *
     * This method overrides the default onCreate() method for an Activity.
     *
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        /**
         * derived classes that use onCreate() overrides must always call the super constructor
         */
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner01);

        next = true;
        moonsArray = this.getResources().getIntArray(R.array.Moons);
        this.mAdapter = ArrayAdapter.createFromResource(this, R.array.Planets,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(this.mAdapter);

        OnItemSelectedListener spinnerListener = new myOnItemSelectedListener(this,this.mAdapter);
        OnCheckedChangeListener radioListener = new myOnCheckedChangeListener();

        spinner.setOnItemSelectedListener(spinnerListener);
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
        group.setOnCheckedChangeListener(radioListener);
        
        answerArray = new Boolean[9];
        
        Button summary = (Button) findViewById(R.id.button1);
        OnClickListener buttonListener = new myOnClickListener();
        summary.setOnClickListener(buttonListener);
    }

        
    /**
     *  A callback listener that implements the
     *  {@link android.widget.AdapterView.OnItemSelectedListener} interface
     *  For views based on adapters, this interface defines the methods available
     *  when the user selects an item from the View.
     *
     */
    public class myOnItemSelectedListener implements OnItemSelectedListener {

        /*
         * provide local instances of the mLocalAdapter and the mLocalContext
         */

        ArrayAdapter<CharSequence> mLocalAdapter;
        Activity mLocalContext;

        /**
         *  Constructor
         *  @param c - The activity that displays the Spinner.
         *  @param ad - The Adapter view that
         *    controls the Spinner.
         *  Instantiate a new listener object.
         */
        public myOnItemSelectedListener(Activity c, ArrayAdapter<CharSequence> ad) {

          this.mLocalContext = c;
          this.mLocalAdapter = ad;
        }

        /**
         * When the user selects an item in the spinner, this method is invoked by the callback
         * chain. Android calls the item selected listener for the spinner, which invokes the
         * onItemSelected method.
         *
         * @see android.widget.AdapterView.OnItemSelectedListener#onItemSelected(
         *  android.widget.AdapterView, android.view.View, int, long)
         * @param parent - the AdapterView for this listener
         * @param v - the View for this listener
         * @param pos - the 0-based position of the selection in the mLocalAdapter
         * @param row - the 0-based row number of the selection in the View
         */
        public void onItemSelected(AdapterView<?> parent, View v, int pos, long row) {

            SpinnerActivity.this.mPos = pos;
            SpinnerActivity.this.mSelection = parent.getItemAtPosition(pos).toString();
            
            TextView question  = (TextView) findViewById(R.id.frage);
            question.setText(SpinnerActivity.this.getResources().getString(R.string.frage) + " " + mSelection + "?");
            
            RadioButton button0 = (RadioButton) findViewById(R.id.radio0);
            RadioButton button1 = (RadioButton) findViewById(R.id.radio1);
            RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
            TextView resultText = (TextView) findViewById(R.id.spinnerResult);
    		int mMoon = moonsArray[mPos];
            if(answerArray[mPos] != null) {
            	next = false;
            	group.setClickable(false);    
            	button0.setClickable(false);
            	button1.setClickable(false);
            	
            	if(answerArray[mPos]) {   
            		//Error to find by Test
            		//resultText.setText(R.string.correctAnswer);
					//resultText.setTextColor(Color.GREEN);
            		if(mMoon % 2 == 0) {
    	            	button0.setText(mMoon+"");
    	            	button0.setHighlightColor(Color.GREEN);
    	            	button0.setChecked(true);
    	            	button1.setText("");
    	            } else {
    	            	button1.setText(mMoon+"");
    	            	button1.setHighlightColor(Color.GREEN);
    	            	button1.setChecked(true);
    	            	button0.setText("");
    	            }
            	} else {
            		//Error to find by Test
            		//resultText.setText(R.string.wrongAnswer);
					//resultText.setTextColor(Color.RED);
            		if(mMoon % 2 == 0) {
    	            	button0.setText(mMoon+"");
    	            	button1.setHighlightColor(Color.RED);
    	            	button1.setChecked(true);
    	            	button1.setText("");
    	            } else {
    	            	button1.setText(mMoon+"");
    	            	button0.setChecked(true);
    	            	button0.setHighlightColor(Color.RED);
    	            	button0.setText("");
    	            }
            	}     	
            } else {            	
            	if(!next) {
            		resultText.setText("");
            	}            	
            	next = true;  
            	group.setClickable(true);
            	button0.setClickable(true);
            	button1.setClickable(true);
	            Random random = new Random();
	             
	            boolean wrongMore = random.nextBoolean();
	            int wrongAnswer;
	            if(wrongMore) {
	            	wrongAnswer = Math.abs(mMoon+random.nextInt(5));
	            } else {
	            	wrongAnswer = Math.abs(mMoon-random.nextInt(5));
	            }
	            if(wrongAnswer == mMoon) {
	            	wrongAnswer+=2;
	            }
	            if(mMoon % 2 == 0) {
	            	button0.setText(mMoon+"");
	            	button1.setText(wrongAnswer+"");
	            } else {
	            	button1.setText(mMoon+"");
	            	button0.setText(wrongAnswer+"");
	            }            
	            if(group.getCheckedRadioButtonId() != -1) 
	            	group.clearCheck();
            }
        }

        /**
         * The definition of OnItemSelectedListener requires an override
         * of onNothingSelected(), even though this implementation does not use it.
         * @param parent - The View for this Listener
         */
        public void onNothingSelected(AdapterView<?> parent) {}
    }
    
    /**
     * 
     */
    public class myOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			if(v.getId() == R.id.button1) {
				SharedPreferences p =
		                v.getContext().getSharedPreferences(SpinnerActivity.PREFERENCES_FILE, MODE_WORLD_READABLE);
		        SharedPreferences.Editor e = p.edit();
		        Set<String> answers = getSetFromAnswersArray(answerArray);
		        e.putStringSet(ANSWERS_KEY, answers);

		        e.commit();
				
				Intent intent = new Intent(v.getContext(), EndActivity.class);
				startActivity(intent);
			}
		}
    	
    }
    

    public class myOnCheckedChangeListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			TextView resultText = (TextView) findViewById(R.id.spinnerResult);
			Spinner nextSpinner = (Spinner) findViewById(R.id.spinner01);
			if(checkedId != -1) {
				RadioButton selected = (RadioButton) findViewById(checkedId);				
	            if(selected.isChecked() && next) {
	            	if(!selected.getText().toString().isEmpty() && 
							Integer.parseInt(selected.getText().toString()) == moonsArray[mPos]) {
						resultText.setText(R.string.correctAnswer);
						answerArray[mPos] = true;
						resultText.setTextColor(Color.GREEN);
					} else {
						resultText.setText(R.string.wrongAnswer);
						resultText.setTextColor(Color.RED);
						answerArray[mPos] = false;
					}
					if(mPos<8 && next) {
						nextSpinner.setSelection(mPos+1);
					} else {
						findViewById(R.id.radio1).setClickable(false);
						findViewById(R.id.radio0).setClickable(false);		            	
					}
	            }
			}
//		    else {
//				resultText.setText("");
//			}
		}
    	
    }
    
    /**
     * Restores the current state of the spinner (which item is selected, and the value
     * of that item).
     * Since onResume() is always called when an Activity is starting, even if it is re-displaying
     * after being hidden, it is the best place to restore state.
     *
     * Attempts to read the state from a preferences file. If this read fails,
     * assume it was just installed, so do an initialization. Regardless, change the
     * state of the spinner to be the previous position.
     *
     * @see android.app.Activity#onResume()
     */
    @Override
    public void onResume() {
    	super.onResume();

        if (!readInstanceState(this)) 
    	setInitialState();

        Spinner restoreSpinner = (Spinner)findViewById(R.id.spinner01);
        restoreSpinner.setSelection(getSpinnerPosition());
    }

    public static Set<String> getSetFromAnswersArray(Boolean[] answerArray2) {
    	Set<String> ret = new HashSet<String>();
    	for(int i=0; i<9; i++) {
    		if(answerArray2[i] == null) {
    			ret.add(i + "null");
    		} else {
    			ret.add(i+answerArray2[i].toString());
    		}
    	}
		return ret;
	}
    
    public static Boolean[] getAnswersArrayFromSet(Set<String> answerSet) {
    	Boolean[] ret = new Boolean[9];
    	if(answerSet == null) return ret;
    	for(String answer : answerSet) {
    		int index = Integer.parseInt(answer.substring(0, 1));
    		if(answer.substring(1).equalsIgnoreCase("true")){
    			ret[index] = true;
    		} else if(answer.substring(1).equalsIgnoreCase("false")) {
    			ret[index] = false;
    		} else if(answer.substring(1).equalsIgnoreCase("null")) {
    			ret[index] = null;
    		}
    	}
		return ret;
	}

	/**
     * Store the current state of the spinner (which item is selected, and the value of that item).
     * Since onPause() is always called when an Activity is about to be hidden, even if it is about
     * to be destroyed, it is the best place to save state.
     *
     * Attempt to write the state to the preferences file. If this fails, notify the user.
     *
     * @see android.app.Activity#onPause()
     */
    @Override
    public void onPause() {

        super.onPause();
        if (!writeInstanceState(this)) {
             Toast.makeText(this,
                     "Failed to write state!", Toast.LENGTH_LONG).show();
          }
    }

    /**
     * Sets the initial state of the spinner when the application is first run.
     */
    public void setInitialState() {
        this.mPos = DEFAULT_POSITION;
    }

    /**
     * Read the previous state of the spinner from the preferences file
     * @param c - The Activity's Context
     */
    public boolean readInstanceState(Context c) {
    	SharedPreferences p = c.getSharedPreferences(PREFERENCES_FILE, MODE_WORLD_READABLE);
        this.answerArray = getAnswersArrayFromSet(p.getStringSet(ANSWERS_KEY, null));
        if(answerExists()) {
        	this.mPos = p.getInt(POSITION_KEY, SpinnerActivity.DEFAULT_POSITION);
        	this.mSelection = p.getString(SELECTION_KEY, "");
        }
        return (p.contains(POSITION_KEY));
    }

    /**
     * Write the application's current state to a properties repository.
     * @param c - The Activity's Context
     *
     */
    public boolean writeInstanceState(Context c) {

        SharedPreferences p =
                c.getSharedPreferences(SpinnerActivity.PREFERENCES_FILE, MODE_WORLD_READABLE);
        SharedPreferences.Editor e = p.edit();
        e.putInt(POSITION_KEY, this.mPos);
        e.putString(SELECTION_KEY, this.mSelection);
        e.putStringSet(ANSWERS_KEY, getSetFromAnswersArray(this.answerArray));
        return (e.commit());
    }

    public int getSpinnerPosition() {
        return this.mPos;
    }

    public void setSpinnerPosition(int pos) {
        this.mPos = pos;
    }

    public String getSpinnerSelection() {
        return this.mSelection;
    }

    public void setSpinnerSelection(String selection) {
        this.mSelection = selection;
    }
    
    public boolean answerExists() {
    	for(int i=0; i<9; i++) {
    		if(answerArray[i] != null) {
    			return true;
    		} 
    	}
    	return false;
    }
}
