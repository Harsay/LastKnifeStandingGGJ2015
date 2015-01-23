package com.ggj2015.model;

import com.ggj2015.MyGame;

public class Level {

	private Player player;
	
	private float width;
	private float height;
	
	public Level(){
		player = new Player(0, 0);
		width = MyGame.WIDTH;
		height = MyGame.HEIGHT;
	}
	
	
	
	
}
