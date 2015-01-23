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
			System.out.println(p.getDir());
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
