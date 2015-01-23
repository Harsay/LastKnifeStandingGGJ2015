package com.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {
	
	public static Sprite playerSprite;
	public static Sprite knifeSprite;
	
	public static void loadGraphics() {
		playerSprite = new Sprite(new Texture(Gdx.files.internal("player.png")));
		knifeSprite = new Sprite(new Texture(Gdx.files.internal("knife.png")));
	}

}
