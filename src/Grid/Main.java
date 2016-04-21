package Grid;
import Inlets.ElectricityInlet;
import Inlets.WoodInlet;
import MassObjects.Wire;
import MassObjects.WoodGenerator;
import Utitlity.InletList;
import Utitlity.WoodInletList;

public class Main {
	public static void main(String[] args){		
		Grid grid = new Grid();
		
		WoodGenerator gen1 = new WoodGenerator(2, 2, 5, 6);
		grid.addMassObject(gen1);
		
		Wire wire1 = new Wire(8, 2);
		
		ElectricityInlet wire1In = new ElectricityInlet(wire1);
		wire1.setInlet(wire1In);
		gen1.addOutlet(wire1In);
		
		grid.print();
	}
}
