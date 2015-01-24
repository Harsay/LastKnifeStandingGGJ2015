package com.ggj2015.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ggj2015.Assets;
import com.ggj2015.MyGame;
import com.ggj2015.model.GameColors;
import com.ggj2015.model.Level;
import com.ggj2015.model.Player;

public class Renderer {
	
	private Level level;
	private OrthographicCamera camera;
	private Viewport viewport;
	private GameColors gameColors;


	public Renderer(Level level){
		this.level = level;
		camera = new OrthographicCamera();
		viewport = new FitViewport(MyGame.WIDTH, MyGame.HEIGHT, camera);
		camera.setToOrtho(false, MyGame.WIDTH, MyGame.HEIGHT);
		gameColors = level.gameColors;
	}
	
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer){
		camera.update();
		viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); 
        
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(gameColors.getBgColor());
        shapeRenderer.rect(0, 0, level.getWidth(), level.getHeight());
        shapeRenderer.end();
        
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if(level.finished) {
			Assets.font.setColor(gameColors.getTxtColor());
			TextBounds bounds = Assets.font.getBounds("Player "+level.winner+" wins");
			Assets.font.draw(batch, "Player "+level.winner+" wins", MyGame.WIDTH/2-bounds.width/2, MyGame.HEIGHT/2+bounds.height/2);
		}
		for(Player p : level.getPlayers()) {
			p.getSprite().setColor(gameColors.getPlrColor());
			p.getSprite().draw(batch);
		}
		if(level.getKnife() != null && level.getKnife().getOwner() == null){
			level.getKnife().getSprite().setColor(gameColors.getPlrColor());
			level.getKnife().getSprite().draw(batch);
		}
		batch.end();
	}
	
	public static Color createColor(int r, int g, int b, int a) {
		return new Color((float) r/255, (float) g/255, (float) b/255, (float) a/255);
	}
	
}
