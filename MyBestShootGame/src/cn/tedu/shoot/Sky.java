package cn.tedu.shoot;

import java.awt.Graphics;

public class Sky extends FlyingObject{
    private int speed;
    private int y1;
	public Sky() {
		super(World.WORLD_WIDTH, World.WORLD_HEIGHT);
		x=0;
		y=0;
		speed=2;
		y1=-World.WORLD_HEIGHT;
	}
	@Override
	public void step() {
		y+=speed;
		y1+=speed;
		if(y>=World.WORLD_HEIGHT) {
			y=-World.WORLD_HEIGHT;
		}
		if(y1>=World.WORLD_HEIGHT) {
			y1=-World.WORLD_HEIGHT;
		}
		
		
	}
	@Override
	public  void showImg(Graphics g) {
		g.drawImage(skyImg, x, y, null);
		g.drawImage(skyImg, x, y1, null);
		
	}
	

}
