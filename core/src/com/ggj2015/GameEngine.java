package com.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ggj2015.controller.Controller;
import com.ggj2015.model.Level;
import com.ggj2015.view.Renderer;

public class GameEngine {

	private Level level;
	
	private Controller controller;
	private Renderer renderer;
	
	private int[][] keysets = {{Keys.UP, Keys.RIGHT, Keys.DOWN, Keys.LEFT, Keys.NUM_1, Keys.NUM_2},
								{Keys.W, Keys.E, Keys.S, Keys.A, Keys.J, Keys.K}};
	
	public GameEngine(){
		level = new Level(4);
		
		controller = new Controller(level);
		renderer = new Renderer(level);
	}
	
	
	public void update(float delta){

		for(int i = 0; i < keysets.length; i++){
			
		}
		
		controller.update(delta);
	}
	
	public void render(SpriteBatch batch){
		renderer.render(batch);
	}
	
	
}
