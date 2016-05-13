package Grid;
import java.util.ArrayList;

import MassObjects.MassObject;
import Utitlity.Connection;
import Utitlity.Outlet;

public class Grid{
	private ArrayList<MassObject> massObjects =  new ArrayList<MassObject>(); 
	
	public boolean addMassObject(MassObject object){
		if (canFit(object)){
			massObjects.add(object);
			return true;
		} else {
			return false;
		}
	}
	
	private boolean canFit(MassObject object){
		for (MassObject thisObj : massObjects){
			if (thisObj.overlapsObject(object)){
				return false;
			}
		}
		
		return true;
	}
	
	public void allObjectsUpdate(){
		ArrayList<MassObject> toUpdate = new ArrayList<MassObject>();
		
		for (MassObject obj : massObjects){
			if (obj instanceof Outlet && !(obj instanceof Connection)){
				toUpdate.add(obj);
			}
		}
		
		while (toUpdate.size() > 0){
			int remaining = toUpdate.size();
			while (remaining > 0){
				MassObject thisObj = toUpdate.remove(0);			
				toUpdate.addAll(thisObj.update());
				
				remaining--;
			}
		}
		
		for (MassObject obj : massObjects){
			if (obj.getClass().equals(MassObject.class)){
				obj.update();
			}
		}
	}
	
	public int width(){
		if (massObjects.size() == 0){
			return 0;
		} 
		int maxX = massObjects.get(0).position.x;
		
		for (MassObject obj : massObjects){
			if (obj.topRight() > maxX){
				maxX = obj.topRight();
			}
		}
		
		return maxX;
	}
	
	public int height(){
		if (massObjects.size() == 0){
			return 0;
		} 
		int maxY = massObjects.get(0).position.y;
		
		for (MassObject obj : massObjects){
			if (obj.bottomLeft() > maxY){
				maxY = obj.bottomLeft();
			}
		}
		
		return maxY;
	}
	
	public void print(){
		String[][] map = map();
		
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	private String[][] map(){
		String[][] map = new String[width()][height()];
		
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				map[i][j] = "E  ";
			}
		}
		
		System.out.println("Width: " + width());
		System.out.println("Height: " + height());
		
		for (MassObject obj : massObjects){
				for (int i = 0; i < obj.width; i++){
					for (int j = 0; j < obj.height; j++){
						map[i+obj.position.x][j+obj.position.y] = obj.print();
					}
				}
		}
		
		return map;
	}
}