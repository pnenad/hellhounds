package src.com.hellhounds.battlefree.server;

import java.net.*;
import src.com.hellhounds.battlefree.util.*;

public class Client{

	private int status; //0=idle, 1=ready, 2=connected
	private Socket s;
	public Client(Socket s){
		this.s = s;
		status = 0;
	}
	public static void main(String[] args){
		//to do code
	}

	private void readJsonString(Socket s){
		//to do code
		//if Json string is corrupted return error - try again or something like that
		//else check database for credentials with Json ID?
	}

	private void checkCredentials(int id){
		//if it exists login user
		//else offer registration
	}

	private void registerUser(){
		//register user with Json data
		//call login mathod
	}

	private void login(){
		//logg user in with Json credentials
		//change status to ready
		//offer to play or create
	}

	public void play(){
		//select first available played and match them together
	}

	public void create(int id){
		//invite a friend from friends list and create a match
	}


}
