package cn.tedu.shoot;

import java.awt.Graphics;

public class Bee extends FlyingObject implements Enemies{
	private int speed;
	private int xSpeed;
	private int direction;
	public  Bee() {
		super(60,50);
		speed=1;
		xSpeed=1;
		x=(int)(Math.random()*(World.WORLD_WIDTH-width+1));
		y=-height;
		direction=(int)(Math.random()*2);
	}
    public void step() {
    	switch(direction) {
    	case 0:x-=xSpeed;break;
    	case 1:x+=xSpeed;
    	}
    y+=speed;
    if(x<=0||x>=(World.WORLD_WIDTH-width)) {
    	xSpeed*=-1;
    }
    
    }
    int count=0,index=0;
	@Override
	public  void showImg(Graphics g) {
		if (state == life) {
			g.drawImage(beeImg[0], x, y, null);
		} else if (state == dead) {
			if (count++ % 10 == 0) {
				index++;
			} else {
				if (index <= 4) {
					g.drawImage(beeImg[index], x, y, null);
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


}
