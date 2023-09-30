package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.pacmanGame;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GamingConsole game() {
		var game = new pacmanGame(); //1: object creation
		return game;
	}

			
	@Bean
	public GameRunner gamerunner(GamingConsole game) {
		var gameRunner = new GameRunner(game); //1: object creation
		return gameRunner;
	}		

}
