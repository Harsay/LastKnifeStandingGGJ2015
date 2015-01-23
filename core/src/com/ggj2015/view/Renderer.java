package com.ggj2015.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ggj2015.MyGame;
import com.ggj2015.model.Level;
import com.ggj2015.model.Player;

public class Renderer {
	
	private Level level;
	private OrthographicCamera camera;
	private Viewport viewport;

	public Renderer(Level level){
		this.level = level;
		camera = new OrthographicCamera();
		viewport = new FitViewport(MyGame.WIDTH, MyGame.HEIGHT, camera);
		camera.setToOrtho(false, MyGame.WIDTH, MyGame.HEIGHT);
	}
	
	public void render(SpriteBatch batch){
		camera.update();
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);  
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(Player p : level.getPlayers()) {
			p.getSprite().draw(batch);
		}
		batch.end();
		
	}
	
}
