package org.ui;

import javax.swing.*;

import org.process.ClickerProcess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryPoint{
	
	static ClickerProcess clicker;
	
	public static void main(String arg[]) {
		//Creating the Frame
        JFrame frame = new JFrame("Auto Mouse Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 150);
        
      //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);

        //Creating the panel at bottom and adding components
        JPanel inputPanel = new JPanel(); // the panel is not visible in output
        JLabel xLabel = new JLabel("X Coordinates");
        JTextField xCord = new JTextField(10); // accepts upto 10 characters
        xCord.setText("1900");
        JLabel yLabel = new JLabel("X Coordinates");
        JTextField yCord = new JTextField(10); // accepts upto 10 characters
        yCord.setText("400");
        JLabel dLabel = new JLabel("Delay(ms)");
        JTextField delayField = new JTextField(10);
        delayField.setText("10000");
        
        
        inputPanel.add(xLabel); // Components Added using Flow Layout
        inputPanel.add(xCord);
        inputPanel.add(yLabel); // Components Added using Flow Layout
        inputPanel.add(yCord);
        inputPanel.add(dLabel); // Components Added using Flow Layout
        inputPanel.add(delayField);
        
        JPanel controlPanel = new JPanel();
        JButton run = new JButton("Run");
        JButton stop = new JButton("Stop");
        
        run.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int xc = Integer.parseInt(xCord.getText());
				int yc = Integer.parseInt(yCord.getText());
				int df = Integer.parseInt(delayField.getText());
				clicker = new ClickerProcess("DummyThread", xc, yc, df);
				
			}
		});
        
        stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clicker.setExit(true);
			}
		});
        
        controlPanel.add(run);
        controlPanel.add(stop);
        
      //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, controlPanel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, inputPanel);
        frame.setVisible(true);
	}
}