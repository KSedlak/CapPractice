package GameOfLifeWithoutMouse;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Presentation extends JComponent {
	GameOfLife control;
	CellCreator  cc;
	int sizeRect = 50;
	JLabel labelForGenerationCounter;
	public Presentation(GameOfLife g, CellCreator c, JLabel gen) {
		control = g;
		control.initMatrix();
		labelForGenerationCounter=gen;
		cc=c;
	}
	
	public void next(){
		control.nextGeneration();
		labelForGenerationCounter.setText("Generation: "+control.generation);
		repaint();
	}
	public void random(){
		control.initMatrix();
		repaint();
	}
	public void read() throws IOException{
		cc.setGameOfLifeParamteresFromFile(control);
		repaint();
	}
	
	public void paint(Graphics g) {

		for (int i = 0; i < control.h; i++) {
			for (int j = 0; j < control.w; j++) {
				if (control.listOfCells.get(i * control.w + j).lifeStatus) {
					g.fillRect(j * sizeRect, i * sizeRect, sizeRect, sizeRect);
				} else {
					g.drawRect(j * sizeRect, i * sizeRect, sizeRect, sizeRect);
				}
			}
		}

	}
}

public class View {
	
	public static void main(String[] a) {
		
		int size=15;
		
		JFrame window = new JFrame();
		GameOfLife gof = new GameOfLife(size,size);
		CellCreator creator = new CellCreator();
		JLabel generationCounter = new JLabel("Generation: 0");
		final Presentation p =new Presentation(gof,creator, generationCounter);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(30, 30,size*50+16, size*50+103);
	
	
		JButton next = new JButton("next");
		JButton random = new JButton("Random");
		JButton file = new JButton("Read from file");
		
		next.setPreferredSize(new Dimension(100, 50));
		random.setPreferredSize(new Dimension(100, 50));
		file.setPreferredSize(new Dimension(100, 50));
		
		Container buttons =new Container();
		buttons.setLayout(new BorderLayout());
		buttons.setPreferredSize(new Dimension(100, 50));
		buttons.add(random, BorderLayout.WEST);
		buttons.add(file, BorderLayout.CENTER);
		buttons.add(next, BorderLayout.EAST);
	
		window.getContentPane().add(buttons, BorderLayout.SOUTH);
		window.getContentPane().add(p, BorderLayout.CENTER);
		window.getContentPane().add(generationCounter, BorderLayout.NORTH);
		window.setVisible(true);
		//listenery
		file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
       
           try {
			p.read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            }
            });
		random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
       
           p.random();
            }
            });
		next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
       
            p.next();
            }
            });
		
	}
	
	 
}
