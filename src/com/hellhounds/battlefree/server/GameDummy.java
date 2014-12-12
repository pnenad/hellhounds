/**
 * Copyright 2014 Endre Koekebakker, Espen Strømland,
 *                Nenad Petkovic, Steven Hicks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hellhounds.battlefree.server;

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
