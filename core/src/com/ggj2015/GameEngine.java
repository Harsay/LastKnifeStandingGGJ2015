package com.ggj2015;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ggj2015.controller.Controller;
import com.ggj2015.model.Level;
import com.ggj2015.view.Renderer;

public class GameEngine {

	private Level level;
	
	private Controller controller;
	private Renderer renderer;
	
	public GameEngine(){
		level = new Level();
		
		controller = new Controller(level);
		renderer = new Renderer(level);
	}
	
	
	public void update(float delta){
		controller.update(delta);
	}
	
	public void render(SpriteBatch batch){
		renderer.render(batch);
	}
	
	
}
