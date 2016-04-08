import Grid.Grid;
import MassObjects.MassObject;

public class Main {
	public static void main(String[] args){
		Grid grid = new Grid();
		
		MassObject obj1 = new MassObject(2, 2, 5, 6);
		grid.addMassObject(obj1);
		
		MassObject obj2 = new MassObject(8, 3, 3, 2);
		grid.addMassObject(obj2);
		
		//shouldn't get added
		MassObject obj3 = new MassObject(4, 4, 2, 5);
		grid.addMassObject(obj3);
		
		grid.print();
	}
}
