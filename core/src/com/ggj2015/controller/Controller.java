package com.ggj2015.controller;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.ggj2015.Assets;
import com.ggj2015.model.Knife;
import com.ggj2015.model.Level;
import com.ggj2015.model.Player;

public class Controller {

	private Level level;
	
	public Controller(Level level){
		this.level = level;
	}
	
	public void update(float delta){
		//if(level.finished) return;
		Knife k = level.getKnife();
		
		for(Player p : level.getPlayers()){
			if(p.alive) {
				p.setX(p.getX()+p.getVelX()*delta);
				p.setY(p.getY()+p.getVelY()*delta);
				if(p.getX() < 0) p.setX(0);
				else if(p.getX()+p.getWidth() > level.getWidth()) p.setX(level.getWidth()-p.getWidth());
				
				if(p.getY() < 0) p.setY(0);
				else if(p.getY()+p.getHeight() > level.getHeight()) p.setY(level.getHeight()-p.getHeight());
				
				if(k.getOwner() == null && p.collides(k)) {
					if(k.getVelX() == 0 && k.getVelY() == 0) {
						k.setOwner(p);
						p.getSprite().setRegion(Assets.playerWalkingRightWithKnife[0]);
					}
					else {
						k.setOwner(p);
						p.alive = false;
						p.getSprite().setRegion(Assets.playerStabbed);
						level.deadCount++;
						if(level.deadCount == level.getPlayers().size()-1) {
							level.finished = true;
							for(int i=0; i<level.getPlayers().size(); i++) {
								if(level.getPlayers().get(i).alive) level.winner = i+1;
							}
							Timer.schedule(new Task() {

								@Override
								public void run() {
									level.finished = false;
									level.spawnPlayers(level.deadCount+1);
									level.spawnKnife();
								}
								
							}, 3.5f);
						}
					}
				}
				
				// Checking collision with possible dead player.
				for(Player o : level.getPlayers()) {
					if(o.alive || o == p) continue;
					if(p.collides(o) && p.tryingToPickUp) {
						k.setOwner(p);
						p.getSprite().setRegion(Assets.playerWalkingRightWithKnife[0]);
						p.tryingToPickUp = false;
						o.getSprite().setRegion(Assets.playerDead);
					}
				}
				
				// animation
				
				if(p.alive) {
					if(p.getVelX() > 0) {
						if(k.getOwner() != p) p.setAnimation(Assets.walkingRightAnim);
						else p.setAnimation(Assets.walkingRightWithKnifeAnim);
					}
					else if(p.getVelX() < 0) {
						if(k.getOwner() != p) p.setAnimation(Assets.walkingLeftAnim);
						else p.setAnimation(Assets.walkingLeftWithKnifeAnim);
					}
					
					if(p.getVelX() != 0 || p.getVelY() != 0) {
						p.animTime += delta;
						p.getSprite().setRegion(p.animation.getKeyFrame(p.animTime, true));
					}
					else {
						p.getSprite().setRegion(p.animation.getKeyFrames()[0]);
					}
				}
			}
		}

		if(k.getOwner() != null){
			k.setX(k.getOwner().getX());
			k.setY(k.getOwner().getY());			
		}else{
			k.setX(k.getX()+k.getVelX()*delta);
			k.setY(k.getY()+k.getVelY()*delta);
			k.setVelX(k.getVelX()*k.getFriction());
			k.setVelY(k.getVelY()*k.getFriction());
		}
		
		if(k.getX() > level.getWidth()) k.setX(-k.getWidth());
		else if(k.getX()+k.getWidth() < 0) k.setX(level.getWidth());
		
		if(k.getY() > level.getHeight()) k.setY(-k.getHeight());
		else if(k.getY()+k.getHeight() < 0) k.setY(level.getHeight());
	}
	
	public void action(int player, boolean[] boolset){
		if(level.getPlayers().size() >= player+1){
			Player p = level.getPlayers().get(player);
			
			if(boolset[4] && p.alive && level.getKnife().getOwner() == p){
				level.getKnife().throwIt();
			}
			
			float playerSpeed = 420f;
			
			p.setVelX(0);
			p.setVelY(0);
			p.tryingToPickUp = false;
			
			if(boolset[0]){
				p.setVelY(playerSpeed);
				p.setDir(1);
			}
			if(boolset[1]){
				p.setVelX(playerSpeed);
				p.setDir(5);
			}
			
			if(boolset[2]){
				p.setVelY(-playerSpeed);
				p.setDir(7);
			}
			if(boolset[3]){
				p.setVelX(-playerSpeed);
				p.setDir(3);
			}
			if(boolset[5]){
				p.tryingToPickUp = true;
			}
			
			if(Math.abs(p.getVelX()) > 0 && Math.abs(p.getVelY()) > 0){
				p.setVelX(p.getVelX() / (float)Math.sqrt(2));
				p.setVelY(p.getVelY() / (float)Math.sqrt(2));
				
				if(p.getVelX() < 0){
					if(p.getVelY() > 0){
						p.setDir(0);						
					}else{
						p.setDir(6);
					}
				}else{
					if(p.getVelY() > 0){
						p.setDir(2);						
					}else{
						p.setDir(8);
					}
				}
				
			}
			
		}
	}
}
