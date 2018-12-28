package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;

import javax.imageio.ImageIO;

public abstract class FlyingObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static BufferedImage []airplaneImg=new BufferedImage[5];
	protected static BufferedImage []bigAirplaneImg=new BufferedImage[5];
	protected static BufferedImage []beeImg=new BufferedImage[5];
	protected static BufferedImage []heroImg=new BufferedImage[2];
	protected static BufferedImage skyImg;
	protected static BufferedImage bulletImg;
	protected int x,y;
	protected int width,height;
	public static final int life=1;
	public static final int dead=2;
	public static final int remove=3;
	protected int state=1;
	static {
		//加载图片
		loadImg();
	}
	protected FlyingObject(int width,int height) {
		
		this.width=width;
		this.height=height;
		
	}
	//抽象方法
	protected abstract void step();
	//加载图片 
	private static void loadImg() {
		try {
		   skyImg=ImageIO.read(new File("background.png"));
		   bulletImg=ImageIO.read(new File("bullet.png"));
			 heroImg[0]=ImageIO.read(new File("hero0.png"));
			 heroImg[1]=ImageIO.read(new File("hero1.png"));
			for(int i=0;i<4;i++) {
		   airplaneImg[i]=ImageIO.read(new File("airplane"+i+".png"));
		   bigAirplaneImg[i]=ImageIO.read(new File("bigplane"+i+".png"));
		   beeImg[i]=ImageIO.read(new File("bee"+i+".png"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//显示图片
	protected abstract void showImg(Graphics g);
	//相撞的算法
	
	protected boolean isHit(FlyingObject obj) {
		int x1=this.x-obj.width;
		int y1=this.y-obj.height;
		
		int x2=this.x+this.width;
		int y2=this.y+this.height;
		 
		return obj.x>=x1&&obj.x<=x2&&obj.y>=y1&&obj.y<=y2;	
	}
	
	public void goDead() {
		this.state = dead;
	}
	public boolean isRemove() {
		return state==remove;
	}
	public boolean isLife() {
		return state==life;
	}
	public void setState() {
		this.state=dead;
	}


}
