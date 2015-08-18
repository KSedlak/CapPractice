package GameOfLifeWithoutMouse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CellCreator {
int readWidth;
int readHeight;
	
	
	public ArrayList<Cell> readFile() throws IOException {
		String[] temp;
		ArrayList<Cell> result;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/main/java/GameOfLife/gOf.txt"));
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
				if(Integer.parseInt(temp[i])==0){
					result.add(new Cell(i,counterY, false));
				}
				if(Integer.parseInt(temp[i])==1){
					result.add(new Cell(i,counterY, true));
				}
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
	public void setGameOfLifeParamteresFromFile(GameOfLife g) throws IOException{
	ArrayList<Cell> r= readFile();
		g.setCellList(r);

		System.out.println(readWidth+" "+readHeight);
		g.setWidth(readWidth);
		g.setHeight(readHeight);
		g.generateNeighboursList();
	}
}
