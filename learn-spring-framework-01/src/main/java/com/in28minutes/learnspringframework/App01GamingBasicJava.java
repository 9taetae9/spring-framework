package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.*; 

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
		//var game = new MarioGame();
		//var game = new superContraGame();
		
		var game = new pacmanGame(); //1: object creation
		
		var gameRunner = new GameRunner(game); 
		//2: object creation + wiring of dependencies
		//Game is a Dependency of GameRunner
		
		gameRunner.run();
	 
	}
}
