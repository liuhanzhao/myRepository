package cn.tedu.shoot;

import java.awt.Graphics;

public class Airplane extends FlyingObject implements Enemies {
	private int speed;
	private int resistance;

	public Airplane() {
		super(49, 36);
		System.out.println("我又加入了一个输入语句");
		resistance=200;
		speed = 1;
		x = (int) (Math.random() * (World.WORLD_WIDTH - width + 1));
		y = -height;
	}

	public void step() {
		y += speed;

	}

	public void showImage() {

	}

	int index = 0, count = 0;

	@Override
	public void showImg(Graphics g) {
		if (state == life) {
			g.drawImage(airplaneImg[0], x, y, null);
		} else if (state == dead) {
			if (count++ % 10 == 0) {
				index++;
			} else {
				if (index <= 4) {
					g.drawImage(airplaneImg[index], x, y, null);
				} else {
					state = remove;
				}
			}
		}
	}

	public boolean outOfBounds() {
		if (y >= World.WORLD_HEIGHT) {
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
