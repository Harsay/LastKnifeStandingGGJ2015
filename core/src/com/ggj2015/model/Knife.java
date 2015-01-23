package com.ggj2015.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ggj2015.Assets;

public class Knife {

	private Sprite sprite;
	
	private float x, y;
	private float velX, velY;
	
	private float velAtStart = 100;
	
	private Player owner;
	
	public Knife(float x, float y){
		this.x = x;
		this.y = y;
		sprite = new Sprite(Assets.knifeTexture);
	}
	
	public void setOwner(Player owner){
		this.owner = owner;
	}
	
	public void throwIt(){
		if(owner != null){
			int dir = owner.getDir();
			
			if(dir == 0){
				velX = -(float) (velAtStart / Math.sqrt(2));
				velY = (float) (velAtStart / Math.sqrt(2));
			}else if(dir == 1){
				velX = 0;
				velY = velAtStart;
			}else if(dir == 2){
				velX = (float) (velAtStart / Math.sqrt(2));
				velY = (float) (velAtStart / Math.sqrt(2));
			}else if(dir == 3){
				velX = -velAtStart;
				velY = 0;
			}else if(dir == 4){
				// CENTER
			}else if(dir == 5){
				velX = velAtStart;
				velY = 0;
			}else if(dir == 6){
				velX = -(float) (velAtStart / Math.sqrt(2));
				velY = -(float) (velAtStart / Math.sqrt(2));
			}else if(dir == 7){
				velX = 0;
				velY = -velAtStart;
			}else if(dir == 8){
				velX = (float) (velAtStart / Math.sqrt(2));
				velY = -(float) (velAtStart / Math.sqrt(2));
			}
			
			owner = null;
		}
	}
	
	public float getX() {
		return x;
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

	public Sprite getSprite(){
		return sprite;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	
}
