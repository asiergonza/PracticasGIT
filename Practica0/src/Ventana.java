import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JLabel lF = new JLabel("chollo-alfombra-1.pgj");
	JLabelGraficoAjustado ja = new JLabelGraficoAjustado("coche.png", 100, 100);
	JButton b1 = new JButton("Acelerar");
	JButton b2 = new JButton("Frenar");
	JButton b3 = new JButton("Derecha");
	JButton b4 = new JButton("Izquierda");
	/*int vel = 0;
	int x = 0;
	int y = 0;
	double rot;
	double movX = 0;
	double movY = 0;*/
	
	Coche c = new Coche(ja, 0,0,0,0,0,0);
	double restax = 0;
	double restay = 0;
	double xAnterior = 0;
	double yAnterior = 0;
	

	
	Ventana() {

		setSize(500, 500);
		setResizable(false);	
		setLayout(new BorderLayout());
		panel.setLayout(null);
		
		panel.add(ja);
		//panel.add(lF);
		panel.setBackground(Color.BLUE);
		
		add(panel,BorderLayout.CENTER);

		panel2.add(b1);
		panel2.add(b2);
		panel2.add(b3);
		panel2.add(b4);
		panel2.setVisible(true);
		add(panel2, BorderLayout.SOUTH);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		c.x = ja.getX();
		c.y = ja.getY();

		
		System.out.println(c.rot);
		System.out.println(c.x);
		System.out.println(c.y);
		
		
		
		

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				c.vel += 1;
				
				
				

			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.vel -= 1;

			}
		});

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
				
				ja.setRotacion(c.rot + 0.5);
				
			}
		});

		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				ja.setRotacion(c.rot - 0.5);

			}
		});

	
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub


				int key = e.getKeyCode();
				

				if (key == KeyEvent.VK_LEFT) {
					ja.setRotacion(c.rot - 0.5);

				}

				if (key == KeyEvent.VK_RIGHT) {

					ja.setRotacion(c.rot + 0.5);

				}

				if (key == KeyEvent.VK_UP) {
					c.vel = c.vel +1;
					

				}

				if (key == KeyEvent.VK_DOWN) {
					
					c.vel -= 1;

				}

			}
		});
		
		setFocusable(true);
		hilo.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
	
	
	public Thread hilo = new Thread() { 


		public void run() {

			while(true) {
			
		
			
			c.rot = ja.getRotacion();
			
			xAnterior = c.x;
			yAnterior = c.y;

			c.x = (int) (c.x + c.vel * Math.cos(c.rot));
			c.y = (int) (c.y + c.vel * Math.sin(c.rot));
			
		
			
			if( c.x < 0  || c.x > 400 ) {
				
				ja.setRotacion(ja.getRotacion() + Math.PI);
			
			}
			if( c.y <  0 || c.y > 410) {

				ja.setRotacion(ja.getRotacion() +   Math.PI);

			}
			
			




			ja.setLocation(c.x, c.y);
			ja.repaint();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

			/*	} catch (InterruptedException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/




		}
	};



}

