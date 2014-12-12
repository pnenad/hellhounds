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

public static void main(String[] argv){ }

public void pauseThread() throws InterruptedException {	this.running = false; }

public synchronized void resumeThread(){ this.running = true; notify(); }

private boolean isRunning(){ return this.running; }

public int getSerialNo(){ return this.id;}

@Override
public void run(){

	System.out.println("This is thread nr: " + id);
	while(running){
		try{
			System.out.println("Thread nr. " + id + " is running");
			Thread.sleep(3000);
			synchronized(this) {
            			while(!running) {
               				wait();
            			}
			}
		} catch (InterruptedException e) {
         		System.out.println("Thread " + id + " interrupted.");
     		}
	}
}
}
