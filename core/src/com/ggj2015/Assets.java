package com.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Assets {
	
	public static Texture playerTexture;
	public static TextureRegion playerAlive;
	public static TextureRegion playerStabbed;
	public static TextureRegion playerDead;
	public static Texture knifeTexture;
	public static BitmapFont font;
	
	public static void loadGraphics() {
		playerTexture = new Texture(Gdx.files.internal("player.png"));
		playerAlive = new TextureRegion(playerTexture, 0, 0, 80, 120);
		playerStabbed = new TextureRegion(playerTexture, 80, 0, 80, 120);
		playerDead = new TextureRegion(playerTexture, 160, 0, 80, 120);

		knifeTexture = new Texture(Gdx.files.internal("knife.png"));
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("8-BIT WONDER.TTF"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 36;
		font = generator.generateFont(parameter);
		generator.dispose();
	}

}
