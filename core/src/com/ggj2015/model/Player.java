package com.ggj2015.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.ggj2015.Assets;

public class Player {

	private Sprite sprite;
	public Animation animation;
	public float animTime;
	
	private float x;
	private float y;
	private float velX = 0;
	private float velY = 0;
	private int dir = 0;
	
	public int number = 0;
	
	public boolean alive = true;
	public boolean throwing = false;
	public boolean tryingToPickUp = false;
	public boolean deadLeft = false;
	
	private float width = 80;
	private float height = 120;
	
	public Player(float x, float y, int number) {
		this.x = x;
		this.y = y;
		this.number = number;
		animation = new Animation(0.08f, Assets.playerWalkingRight);
		sprite = new Sprite(Assets.playerWalkingRight[0]);
		sprite.setPosition(x, y);	
	}
	
	public boolean collides(Knife knife) {
		Rectangle playerRect = new Rectangle(x, y, width, height);
		Rectangle knifeRect = new Rectangle(knife.getX(), knife.getY(), knife.getWidth(), knife.getHeight());
		if(playerRect.overlaps(knifeRect)) return !throwing;
		else throwing = false;
		return false;
	}
	
	public boolean collides(Player other) {
		Rectangle playerRect = new Rectangle(x, y, width, height);
		Rectangle otherRect = new Rectangle(other.getX(), other.getY(), other.getWidth(), other.getHeight());
		return playerRect.overlaps(otherRect);
	}
	
	public void setAnimation(Animation anim) {
		if(anim != this.animation) {
			this.animation = anim;
			animTime = 0;
		}
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
	
	public float getCenterX() {
		return x+width/2;
	}
	
	public float getCenterY() {
		return y+height/2;
	}

	public void setX(float x) {
		this.x = x;
		sprite.setX(x);
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
		sprite.setY(y);
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
