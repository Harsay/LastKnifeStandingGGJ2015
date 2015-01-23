package com.ggj2015.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ggj2015.MyGame;
import com.ggj2015.model.Level;
import com.ggj2015.model.Player;

public class Renderer {
	
	private Level level;
	private OrthographicCamera camera;

	public Renderer(Level level){
		this.level = level;
		camera = new OrthographicCamera(MyGame.WIDTH, MyGame.HEIGHT);
		camera.setToOrtho(false);
	}
	
	public void render(SpriteBatch batch){
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(Player p : level.getPlayers()) {
			p.getSprite().draw(batch);
		}
		batch.end();
		
	}
	
}
