package cn.tedu.shoot;

import java.awt.Graphics;

public class Boom extends FlyingObject{
	
//需要碰撞时的x，y值
	protected Boom(int x,int y) {
		super(49, 36);
		this.x=x-width/2;
		this.y=y;
	
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub	
	}

	
	int index=0;
	int count=20;
	@Override
	protected void showImg(Graphics g) {
		if(count>=0) {
		if(index++%2==0) {
    g.drawImage(airplaneImg[3], x, y, null);
		}
		count--;
		}else {
			state=remove;
		}
	
	}
	public boolean isDead() {
		return state==remove;
	}
	

}
