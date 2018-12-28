package cn.tedu.shoot;

import java.awt.Graphics;

public class BigAirplane extends FlyingObject implements Enemies{
	private int speed;
	private int resistance;
	public  BigAirplane() {
		super(69,99);
		resistance=500;
		speed=1;
		x=(int)(Math.random()*(World.WORLD_WIDTH-width+1));
		y=-height;
	}
    public void step() {
    	y+=speed;
    	
    
    }
    int count=0,index=0;
	@Override
	public void showImg(Graphics g) {
		if (state == life) {
			g.drawImage(bigAirplaneImg[0], x, y, null);
		} else if (state == dead) {
			if (count++ % 10 == 0) {
				index++;
			} else {
				if (index <= 4) {
					g.drawImage(bigAirplaneImg[index], x, y, null);
				} else {
					state = remove;
				}
			}
		}
		
	}
	public boolean outOfBounds() {
		if(y>=World.WORLD_HEIGHT) {
			return false;
		}
		return true;
	}
	
	public void goDead() {
		resistance-=100;
		if(resistance<=0) {
			state=dead;
		}
	}



}
