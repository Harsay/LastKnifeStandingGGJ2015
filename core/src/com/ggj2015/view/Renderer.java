package com.ggj2015.view;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ggj2015.Assets;
import com.ggj2015.MyGame;
import com.ggj2015.model.BackgroundText;
import com.ggj2015.model.GameColors;
import com.ggj2015.model.Level;
import com.ggj2015.model.Player;

public class Renderer {
	
	private Level level;
	private OrthographicCamera camera;
	private Viewport viewport;
	private GameColors gameColors;
	private BackgroundText bgText;
	private static Color foregroundColor;
	
	private Sprite menuSprite;
	
	private static boolean shaking = false;

	Random rand = new Random();

	public Renderer(Level level){
		this.level = level;
		camera = new OrthographicCamera();
		viewport = new FitViewport(MyGame.WIDTH, MyGame.HEIGHT, camera);
		camera.setToOrtho(false, MyGame.WIDTH, MyGame.HEIGHT);
		gameColors = level.gameColors;
		bgText = level.bgText;
		foregroundColor = new Color(1, 1, 1, 0);
		menuSprite = new Sprite(Assets.knifeTexture);
		glow(0.3f);
	}
	
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer){
		
		if(shaking) {
			camera.position.x =  MyGame.WIDTH/2+rand.nextFloat()*20f*(rand.nextInt(3) - 1);
			camera.position.y =  MyGame.HEIGHT/2+rand.nextFloat()*20f*(rand.nextInt(3) - 1);
		} 
		else {
			camera.position.x = MyGame.WIDTH/2;
			camera.position.y = MyGame.HEIGHT/2;
		}
		
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
		if(MyGame.menu) {
			menuSprite.setColor(gameColors.getPlrColor());
			menuSprite.setScale(15);
			menuSprite.setPosition(500, 100);
			menuSprite.rotate(60*Gdx.graphics.getDeltaTime());
			menuSprite.draw(batch);
			Assets.font.setColor(gameColors.getTxtColor());
			TextBounds bounds = Assets.font.getBounds("the last");
			Assets.font.draw(batch, "the last", MyGame.WIDTH/2-bounds.width/2, 500);
			bounds = Assets.font.getBounds("knife");
			Assets.font.draw(batch, "knife", MyGame.WIDTH/2-bounds.width/2, 400);
			bounds = Assets.font.getBounds("standing");
			Assets.font.draw(batch, "standing", MyGame.WIDTH/2-bounds.width/2, 300);
			Assets.fontSmaller.setColor(1, 1, 1, 1);
			Assets.fontSmaller.draw(batch, "PRESS ENTER TO START", 175, 100);
		}
		else {
			if(level.maxSpawns > 0) Assets.fontSmall.setColor(gameColors.getTxtColor());
			else Assets.fontSmall.setColor(Color.WHITE);
			bgText.draw(batch);
			if(level.maxSpawns > 0) {
				for(Player p : level.getPlayers()) {
					p.getSprite().setColor(gameColors.getPlrColor());
					Sprite pointerSprite = new Sprite(Assets.pointer);
					pointerSprite.setPosition(p.getCenterX()-pointerSprite.getWidth()/2, p.getCenterY()+p.getHeight()/2);
					pointerSprite.setColor(gameColors.getPlrColor());
					pointerSprite.draw(batch);
					String todraw = "";
					if(p.alive && level.getKnife().getOwner() == p) todraw = "K";
					else todraw = ""+p.number;
					TextBounds bounds = Assets.fontMoreSmaller.getBounds(todraw);
					Assets.fontMoreSmaller.draw(batch, todraw, pointerSprite.getX()+pointerSprite.getWidth()/2-bounds.width/2, pointerSprite.getY()+bounds.height+10);
					p.getSprite().draw(batch);
					
				}
				if(level.getKnife() != null && level.getKnife().getOwner() == null){
					level.getKnife().getSprite().setColor(gameColors.getPlrColor());
					level.getKnife().getSprite().draw(batch);
				}
			}
		}
		batch.end();
		
		if(level.maxSpawns > 0) {
			Gdx.gl.glEnable(GL20.GL_BLEND);
		    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	        shapeRenderer.begin(ShapeType.Filled);
	        shapeRenderer.setColor(foregroundColor);
	        shapeRenderer.rect(0, 0, level.getWidth(), level.getHeight());
	        shapeRenderer.end();
		    Gdx.gl.glDisable(GL20.GL_BLEND);
		}

	}
	
	public static void glow(float t) {
		foregroundColor.a = 1;
		Timer.schedule(new Task() {

			@Override
			public void run() {
				foregroundColor.a = 0;
			}
			
		}, t);
	}
	
	public static void shake() {
		shaking = true;
		Timer.schedule(new Task() {

			@Override
			public void run() {
				shaking = false;
			}
			
		}, 0.3f);
	}
	
	public static Color createColor(int r, int g, int b, int a) {
		return new Color((float) r/255, (float) g/255, (float) b/255, (float) a/255);
	}
	
}
