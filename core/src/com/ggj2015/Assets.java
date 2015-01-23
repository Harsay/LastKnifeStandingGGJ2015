package com.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	
	public static Texture playerTexture;
	public static Texture knifeTexture;
	
	public static void loadGraphics() {
		playerTexture = new Texture(Gdx.files.internal("player.png"));
		knifeTexture = new Texture(Gdx.files.internal("knife.png"));
	}

}
