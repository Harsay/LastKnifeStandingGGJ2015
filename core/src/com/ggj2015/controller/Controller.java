package com.ggj2015.controller;

import com.ggj2015.model.Level;
import com.ggj2015.model.Player;

public class Controller {

	private Level level;
	
	public Controller(Level level){
		this.level = level;
	}
	
	public void update(float delta){
		for(Player p : level.getPlayers()){
			p.setX(p.getX()+p.getVelX()*delta);
			p.setY(p.getY()+p.getVelY()*delta);
			
			if(p.getX() < 0) p.setX(0);
			else if(p.getX()+p.getWidth() > level.getWidth()) p.setX(level.getWidth()-p.getWidth());
			
			if(p.getY() < 0) p.setY(0);
			else if(p.getY()+p.getHeight() > level.getHeight()) p.setY(level.getHeight()-p.getHeight());
		}
	}
	
	public void action(int player, boolean[] boolset){
		if(level.getPlayers().size() >= player+1){
			Player p = level.getPlayers().get(player);
			
			float playerSpeed = 300f;
			
			p.setVelX(0);
			p.setVelY(0);
			
			if(boolset[0]){
				p.setVelY(playerSpeed);
			}
			if(boolset[1]){
				p.setVelX(playerSpeed);
			}
			
			if(boolset[2]){
				p.setVelY(-playerSpeed);
			}
			if(boolset[3]){
				p.setVelX(-playerSpeed);
			}
			
			if(Math.abs(p.getVelX()) > 0 && Math.abs(p.getVelY()) > 0){
				p.setVelX(p.getVelX() / (float)Math.sqrt(2));
				p.setVelY(p.getVelY() / (float)Math.sqrt(2));
			}
			
		}
	}
}
