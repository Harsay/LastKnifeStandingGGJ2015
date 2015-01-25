package com.ggj2015;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Assets {
	
	public static TextureRegion[] playerWalkingRight = new TextureRegion[3];
	public static TextureRegion[] playerWalkingLeft = new TextureRegion[3];
	public static TextureRegion[] playerWalkingRightWithKnife = new TextureRegion[4];
	public static TextureRegion[] playerWalkingLeftWithKnife = new TextureRegion[4];
	
	public static TextureRegion playerStabbedRight;
	public static TextureRegion playerDeadRight;
	public static TextureRegion playerStabbedLeft;
	public static TextureRegion playerDeadLeft;
	
	public static Texture knifeTexture;
	public static BitmapFont font;
	public static BitmapFont fontSmall;
	public static BitmapFont fontSmaller;
	public static BitmapFont fontMoreSmaller;

	public static Animation walkingRightAnim;
	public static Animation walkingLeftAnim;
	public static Animation walkingRightWithKnifeAnim;
	public static Animation walkingLeftWithKnifeAnim;
	
	public static Sound beep;
	public static Sound hit;
	public static Sound pickup;
	public static Sound start;
	public static Sound throwKnife;
	
	public static TextureRegion pointer;
	
	public static Sound getSound(String name) {
		return Gdx.audio.newSound(Gdx.files.internal(name+".wav"));
	}
	
	public static void loadGraphics() {
		
		pointer = loadTexture("znacznik");
		
		beep = getSound("beep");
		hit = getSound("hit");
		pickup = getSound("pickup");
		start = getSound("start");
		throwKnife = getSound("throw");
		
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

		
		playerStabbedRight = loadTexture("ded");
		playerDeadRight = loadTexture("ded-wok");

		playerStabbedLeft = loadTexture("ded");
		playerStabbedLeft.flip(true, false);
		playerDeadLeft = loadTexture("ded-wok");
		playerDeadLeft.flip(true, false);
		
		knifeTexture = new Texture(Gdx.files.internal("knife.png"));
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("8-BIT WONDER.TTF"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 64;
		font = generator.generateFont(parameter);
		parameter.size = 48;
		fontSmall = generator.generateFont(parameter);
		parameter.size = 24;
		fontSmaller = generator.generateFont(parameter);
		parameter.size = 12;
		fontMoreSmaller = generator.generateFont(parameter);
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
