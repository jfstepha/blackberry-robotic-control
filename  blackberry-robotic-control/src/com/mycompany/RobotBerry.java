package com.mycompany;
import com.mycompany.CustomButtonField;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;



public class RobotBerry extends UiApplication implements FieldChangeListener {
	
	RobotBerryAPI theRobot = new RobotBerryAPI();
	
	public static void main(String[] args) {
		RobotBerry theApp = new RobotBerry();
		theApp.enterEventDispatcher();
	}
	
    /**
     * FieldChangeListener implementation.  Displays a popup informing the user
     * of what button was clicked.
     * @see net.rim.device.api.ui.FieldChangeListener#fieldChanged(Field, int)
     */
	
	private final String fwdString = "Fwd (2)";
	private final String backString = "Back (8)";
	private final String leftString = "Left (4)";
	private final String rightString = "Right (6)";
	
	public RobotBerry() {
		CustomButtonField btnUp;
		CustomButtonField btnDown;
		CustomButtonField btnLeft;
		CustomButtonField btnRight;


        // MainScreen is the basic screen or frame class of the RIM UI.
        MainScreen mainScreen = new RobotMainScreen();
        
        // Add a vertical field manager containing sample custom button fields.
        //HorizontalFieldManager vfm = new HorizontalFieldManager(Manager.HORIZONTAL_SCROLL);
        VerticalFieldManager vfm = new VerticalFieldManager();
        
        // Forward button 
        vfm.add(new RichTextField(Field.NON_FOCUSABLE));
        btnUp = new CustomButtonField(fwdString, CustomButtonField.TRIANGLE, Field.FOCUSABLE);
        btnUp.setChangeListener(this);
        vfm.add(btnUp);

        // Left button
        vfm.add(new RichTextField(Field.NON_FOCUSABLE));
        btnLeft = new CustomButtonField(leftString, CustomButtonField.TRIANGLE_LEFT, Field.FOCUSABLE);
        btnLeft.setChangeListener(this);
        vfm.add(btnLeft);

        // Right button
        vfm.add(new RichTextField(Field.NON_FOCUSABLE));
        btnRight = new CustomButtonField(rightString, CustomButtonField.TRIANGLE_RIGHT, Field.FOCUSABLE);
        btnRight.setChangeListener(this);
        vfm.add(btnRight);

        // Back button
        vfm.add(new RichTextField(Field.NON_FOCUSABLE));
        btnDown = new CustomButtonField(backString, CustomButtonField.TRIANGLE_DOWN, Field.FOCUSABLE);
        btnDown.setChangeListener(this);
        vfm.add(btnDown);
 
        mainScreen.add(vfm);
        
        // We've completed construction of our UI objects. Push the MainScreen
        // instance onto the UI stack for rendering.
        pushScreen(mainScreen);
        

	}
	

    public void fieldChanged(Field field, int context) 
    {
        String text = "Button";
        
        if (field instanceof CustomButtonField) {
            text = ((CustomButtonField)field).getText();
        }
        
        // Dialog.inform(text + " was clicked.");  
        
        if (text == fwdString) {
    		theRobot.playTone(0, 1000);
        }
        if (text == leftString) {
        	theRobot.playTone(4,1000);
        }
        if (text == rightString) {
        	theRobot.playTone(6, 1000);
        }
        if (text == backString) {
        	theRobot.playTone(8, 1000);
        }
        
    }
    
    
    private class RobotMainScreen extends MainScreen {
    	public RobotMainScreen() {
    		setTitle("Robot Main Screen");
    	}
    }
    
    
    
}
