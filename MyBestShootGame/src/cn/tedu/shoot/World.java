package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel {

	public static final int WORLD_WIDTH = 400;
	public static final int WORLD_HEIGHT = 700;
	private List<FlyingObject> enemies = new ArrayList<FlyingObject>();
	private Hero hero;
	private List<Bullet> bullets = new ArrayList<Bullet>();
	private List<Boom> boom = new ArrayList<Boom>();
	private Sky sky;
	private int score = 0;
	private static BufferedImage startImg, pauseImg, gameoverImg;
	private static final int START = 0;
	private static final int RUNNING = 1;
	private static final int PAUSE = 2;
	private static final int GAME_OVER = 3;
	private int state = START;
	
	
	// 静态加载图片
	static {
		try {
			startImg = ImageIO.read(new File("start.png"));
			pauseImg = ImageIO.read(new File("pause.png"));
			gameoverImg = ImageIO.read(new File("gameover.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public World() {
		hero = new Hero();
		sky = new Sky();
		
	}

	// 越界敌人和子弹删除
	public synchronized void outOfBoundsAction() {
		Iterator it1 = enemies.iterator();
		while (it1.hasNext()) {
			Enemies obj = (Enemies) it1.next();
			if (!obj.outOfBounds()) {
				it1.remove();
			}
			// 判断敌人的状态
			FlyingObject f = (FlyingObject) obj;
			if (f.isRemove()) {
				it1.remove();
			}

		}
		Iterator<Bullet> it2 = bullets.iterator();
		while (it2.hasNext()) {
			Bullet bt = it2.next();
			if (!bt.outOfBounds() || bt.isRemove()) {
				it2.remove();
			}
		}
		Iterator<Boom> it3 = boom.iterator();
		while (it3.hasNext()) {
			if (it3.next().isDead()) {
				it3.remove();
			}
		}

	}

	int index = 0;

	public void enemiesReady() {
		FlyingObject obj;

		if (index++ % 60 == 0) {
			int random = (int) (Math.random() * 26);
			if (random >= 15) {
				obj = new Bee();
				enemies.add(obj);

			} else if (random >= 8) {
				obj = new Airplane();
				enemies.add(obj);

			} else {
				obj = new BigAirplane();
				enemies.add(obj);
			}
		}
	}

	int index1 = 0;

	public void bulletReady() {
		Bullet leftbullet = new Bullet(hero.x + hero.width / 4, hero.y, 1);// 左左子弹
		Bullet rightbullet = new Bullet(hero.x + hero.width / 4 * 3, hero.y, 2);// 右右子弹
		Bullet left1bullet = new Bullet(hero.x + hero.width / 5, hero.y, 0);// 左子弹
		Bullet right1bullet = new Bullet(hero.x + hero.width / 5 * 4, hero.y, 0);// 右子弹
		Bullet bullet = new Bullet(hero.x + hero.width / 2, hero.y, 0);// 中子弹
		if (index1++ % 30 == 0) {
			if (hero.getDoublefire() > 50) {
				bullets.add(leftbullet);
				bullets.add(rightbullet);
				bullets.add(bullet);
				hero.setDoublefire(hero.getDoublefire() - 3);
			} else if (hero.getDoublefire() > 20) {
				bullets.add(left1bullet);
				bullets.add(right1bullet);
				hero.setDoublefire(hero.getDoublefire() - 2);
			} else {
				bullets.add(bullet);
			}

		}
	}

	// 敌人和子弹撞 ，敌人和英雄机撞
	public synchronized void hitAction() {
		// 敌人和子弹撞

		/*
		 * Iterator<FlyingObject> it1 = enemies.iterator(); Iterator<Bullet> it2 =
		 * bullets.iterator(); while (it1.hasNext()) { FlyingObject fo = it1.next();
		 * while (it2.hasNext()) { Bullet bt= it2.next(); if
		 * (fo.isLife()&&bt.isLife()&&bt.isHit(fo)) { bt.goDead(); fo.goDead(); } } }
		 */

		for (FlyingObject fo : enemies) {
			for (Bullet bt : bullets) {
				if (fo.isLife() && bt.isLife() && bt.isHit(fo)) {
					bt.goDead();
					fo.goDead();
					Boom b = new Boom(bt.x, bt.y - 20);
					boom.add(b);

					// 杀小蜜蜂加奖励
					if (fo instanceof Bee) {
						hero.reward();
					}
					if (fo instanceof Airplane) {
						score += 1;
					}
					if (fo instanceof BigAirplane) {
						score += 2;
					}
				}
			}

			// 和英雄机撞
			if (fo.isLife()&&hero.isHit(fo)) {
				//敌人直接死亡
				fo.setState();
				//判断游戏是否结束
				if(hero.destory()) {
					state=GAME_OVER;
				}
				
			}

		}
	}

	public void paint(Graphics g) {
		sky.showImg(g);
		hero.showImg(g);
		if (state == START) {
			g.drawImage(startImg, 0, 0, null);

		} else if (state == RUNNING) {
			for (FlyingObject obj : enemies) {
				obj.showImg(g);
			}
			for (Bullet b : bullets) {
				b.showImg(g);
			}
			for (Boom b : boom) {
				b.showImg(g);
			}
		} else if (state == PAUSE) {
			g.drawImage(pauseImg, 0, 0, null);
			
		} else {
			g.drawImage(gameoverImg, 0, 0, null);
		}
		g.drawString("生命："+hero.getLives(),10, 20);
		g.drawString("分数："+score,10, 35);
		g.drawString("火力："+hero.getDoublefire(),10,50);

	}

	public void action(World world) {
		KeyAdapter key=new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int x=hero.x;
				int y=hero.y;
				switch(e.getKeyCode()) {
				case 37: x-=6;break;
				case 39: x+=6;break;
				case 38: y-=6;break;
				case 40: y+=6;break;
				}
				hero.moveTo(x, y);
				if(e.getKeyCode()==81) {
					save(world);
					System.out.println(e.getKeyCode());
				}
			}		
		};
		this.addKeyListener(key);
		this.requestFocus();
		MouseAdapter mouse = new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				if (state == RUNNING) {
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x - hero.width / 2, y - hero.height / 2);
				}
			}

			public void mouseEntered(MouseEvent e) {
				if (state == PAUSE) {
					state = RUNNING;
				}

			}

			public void mouseExited(MouseEvent e) {
				if (state == RUNNING) {
					state = PAUSE;
					
					
				}
			}
			public void mouseClicked(MouseEvent e) {
				if(state==START) {
					state=RUNNING;
				}
				//初始化
				if(state==GAME_OVER) {
					hero=new Hero();
					enemies = new ArrayList<FlyingObject>();
					bullets = new ArrayList<Bullet>();
					boom = new ArrayList<Boom>();
					state=START;
					score=0;
				}
			}
		};
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				sky.step();
				if(state==RUNNING) {
				enemiesReady();
				bulletReady();
				hitAction();

				synchronized (bullets) {
					for (Bullet b : bullets) {
						b.step();
					}
				}
				synchronized (enemies) {
					for (FlyingObject f : enemies) {
						f.step();
					}
				}
				outOfBoundsAction();
				}
				
				/*
				System.out.println("敌人集合：" + enemies.size());
				System.out.println("子弹集合：" + bullets.size());
				System.out.println("Boom集合：" + boom.size());
*/
				// 这个我也不是很懂
				repaint();

			}

		}, 10, 10);

	}
	//写入游戏文档
	public static void save(World world) {
		try {
			FileOutputStream fos=new FileOutputStream("data.obj");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(world);
			System.out.println("写入完毕！");
			oos.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//读取游戏文档
	public static World load() {
		World world=new World();
		try {
			FileInputStream fis=new FileInputStream("data.obj");
			ObjectInputStream ois=new ObjectInputStream(fis);
			world= (World)ois.readObject();
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return world;
		
	}

	public static void main(String[] args) {
		World world = load();
		JFrame frame = new JFrame();
		frame.add(world);
		frame.setSize(WORLD_WIDTH, WORLD_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		world.action(world);

	}
}
