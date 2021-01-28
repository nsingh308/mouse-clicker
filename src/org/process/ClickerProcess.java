package org.process;

import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * 
 * @author navdeep.singh.kanwal
 * @email: navdeep.singh.kanwal@gmail.com
 *
 */
public class ClickerProcess implements Runnable {

	private boolean exit;
	private int delay = 1000;
	private int xCordinates;
	private int yCordinates;
	private boolean isMoveOnly, isClickOnly, isCickAndMove, isExpiresAfter,isRandomization  ;
	private int occurences;
	private int startRandom;
	private int endRandom;
	private String name;
	Thread t;

	public ClickerProcess(String threadname, int xCordinates, int yCordinates, int delay, 
			boolean isMoveOnly, boolean isClickOnly, boolean isCickAndMove,
			boolean isExpiresAfter, int occurences, boolean isRandomization, int startRandom, int endRandom) {
		name = threadname;
		this.xCordinates = xCordinates;
		this.yCordinates = yCordinates;
		this.delay = delay;
		this.isMoveOnly = isMoveOnly;
		this.isClickOnly = isClickOnly;
		this.isCickAndMove = isCickAndMove;
		this.isExpiresAfter = isExpiresAfter;
		this.isRandomization = isRandomization;
		this.occurences = occurences;
		this.startRandom = startRandom;
		this.endRandom = endRandom;
		
		
		t = new Thread(this, name);
		System.out.println("New thread: " + t);
		exit = false;
		t.start(); // Starting the thread
	}

	@Override
	public void run() {
		int i = 0;
		while (!exit) {
			System.out.println(name + ": " + i);
			try {
				
				if(isClickOnly) {
					executeMouseClick();
				}else if(isMoveOnly) {
					executeMouseMove();
				}else if(isCickAndMove)  {
					if(i==0) {
						executeMouseClick();
					}else {
						executeMouseMove();
					}
				}
				Thread.sleep(this.delay);
			} catch (InterruptedException e) {
				System.out.println("Caught:" + e);
			}
			i++;
			
			if(isExpiresAfter && occurences == i) {
				exit = true;
			}
		}
		System.out.println(name + " Stopped.");
	}

	
	
	
	private int generateRandomBetween(int min, int max) {
		// define the range

		int range = max - min + 1;
		// generate random numbers within 1 to 10
		int rand = (int) (Math.random() * range) + min;
		// Output is different everytime this code is executed
		return rand;
	}

	private void executeMouseClick() {
		int xCord = xCordinates;
		int yCord = yCordinates;
		if(isRandomization) {
			int mathRandomGenerated = generateRandomBetween(startRandom, endRandom);
			System.out.println("Math Generated Random"+ mathRandomGenerated);
			xCord += mathRandomGenerated;
			yCord += mathRandomGenerated;
		}
		Robot bot = null;
		try {
			bot = new Robot();
		} catch (Exception failed) {
			System.err.println("Failed instantiating Robot: " + failed);
		}
		int mask = InputEvent.BUTTON1_DOWN_MASK;
		System.out.println("xCord:"+ xCord+" yCord: "+yCord);
		bot.mouseMove(xCord, yCord);
		bot.mousePress(mask);
		bot.mouseRelease(mask);
	}

	private void executeMouseMove() {
		int xCord = xCordinates;
		int yCord = yCordinates;
		if(isRandomization) {
			int mathRandomGenerated = generateRandomBetween(startRandom, endRandom);
			System.out.println("Math Generated Random"+ mathRandomGenerated);
			xCord += mathRandomGenerated;
			yCord += mathRandomGenerated;
		}
		
		Robot bot = null;
		try {
			bot = new Robot();
		} catch (Exception failed) {
			System.err.println("Failed instantiating Robot: " + failed);
		}
		System.out.println("xCord:"+ xCord+" yCord "+yCord);
		bot.mouseMove(xCord, yCord);
	}

	// for stopping the thread
	public void stop() {
		exit = true;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

}
