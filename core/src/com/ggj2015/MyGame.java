package com.ggj2015;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGame extends Game {

	private GameEngine engine;
	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	
	public static float WIDTH = 800;
	public static float HEIGHT = 600;
	
	@Override
	public void create() {
		Assets.loadGraphics();
		engine = new GameEngine();
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
	}
	
	@Override
	public void render(){
		
		engine.update(Gdx.graphics.getDeltaTime());
		
		engine.render(batch, shapeRenderer);
		
	}

	
	
}
