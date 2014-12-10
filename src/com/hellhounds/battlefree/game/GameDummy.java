package com.hellhounds.battlefree.game;

/**
 * Created by furai on 09.12.14.
 */
public class GameDummy implements Runnable {

	Long l;
	public boolean suspended;

  	public GameDummy(Long l){
        	this.l = l;
		suspended = false;
    	}

	public static void main(String[] argv){
	}

    	@Override
	public void run(){
		System.out.println("This is thread nr: " + l);
		try{ Thread.sleep(3000); } catch (Exception e) { e.printStackTrace(); }
	}
}
