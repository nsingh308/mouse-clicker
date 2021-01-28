package org.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.process.ClickerProcess;

/**
 * 
 * @author navdeep.singh.kanwal
 * @email: navdeep.singh.kanwal@gmail.com
 *
 */

public class MainEntryPoint {

	private JFrame frame;
	private JTextField xField;
	private JTextField yField;
	private JTextField delayField;
	private JTextField startRandomField;
	private JTextField endRandomField;
	private JTextField occurencesField;
	static ClickerProcess clicker;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainEntryPoint window = new MainEntryPoint();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainEntryPoint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		JMenuBar menuBar = new JMenuBar();

		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Script");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		frame.setTitle("Auto Mouse Clicker & Mover");
		frame.setBounds(100, 100, 504, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 488, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 25, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);

		JButton btnRun = new JButton("Run");

		
		JCheckBox chckbxMouseMoveOnly = new JCheckBox("Move Only");
		JCheckBox chckbxclickMove = new JCheckBox("Click & Move");
		JCheckBox chckbxClickOnly = new JCheckBox("Click Only");
		
		JButton btnStop = new JButton("Stop");

		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clicker.setExit(true);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(90).addComponent(btnRun)
						.addPreferredGap(ComponentPlacement.RELATED, 188, Short.MAX_VALUE).addComponent(btnStop)
						.addGap(104)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_2
						.createSequentialGroup().addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRun).addComponent(btnStop))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.WEST);

		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);

		JLabel lblXCordinate = new JLabel("X Cordinate:");

		xField = new JTextField();
		xField.setColumns(10);
		xField.setText("1600");
		JLabel lblYCordinate = new JLabel("Y Cordinate:");

		yField = new JTextField();
		yField.setColumns(10);
		yField.setText("400");
		JLabel lblDelay = new JLabel("Delay:");

		delayField = new JTextField();
		delayField.setColumns(10);
		delayField.setText("10000");
		JLabel lblinMs = new JLabel("(in ms)");
		chckbxMouseMoveOnly.setSelected(true);
		chckbxClickOnly.setEnabled(false);
		chckbxclickMove.setEnabled(false);
		chckbxMouseMoveOnly.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					chckbxClickOnly.setSelected(false);
					chckbxclickMove.setSelected(false);
					chckbxClickOnly.setEnabled(!chckbxMouseMoveOnly.isSelected());
					chckbxclickMove.setEnabled(!chckbxMouseMoveOnly.isSelected());
				
			}
		});

		chckbxClickOnly.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				chckbxMouseMoveOnly.setSelected(false);
				chckbxMouseMoveOnly.setEnabled(!chckbxClickOnly.isSelected());
				    
				    
				chckbxclickMove.setSelected(false);
				chckbxclickMove.setEnabled(!chckbxClickOnly.isSelected());
					
				
			}
		});

		chckbxclickMove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				chckbxMouseMoveOnly.setSelected(false);
				chckbxMouseMoveOnly.setEnabled(!chckbxclickMove.isSelected());
				    
				    
				chckbxClickOnly.setSelected(false);
				chckbxClickOnly.setEnabled(!chckbxclickMove.isSelected());
				
			}
		});

		JLabel lblStart = new JLabel("Start:");

		startRandomField = new JTextField();
		startRandomField.setColumns(10);

		JLabel lblEnd = new JLabel("End:");

		endRandomField = new JTextField();
		endRandomField.setColumns(10);
		startRandomField.setEnabled(false);
		endRandomField.setEnabled(false);
		
		
		JCheckBox chckbxEnableRandomization = new JCheckBox("Randomization");
		JCheckBox chckbxExpiresAfter = new JCheckBox("Expires After");

		chckbxEnableRandomization.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(chckbxEnableRandomization.isSelected()) {
					startRandomField.setEnabled(true);
					endRandomField.setEnabled(true);
				}else {
					startRandomField.setEnabled(false);
					endRandomField.setEnabled(false);
					startRandomField.setText("");
					endRandomField.setText("");
				}
				
					
				
			}
		});
		
		chckbxMouseMoveOnly.setToolTipText("No Click Even, It will only Move mouse");
		chckbxclickMove.setToolTipText("First Click and then Move Infinitely");

		JLabel lblOccurrences = new JLabel("Occurrences:");

		occurencesField = new JTextField();
		occurencesField.setColumns(10);
		occurencesField.setEnabled(false);
		chckbxExpiresAfter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(chckbxExpiresAfter.isSelected()) {
					occurencesField.setEnabled(true);
				}else {
					occurencesField.setEnabled(false);
					occurencesField.setText("");
				}
				
					
				
			}
		});
		
		
		btnRun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int xc = Integer.parseInt(xField.getText());
				int yc = Integer.parseInt(yField.getText());

				int df = Integer.parseInt(delayField.getText());
				int occurences = 0;
				int startRandom = 0;
				int endRandom = 0;
				if(chckbxExpiresAfter.isSelected()) {
					occurences = Integer.parseInt(occurencesField.getText());
				}
				
				if(chckbxEnableRandomization.isSelected()) {
					startRandom=Integer.parseInt(startRandomField.getText());
					endRandom=Integer.parseInt(endRandomField.getText());
				}
				
				clicker = new ClickerProcess("DummyThread", xc, yc, df, chckbxMouseMoveOnly.isEnabled(),
						chckbxClickOnly.isEnabled(), chckbxclickMove.isEnabled(), chckbxExpiresAfter.isSelected(),occurences, 
						chckbxEnableRandomization.isSelected(), startRandom, endRandom);

			}
		});

		
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4
				.createSequentialGroup().addGap(82)
				.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4.createSequentialGroup()
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addComponent(lblYCordinate)
								.addComponent(lblDelay))
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4
								.createSequentialGroup()
								.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_4.createSequentialGroup()
												.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
														.addComponent(startRandomField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(delayField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(endRandomField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(occurencesField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblinMs))
										.addComponent(xField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(
										gl_panel_4.createParallelGroup(Alignment.LEADING).addComponent(chckbxClickOnly)
												.addComponent(chckbxMouseMoveOnly).addComponent(chckbxclickMove)))
								.addComponent(yField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblOccurrences).addComponent(chckbxExpiresAfter).addComponent(lblEnd)
						.addComponent(lblStart).addComponent(chckbxEnableRandomization).addComponent(lblXCordinate))
				.addContainerGap(81, Short.MAX_VALUE)));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addGap(31)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(lblXCordinate)
								.addComponent(chckbxMouseMoveOnly).addComponent(xField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(lblYCordinate)
								.addComponent(yField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxclickMove))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addComponent(lblDelay)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
										.addComponent(delayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblinMs).addComponent(chckbxClickOnly)))
						.addGap(21).addComponent(chckbxEnableRandomization)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(lblStart)
								.addComponent(startRandomField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(lblEnd).addComponent(
								endRandomField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(29).addComponent(chckbxExpiresAfter).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(lblOccurrences)
								.addComponent(occurencesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(40, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);
	}
}
