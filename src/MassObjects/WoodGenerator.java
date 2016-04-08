package MassObjects;

import java.util.ArrayList;

import MasslessObjects.Electricity;
import MasslessObjects.Wood;
import Utitlity.Outlet;
import Utitlity.Inlets.Inlet;
import Utitlity.Inlets.WoodInlet;

public class WoodGenerator extends MassObject implements Outlet{	
	private ArrayList<Inlet> inlets = new ArrayList<Inlet>();
	private ArrayList<Inlet> outlets = new ArrayList<Inlet>();
	private Wood fuel = new Wood();
	
	public WoodGenerator(int _x, int _y, int _width, int _height){
		super(_x, _y, _width, _height);
	}

	public void update() {
		
	}
	
	public void intakeAll(){
		for (Inlet inlet : inlets){
			if (inlet instanceof WoodInlet){
				fuel.add(inlet.removeStore());
			}
		}
	}

	public void outputToAll() {
		double energyAmount = fuel.amount * Wood.energyPerAmount;
		int outletsLength = outlets.size();
		double amountPer = energyAmount/outletsLength;
		
		for (Inlet inlet : outlets){
			inlet.addToStore(new Electricity(amountPer));
		}
	}

	public void addInlet(Inlet in) {
		inlets.add(in);
	}

	public void removeInlet(Inlet in) {
		inlets.remove(in);
	}
	 
}
