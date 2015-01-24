package com.ggj2015.model;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;

public class GameColors {
	
	public Color[] backgroundColors = new Color[4];
	public Color[] textColors = new Color[4];
	public Color[] playerColors = new Color[4];
	
	public int pointer = 0;
	
	Random random = new Random();
	
	public GameColors() {
		backgroundColors[0] = createColor(127,30,3, 255);
		backgroundColors[1] = createColor(48, 127, 3, 255);
		backgroundColors[2] = createColor(0, 83, 127, 255);
		backgroundColors[3] = createColor(127, 3, 80, 255);
		textColors[0] = createColor(204, 49, 5, 255);
		textColors[1] = createColor(76, 204, 5, 255);
		textColors[2] = createColor(46, 99, 127, 255);
		textColors[3] = createColor(127, 49, 97, 255);
		playerColors[0] = createColor(255, 61, 7, 255);
		playerColors[1] = createColor(144, 255, 83, 255);
		playerColors[2] = createColor(0, 167, 255, 255);
		playerColors[3] = createColor(255, 83, 189, 255);
		setColors();
	}
	
	public void setColors() {
		pointer = random.nextInt(playerColors.length);
	}
	
	public Color getBgColor() {
		return backgroundColors[pointer];
	}
	
	public Color getTxtColor() {
		return textColors[pointer];
	}
	
	public Color getPlrColor() {
		return playerColors[pointer];
	}
	
	public Color createColor(int r, int g, int b, int a) {
		return new Color((float) r/255, (float) g/255, (float) b/255, (float) a/255);
	}
	

}
