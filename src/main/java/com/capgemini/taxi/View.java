package com.capgemini.taxi;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;



public class View {
	private static City city;

	public static void main(String[] a) {
		JFrame window = new JFrame();
		/// City(USerLat,UserLong, MaxResult, MaxTaxiNumber, CurrentTaxiNumber)                  
		city = new City(50.4569,5.3242, 15, 1000, 800);
		final JTextArea result = new JTextArea();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30, 250, 300);
		window.getContentPane().add(result, BorderLayout.CENTER);
		window.setTitle("Nearest taxi");
		window.setVisible(true);		
	
	
		 Timer tim = new Timer();  // Create a Timer object
	     TimerTask reloadCity = new TimerTask(){
        // This is what we want the Timer to do once a second.
         public void run(){
        	 result.setText("");
        	 result.setText(city.getNearestTaxiResult());
        	 city.nextTickOfTime();
         }
     };

     tim.schedule(reloadCity, 1000, 5000);
 }
	
	
}
