package com.ggj2015.model;

import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ggj2015.Assets;
import com.ggj2015.MyGame;

public class BackgroundText {
	
	public String text = "";
	
	public BackgroundText() {
		
	}
	
	public void draw(SpriteBatch batch) {
		TextBounds bounds = Assets.fontSmall.getMultiLineBounds(text);
		Assets.fontSmall.drawMultiLine(batch, text, MyGame.WIDTH/2-bounds.width/2, MyGame.HEIGHT/2+bounds.height/2);		
	}

}
