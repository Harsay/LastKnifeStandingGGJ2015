package com.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Assets {
	
	public static TextureRegion[] playerWalkingRight = new TextureRegion[3];
	public static TextureRegion[] playerWalkingLeft = new TextureRegion[3];
	public static TextureRegion[] playerWalkingRightWithKnife = new TextureRegion[4];
	public static TextureRegion[] playerWalkingLeftWithKnife = new TextureRegion[4];
	
	public static TextureRegion playerStabbed;
	public static TextureRegion playerDead;
	
	public static Texture knifeTexture;
	public static BitmapFont font;
	
	public static Animation walkingRightAnim;
	public static Animation walkingLeftAnim;
	public static Animation walkingRightWithKnifeAnim;
	public static Animation walkingLeftWithKnifeAnim;
	
	public static void loadGraphics() {
		playerWalkingRight[0] = loadTexture("run_1");
		playerWalkingRight[1] = loadTexture("run_2");
		playerWalkingRight[2] = loadTexture("run_1");
		
		playerWalkingLeft[0] = loadTexture("run_1");
		playerWalkingLeft[0].flip(true, false);
		playerWalkingLeft[1] = loadTexture("run_2");
		playerWalkingLeft[1].flip(true, false);
		playerWalkingLeft[2] = loadTexture("run_1");
		playerWalkingLeft[2].flip(true, false);
		

		playerWalkingRightWithKnife[0] = loadTexture("run_1");
		playerWalkingRightWithKnife[1] = loadTexture("run_2_wk");
		playerWalkingRightWithKnife[2] = loadTexture("run_1");
		playerWalkingRightWithKnife[3] = loadTexture("run_3_wk");

		
		playerWalkingLeftWithKnife[0] = loadTexture("run_1");
		playerWalkingLeftWithKnife[0].flip(true, false);
		playerWalkingLeftWithKnife[1] = loadTexture("run_2_wk");
		playerWalkingLeftWithKnife[1].flip(true, false);
		playerWalkingLeftWithKnife[2] = loadTexture("run_1");
		playerWalkingLeftWithKnife[2].flip(true, false);
		playerWalkingLeftWithKnife[3] = loadTexture("run_3_wk");
		playerWalkingLeftWithKnife[3].flip(true, false);

		
		playerStabbed = loadTexture("ded");
		playerDead = loadTexture("ded-wok");

		knifeTexture = new Texture(Gdx.files.internal("knife.png"));
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("8-BIT WONDER.TTF"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 64;
		font = generator.generateFont(parameter);
		generator.dispose();
		
		walkingRightAnim = new Animation(0.08f, playerWalkingRight);
		walkingLeftAnim = new Animation(0.08f, playerWalkingLeft);
		walkingRightWithKnifeAnim = new Animation(0.1f, playerWalkingRightWithKnife);
		walkingLeftWithKnifeAnim = new Animation(0.1f, playerWalkingLeftWithKnife);
	}
	
	public static TextureRegion loadTexture(String name) {
		return new TextureRegion(new Texture(Gdx.files.internal(name+".png")));
	}

}
