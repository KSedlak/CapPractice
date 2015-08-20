package com.capgemini.GameOfLifeInitMouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class MouseHandler implements MouseListener {
	
	private int sizeRectangle;
	private Board board;
	private Boolean enable;
	private JComponent parentForRepaint;
	
	public MouseHandler(int size, Board b, JComponent parent){
		sizeRectangle=size;
		board=b;
		enable=false;
		parentForRepaint=parent;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	if(enable){
			int x =	e.getX()/sizeRectangle;
			int y = e.getY()/sizeRectangle;
			int idx=y*board.getWidth()+ x;
			board.getCell(idx).changeLifeStatus();
			parentForRepaint.repaint();
		}
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
