package com.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ggj2015.controller.Controller;
import com.ggj2015.model.Level;
import com.ggj2015.view.Renderer;

public class GameEngine {

	private Level level;
	
	private Controller controller;
	private Renderer renderer;
	
	private int[][] keysets = {{Keys.UP, Keys.RIGHT, Keys.DOWN, Keys.LEFT, Keys.N, Keys.M},
			{Keys.W, Keys.D, Keys.S, Keys.A, Keys.J, Keys.K}};
	
	public GameEngine(){
		level = new Level(4);
		
		controller = new Controller(level);
		renderer = new Renderer(level);
	}
	
	
	public void update(float delta){

		for(int j = 0; j < keysets.length; j++){
			boolean[] boolset = new boolean[6];
			
			for(int i = 0; i < keysets[j].length; i++){
				if(Gdx.input.isKeyPressed(keysets[j][i])){
					boolset[i] = true;
				}
			}
			controller.action(j, boolset);
		}
		
		controller.update(delta);
	}
	
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer){
		renderer.render(batch, shapeRenderer);
	}
	
	
}
