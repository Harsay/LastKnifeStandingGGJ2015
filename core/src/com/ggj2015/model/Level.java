package com.ggj2015.model;

import java.util.ArrayList;
import java.util.List;

import com.ggj2015.MyGame;

public class Level {

	private List<Player> players;
	
	private float width;
	private float height;
	
	public Level(int playerCount){

		players = new ArrayList<Player>();
		
		width = MyGame.WIDTH;
		height = MyGame.HEIGHT;
		
		float offPlayerX = 128;
		
		for(int i = 0; i < playerCount; i++){			
			players.add(new Player(offPlayerX + 128, 128));
			offPlayerX += 80;
		}
		
		
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	
	
	
}
