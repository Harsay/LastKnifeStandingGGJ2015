package com.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ggj2015.gamecontrollers.GameController;
import com.ggj2015.model.Level;
import com.ggj2015.view.Renderer;

public class GameEngine {

	private Level level;
	
	private GameController controller;
	private Renderer renderer;
	
	private int[][] keysets = {{Keys.UP, Keys.RIGHT, Keys.DOWN, Keys.LEFT, Keys.N, Keys.M},
			{Keys.W, Keys.D, Keys.S, Keys.A, Keys.J, Keys.K},
			{0, 0, 0, 0, 0, 1},
			{0, 0, 0, 0, 0, 1}			
	};
	
	private int[] keysetsType = {1, 1, 2, 0}; // 0 undef, 1 keyboard, 2 gamepad
	
	private boolean[][] gamePadsDpad = new boolean[4][4];
	
	public Controller[] gamePads = new Controller[4];
	
	public GameEngine(){
		
		for(int i=0; i<Controllers.getControllers().size; i++) {
			if(i+1 > gamePads.length) break;
			gamePads[i] = Controllers.getControllers().get(i);
			System.out.println("Added gamepad: "+gamePads[i].getName());
			gamePads[i].addListener(new CustomControllerAdapter(i) {
				@Override
				public boolean povMoved (Controller controller, int povIndex, PovDirection value) {
					for(int i=0; i<4; i++) gamePadsDpad[index][i] = false;
					if(value == PovDirection.north) gamePadsDpad[index][0] = true;
					else if(value == PovDirection.east) gamePadsDpad[index][1] = true;
					else if(value == PovDirection.south) gamePadsDpad[index][2] = true;
					else if(value == PovDirection.west) gamePadsDpad[index][3] = true;
					else if(value == PovDirection.northEast) {
						 gamePadsDpad[index][0] = true;
						 gamePadsDpad[index][1] = true;
					}
					else if(value == PovDirection.northWest) {
						gamePadsDpad[index][0] = true;
						gamePadsDpad[index][3] = true;
					}
					else if(value == PovDirection.southEast) {
						gamePadsDpad[index][1] = true;
						gamePadsDpad[index][2] = true;
					}
					else if(value == PovDirection.southWest) {
						gamePadsDpad[index][2] = true;
						gamePadsDpad[index][3] = true;
					}
					return false;
				}
			 });
		}
		
		level = new Level(4);
		
		controller = new GameController(level);
		renderer = new Renderer(level);
	}
	
	
	public void update(float delta){
		int gamePadsUpdated = 0;
		for(int j = 0; j < keysets.length; j++){
			boolean[] boolset = new boolean[6];
			
			
			if(keysetsType[j] == 1) {
				for(int i = 0; i < keysets[j].length; i++) boolset[i] = Gdx.input.isKeyPressed(keysets[j][i]);	
			}	
			else if(keysetsType[j] == 2) {
				Controller c = gamePads[gamePadsUpdated];
				boolean[] dpad = gamePadsDpad[gamePadsUpdated];
				for(int x=0; x<dpad.length; x++) boolset[x] = dpad[x];
				for(int x=4; x<boolset.length; x++) boolset[x] = c.getButton(keysets[j][x]);
				gamePadsUpdated++;
			}
			
			controller.action(j, boolset);
		}
		controller.update(delta);
	}
	
	public void render(SpriteBatch batch, ShapeRenderer shapeRenderer){
		renderer.render(batch, shapeRenderer);
	}
	
	
}
