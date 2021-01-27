package org.process;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class ClickerProcess implements Runnable{

    private boolean exit; 
    private int delay=1000;
    private int xCordinates;
    private int yCordinates;
    
    
    private String name; 
    Thread t; 
  

	public ClickerProcess(String threadname, int xCordinates, int yCordinates, int delay) 
    { 
        name = threadname;
        this.xCordinates = xCordinates;
        this.yCordinates = yCordinates;
        this.delay = delay;
        t = new Thread(this, name); 
        System.out.println("New thread: " + t); 
        exit = false; 
        t.start(); // Starting the thread 
    } 
    
    
	@Override
	public void run() {
		// 
		int i = 0; 
        while (!exit) { 
            System.out.println(name + ": " + i); 
            i++; 
            try { 
            	executeMouseClick(this.xCordinates, this.yCordinates);
                Thread.sleep(this.delay); 
            } 
            catch (InterruptedException e) { 
                System.out.println("Caught:" + e); 
            } 
        } 
        System.out.println(name + " Stopped."); 
	}
	
	private void executeMouseClick(int xCord, int yCord) {
		Robot bot = null;
		  try {
		   bot = new Robot();
		  } catch (Exception failed) {
		   System.err.println("Failed instantiating Robot: " + failed);
		  }
		  int mask = InputEvent.BUTTON1_DOWN_MASK;
		  bot.mouseMove(xCord, yCord);
		  bot.mousePress(mask);
		  bot.mouseRelease(mask);
	}
	
	// for stopping the thread 
    public void stop() 
    { 
        exit = true; 
    } 
    
    
    public boolean isExit() {
		return exit;
	}


	public void setExit(boolean exit) {
		this.exit = exit;
	}

}
