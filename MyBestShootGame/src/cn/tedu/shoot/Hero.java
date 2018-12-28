package cn.tedu.shoot;

import java.awt.Graphics;
import java.io.Serializable;

public class Hero extends FlyingObject {

	private int doublefire;
	private int lives;
	
	public  Hero() {
		super(97,124);
		doublefire=0;
		lives=3;
		x=150;
		y=400;
	}
    public void step() {
    
    }
    public void moveTo(int x,int y) {
    	this.x=x;
    	this.y=y;
    }

	
	int index=0;
	@Override
	public  void showImg(Graphics g) {
		if(lives>0) {
		if(index++%2==0) {
		g.drawImage(heroImg[0], x, y, null);
		}else {
		g.drawImage(heroImg[1], x, y, null);
		}
		}
		
	}
	public boolean destory() {
		doublefire=0;
		lives--;
		return lives<=0;
	}
	public void reward() {
		int random=(int)(Math.random()*4);
		switch(random) {
		case 0:
		case 1:
		case 2:doublefire+=15;break;
		case 3:lives++;
		}
		
	}
	public int getDoublefire() {
		return doublefire;
	}
	public void setDoublefire(int doublefire) {
		this.doublefire=doublefire;
	}
	public int getLives() {
		return lives;
	}


	
	
}
