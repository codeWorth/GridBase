package Grid;

import MassObjects.Lightbulb;
import MassObjects.Wire;
import MassObjects.WireSplitter;
import MassObjects.WoodGenerator;
import MassObjects.WoodStore;
import MasslessObjects.Wood;

public class Main {
	public static void main(String[] args){		
		Grid grid = new Grid();
		
		WoodGenerator gen = new WoodGenerator(0, 0);
		grid.addMassObject(gen);
		
		Wire wire1 = new Wire(1, 2);
		Wire wire2 = new Wire(1, 3);
		Wire wire3 = new Wire(1, 4);
		
		WireSplitter splitter1 = new WireSplitter(1, 5);
		
		grid.addMassObject(wire1);
		grid.addMassObject(wire2);
		grid.addMassObject(wire3);
		
		grid.addMassObject(splitter1);
		
		Lightbulb output1 = new Lightbulb(0,6);
		Lightbulb output2 = new Lightbulb(1,6);
		Lightbulb output3 = new Lightbulb(2,6);
		
		grid.addMassObject(output1);
		grid.addMassObject(output2);
		grid.addMassObject(output3);
		
		wire1.linkTo(gen);
		wire2.linkTo(wire1);
		wire3.linkTo(wire2);
		
		splitter1.linkTo(wire3);
		
		output1.linkTo(splitter1);
		output2.linkTo(splitter1);
		output3.linkTo(splitter1);
		
		WoodStore storage = new WoodStore(2, 0);
		gen.linkTo(storage);
		grid.addMassObject(storage);
		
		grid.print();
		storage.add(new Wood(10));
		
		grid.print();
		
		for (int i = 0; i < 7; i++){
			grid.allObjectsUpdate();
			
			grid.print();
		}
	}
}
