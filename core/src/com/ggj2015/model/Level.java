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
		
		for(int i = 0; i < playerCount; i++){			
			players.add(new Player(i < 2 ? width / 4 + i * width / 2 : width / 4, i >= 2 ? height / 4 + (i-2) * height/2 : height / 4));
		}
		
		
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	
	
	
}
