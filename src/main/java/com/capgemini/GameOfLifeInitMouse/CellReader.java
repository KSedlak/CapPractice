package com.capgemini.GameOfLifeInitMouse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CellReader {
private int readWidth;
private int readHeight;
	
	
	public ArrayList<Cell> readFile() throws IOException {

		String[] temp;
		ArrayList<Cell> result;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/main/java/com/capgemini/GameOfLifeInitMouse/gOf.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			String line = br.readLine();
			temp=line.split(" ");
			readWidth=temp.length;
			result=new ArrayList<Cell>();
			int counterY=0;
			while (line != null) {
			temp=line.split(" ");
			for(int i=0; i<temp.length;i++){
					result.add(new Cell(LifeStatus.values()[Integer.parseInt(temp[i])]));
			}
			counterY++;
			line = br.readLine();
			
			}
			readHeight=counterY;
		} finally {
			br.close();
		

		}
	return result;
	}
	public void setBoardParamteresFromFile(GameLogic gL) throws IOException{
		ArrayList<Cell> r= readFile();
			gL.getBoard().setHeight(readHeight);
			gL.getBoard().setWidth(readWidth);
			gL.getBoard().setBoardMatrixFromFile(r);
			gL.refreshBoard();
	}
}
