package com.ggj2015.model;

import java.util.ArrayList;
import java.util.List;

import com.ggj2015.MyGame;

public class Level {

	private List<Player> players;
	
	private float width;
	private float height;
	
	private Knife knife;
	
	public Level(int playerCount){
		players = new ArrayList<Player>();
		
		width = MyGame.WIDTH;
		height = MyGame.HEIGHT;
				
		for(int i = 0; i < playerCount; i++){	
			Player player = null;
			if(i == 0) player = new Player(0, 0);
			else if(i == 1) player = new Player(0, height);
			else if(i == 2) player = new Player(width, 0);
			else if(i == 3) player = new Player(width, height);
			players.add(player);
		}

		knife = new Knife(width / 2, height / 2);
		knife.setOwner(players.get(0));
		
	}
	
	public Knife getKnife(){
		return knife;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	
	
	
	
}
