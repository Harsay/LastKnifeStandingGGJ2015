package com.ggj2015.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.ggj2015.Assets;
import com.ggj2015.MyGame;
import com.ggj2015.view.Renderer;

public class Level {

	private List<Player> players;
	
	public int[] playerWins = { 0, 0, 0, 0 };
	
	private float width;
	private float height;
	
	private Knife knife;
	
	public int deadCount = 0;
	public int winner = 0;
	public int countdown = 4;
	public boolean finished = false;
	public int playerCount = 0;
	
	public int maxSpawns = 11; // max 10 games (11 = 10 lel)
	
	public GameColors gameColors;
	public BackgroundText bgText;
	
	public Level(int playerCount){
		players = new ArrayList<Player>();
		
		width = MyGame.WIDTH;
		height = MyGame.HEIGHT;
		this.playerCount = playerCount;
		
		gameColors = new GameColors();
		bgText = new BackgroundText();	
	}
	
	public void spawnKnife() {
		knife = new Knife(width / 2-45, height / 2-45);
	}
	
	public void spawnPlayers() {
		deadCount = 0;
		maxSpawns--;
		players.clear();
		for(int i = 0; i < playerCount; i++){	
			Player player = null;
			if(i == 0) player = new Player(0, 0, i+1);
			else if(i == 1) player = new Player(0, height, i+1);
			else if(i == 2) player = new Player(width, 0, i+1);
			else if(i == 3) player = new Player(width, height, i+1);
			players.add(player);
		}
		countdown = 4;
		Timer.schedule(new Task() {

			@Override
			public void run() {
				countdown--;
				bgText.text = ""+countdown;
				if(countdown == 0) {
					bgText.text = "what do\nwe do now";
					Renderer.glow(0.1f);
					Assets.start.play();
				} else {
					Assets.beep.play();
				}
			}
			
		}, 0, 1.0f, countdown-1);
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
