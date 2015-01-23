package com.ggj2015.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ggj2015.Assets;

public class Player {

	private Sprite sprite;
	
	private float x;
	private float y;
	private float velX = 0;
	private float velY = 0;
	private int dir = 0;
	
	private float width = 80;
	private float height = 120;
	
	public Player(float x, float y) {
		this.x = x;
		this.y = y;
		sprite = new Sprite(Assets.playerTexture);
	}
	
	
	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
	
}
