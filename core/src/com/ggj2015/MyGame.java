package com.ggj2015;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends Game {

	private GameEngine engine;
	private SpriteBatch batch;
	
	
	@Override
	public void create() {
		System.out.println("");
		
		engine = new GameEngine();
		batch = new SpriteBatch();
	}
	
	@Override
	public void render(){
		
		engine.update(Gdx.graphics.getDeltaTime());
		
		engine.render(batch);
		
	}

	
	
}
