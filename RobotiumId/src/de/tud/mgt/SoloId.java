package de.tud.mgt;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jayway.android.robotium.solo.Solo;

public class SoloId extends Solo{

	public SoloId(Instrumentation instrumentation) {
		super(instrumentation);
	}

	public SoloId(Instrumentation instrumentation, Activity activity)  {
		super(instrumentation, activity);
	}	
	
	@Override
	public void pressSpinnerItem(int id, int itemIndex) {
		super.pressSpinnerItem(getPositionFromId("Spinner", id), itemIndex);
	}
	
	private int getPositionFromId(String viewType, int id) {
		HashMap<String, String> theMap = new HashMap<String, String>();
		theMap.put("Spinner", "getCurrentSpinners");	
		theMap.put("Button", "getCurrentButtons");
		theMap.put("EditText", "getCurrentEditTexts");
		theMap.put("RadioButton", "getCurrentRadioButtons");
		if(theMap.containsKey(viewType)) {
			try {
				Method m = super.getClass().getMethod(theMap.get(viewType), (Class<?>[]) null);
				@SuppressWarnings("unchecked")
				List<View> views = (List<View>) m.invoke(this, (Object[]) null);
				for(int i=0; i<views.size(); i++) {
					View view = views.get(i);
					if(view.getId() == id) {
						System.out.println(id + "mapped to " + i);
						return i;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}		
		
		List<View> allViews = super.getCurrentViews();
		for(int i=0; i<allViews.size(); i++) {
			View view = allViews.get(i);
			if(view.getId() == id) {
				System.out.println(id + "mapped to " + i);
				return i;
			}
		}
		System.out.println(id + "not found");
		return 0;
	}
	
	@Override
	public void clickOnButton(int id) {
		super.clickOnButton(getPositionFromId("Button", id));
	}
	
	@Override
	public void clearEditText(int id) {
		super.clearEditText(getPositionFromId("EditText", id));
	}
	
	@Override
	public void clickOnRadioButton(int id) {
		super.clickOnRadioButton(getPositionFromId("RadioButton", id));
	}
	
	@Override
	public void enterText(int id, String text) {
		super.enterText((getPositionFromId("EditText", id)), text);
	}
	
	@Override
	public Button getButton(int id) {
		return super.getButton(getPositionFromId("Button", id));
	}
	
	@Override
	public boolean isRadioButtonChecked(int id) {
		return super.isRadioButtonChecked(getPositionFromId("RadioButton", id));
	}
	
	@Override
	public boolean isSpinnerTextSelected(int id, String text) {
		return super.isSpinnerTextSelected(getPositionFromId("Spinner", id), text);
	}
	
//	@Override
//	public void pressMenuItem(int id) {
//		super.pressMenuItem(getPositionFromId("Menu", id));
//	}
	
	@Override
	public boolean scrollUpList(int id) {
		return super.scrollUpList(getPositionFromId("ListView", id));
	}
	
	public void sendKey(String updown) {
		if(updown.equalsIgnoreCase("UP")) sendKey(Solo.UP);
		else if(updown.equalsIgnoreCase("DOWN")) sendKey(Solo.DOWN);
		else if(updown.equalsIgnoreCase("RIGHT")) sendKey(Solo.RIGHT);
		else if(updown.equalsIgnoreCase("LEFT")) sendKey(Solo.LEFT);
	}
	
	@Override
	public void typeText(int id, String text) {
		super.typeText(getPositionFromId("EditText", id), text);
	}
	
	@Override
	public void setTimePicker(int id, int hour, int minute) {
		super.setTimePicker(getPositionFromId("TimePicker", id), hour, minute);
	}
	
	public String getTextColorOfView(int id) {
		ArrayList<View> views = super.getCurrentViews();
		for(View view : views) {
			if(view.getId() == id) {
				int color = ((TextView) view).getCurrentTextColor();
				
//				switch(color) {
//				case Color.RED: return "RED";
//				case Color.BLACK: return "BLACK";
//				case Color.BLUE: return "BLUE";
//				case Color.GREEN: return "GREEN";
//				case Color.GRAY: return "GREY";
//				case Color.YELLOW: return "YELLOW";
//				case Color.WHITE: return "WHITE";
//				default: return color + "";
//				}		
				return Integer.toHexString(color);
			}
		}
		return "";
	}
}
