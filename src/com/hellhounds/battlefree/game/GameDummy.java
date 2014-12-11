package com.hellhounds.battlefree.game;

/**
 * Created by furai on 09.12.14.
 */
public class GameDummy extends Thread {

Integer id;
private volatile boolean running;

public GameDummy(Integer id){
	this.id = id;
	running = true;
}

public static void main(String[] argv){
}

public void pauseThread() throws InterruptedException {
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
	while(running){
			System.out.println("Thread nr. " + id + " is running");
		}
	}
}

