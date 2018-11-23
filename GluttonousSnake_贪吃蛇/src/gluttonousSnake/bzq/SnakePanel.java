package gluttonousSnake.bzq;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class SnakePanel extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	
	//���巽��
	int dir=39;//��38����40����37����39
	//����ʳ������
	int food_x;
	int food_y;
	
	//map����
	int[] map_x =new int[20];
	int[] map_y =new int[20];
	//snake����
	int head_x,head_y;
	int[] x =new int[400];
	int[] y =new int[400];
	int SnakeLong=2;//snake��ʼ����
	
	
	public SnakePanel() {
		super();
		//��ͼ�����ʼ��
		for(int i=0;i<20;i++) {
			map_x[i]=100+30*i;
			map_y[i]=100+30*i;
		}
		//snake��ʼ��
		
		head_x=map_x[10];
		head_y=map_y[10];
		for (int i = 0; i < x.length; i++) {
			x[i]=-30;
			y[i]=-30;
		}
		//ʳ���ʼ��
		food_x=100+30*(int)(Math.random()*19+1);
		food_y=100+30*(int)(Math.random()*19+1);
		//�������̼���
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		//����
		g.setColor(Color.black);
		g.drawRect(100, 100, 600, 600);
		//����
		g.setColor(Color.black);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < map_x.length; j++) {
				g.drawRect(map_x[i], map_y[j], 30, 30);
			}
		}
		//����snake
		g.setColor(Color.red);
		g.fillRect(head_x, head_y, 30, 30);
		g.setColor(Color.magenta);
		for (int i = 0; i <SnakeLong; i++) {
			g.fillRect(x[i], y[i], 30, 30);
		}
		//����ʳ��
		g.setColor(Color.getHSBColor((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
		g.fillOval(food_x, food_y, 30, 30);
		
	}
	public void move() {
		new Thread() {
			public void run() {
				while(true) {
					/////////��ͷ��һ///////////
					
					x[0]=head_x;
					y[0]=head_y;
					for (int i = SnakeLong; i >0 ; i--) {
						x[i]=x[i-1];
						y[i]=y[i-1];
					}
					
					////////////���Ʒ���///////////////////////
					if(dir==37) {
						head_x-=30;
					}else if(dir==38) {
						head_y-=30;
					}else if(dir==39) {
						head_x+=30;
					}else if(dir==40) {
						head_y+=30;
					}
					/////////////�ж��Ե�ʳ��snakelong��һ//////
					if(head_x==food_x&&head_y==food_y){
						SnakeLong++;
						food_x=100+30*(int)(Math.random()*19+1);
						food_y=100+30*(int)(Math.random()*19+1);
					}
					//////////////////////////////////////////
					try {
						sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();
					
				}
			}
			
		}.start();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		dir=arg0.getKeyCode();
		//System.out.println(b);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		


}
