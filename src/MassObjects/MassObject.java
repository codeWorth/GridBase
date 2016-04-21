package MassObjects;
import Utitlity.Position;

public abstract class MassObject {
	public int width = 0;
	public int height = 0;
	public Position position;
	
	public MassObject(int _x, int _y, int _width, int _height){
		width = _width;
		height = _height;
		position = new Position(_x, _y);
	}
	
	public int topRight(){
		return position.x + width;
	}
	
	public int bottomLeft(){
		return position.y + height;
	}
	
	public boolean isPointWithin(int x, int y){
		if (x < position.x || x > position.x + width || y < position.y || y > position.y + height){
			return false;
		} else {
			return true;
		}
	}
	
	public boolean overlapsObject(MassObject otherObj){
		if (topRight() < otherObj.position.x || otherObj.topRight() < position.x || bottomLeft() < otherObj.position.y || otherObj.bottomLeft() < position.y){
			return false;
		} else {
			return true;
		}
	}
	
	public abstract void update();
	public abstract double print();
}