package com.capgemini.GameOfLifeInitMouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class MouseHandler implements MouseListener {
	
	private int sizeRectangle;
	private Board gof;
	private Boolean enable;
	private JComponent parentForRepaint;
	
	public MouseHandler(int size, Board controler, JComponent parent){
		sizeRectangle=size;
		gof=controler;
		enable=false;
		parentForRepaint=parent;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
/*		if(enable){
			int x =	e.getX()/sizeRectangle;
			int y = e.getY()/sizeRectangle;
			int idx=y*gof.getW()+ x;
			gof.getCell(idx).changeLifeStatus();
			parentForRepaint.repaint();*/
		//}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
}
