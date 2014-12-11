package com.hellhounds.battlefree.server;

/**
 * Created by furai on 09.12.14.
 */
public class GameDummy extends Thread {

Long id;
private boolean running;

public GameDummy(Long id){
       	this.id = id;
	running = true;
}

public static void main(String[] argv){
}

public void pauseThread(){
	this.running = false;
}

public void resumeThread(){
	this.running = true;
}

private boolean isRunning(){
	return this.running;
}

@Override
public void run(){
	System.out.println("This is thread nr: " + id);
	try{ Thread.sleep(3000); } catch (Exception e) { e.printStackTrace();}
	while(this.isRunning()){
		try{
			Thread.sleep(5000);
			System.out.println("...still running...");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
}
