package cn.tedu.shoot;

import java.awt.Graphics;

public class Bullet extends FlyingObject{
	private int speed;
	private int xSpeed;
	private int flag;
	//需要传入Hero的坐标再定义出子弹的坐标
	public Bullet(int x,int y,int flag){
		super(8,14);
		xSpeed=1;
		this.x=x;
		this.y=y-20;
		speed=2;
		this.flag=flag;
	}

	public void step() {
	switch(flag) {
	case 1:x-=xSpeed;break;
	case 2:x+=xSpeed;break;
	}
	y-=speed;
	}
	

	@Override
	
	public  void showImg(Graphics g) {
		if(state==life) {
		g.drawImage(bulletImg, x, y, null);
		}
		
	}
	public boolean outOfBounds() {
		if(y<=0) {
			return false;
		}
		return true;
	}

}
