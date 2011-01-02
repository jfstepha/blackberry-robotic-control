/**
 * 
 */
package com.mycompany;

import java.io.IOException;

import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;

import net.rim.device.api.ui.component.Dialog;

/**
 * @author jfstepha
 *
 */
public class RobotBerryAPI {

	/**
	 * @param args
	 */
	
	private static String filenamebase = "file:///SDCard/";
	private static String[] tonefilename = {
		"0.wav", "1.wav", "2.wav", "3.wav", "4.wav",
		"5.wav", "6.wav", "7.wav", "8.wav", "9.wav",
		"p.wav", // # = 10
		"s.wav"  // * = 11
};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public void playTone (int tone, int duration ){
    	// Dialog.inform("starting player stuff");


		try {
			Player p = javax.microedition.media.Manager.createPlayer(filenamebase + tonefilename[tone]);
			p.realize();
			VolumeControl volume = (VolumeControl)p.getControl("VolumeControl");
			volume.setLevel(30);
	    
			p.prefetch();
			p.start();
			while (p.getState() == p.STARTED) {

			}
			p.deallocate();
		}
		
		catch(MediaException me)
		{
		    Dialog.alert("Media Exception on player creation: " +me.toString());
			
		}
		catch(IOException ioe)
		{
			Dialog.alert("IO Exception on player creation: " + ioe.toString());
		}
	}
}
