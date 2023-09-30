package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole{

		public void up() {
			System.out.println("right");
		}
		
		public void down() {
			System.out.println("left");
		}
		
		public void left() {
			System.out.println("up");
		}
		
		public void right() {
			System.out.println("down");
		}
}
