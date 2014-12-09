package com.hellhounds.battlefree.game;

/**
 * Created by furai on 09.12.14.
 */
public class GameDummy implements Runnable {

    Long l;

    public GameDummy(Long l){
        this.l = l;
    }

    @Override
    public void run() {
        System.out.println("This is object nr: " + l);
    }
}
