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
