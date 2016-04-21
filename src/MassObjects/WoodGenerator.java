package MassObjects;

import java.util.ArrayList;

import Inlets.ElectricityInlet;
import Inlets.Inlet;
import Inlets.WoodInlet;
import MasslessObjects.Electricity;
import MasslessObjects.Wood;
import Utitlity.Outlet;

public class WoodGenerator extends MassObject implements Outlet{	
	private ArrayList<Inlet> inlets = new ArrayList<Inlet>();
	private ArrayList<ElectricityInlet> outlets = new ArrayList<ElectricityInlet>();
	private Wood fuel = new Wood();
	
	public WoodGenerator(int _x, int _y, int _width, int _height){
		super(_x, _y, _width, _height);
	}

	public void update() {
		intakeAll();
		outputToAll();
	}
	
	private void intakeAll(){
		for (Inlet inlet : inlets){
			if (inlet instanceof WoodInlet){
				fuel.add(inlet.removeStore());
			}
		}
	}

	public void addInlet(Inlet in) {
		inlets.add(in);
	}

	public void removeInlet(Inlet in) {
		inlets.remove(in);
	}
	
	@Override
	public void outputToAll() {
		double energyAmount = fuel.amount * Wood.energyPerAmount;
		int outletsLength = outlets.size();
		double amountPer = energyAmount/outletsLength;
		
		for (ElectricityInlet inlet : outlets){
			inlet.addToStore(new Electricity(amountPer));
		}
	}
	
	@Override
	public void addOutlet(Inlet out) {
		if (out instanceof ElectricityInlet){
			ElectricityInlet outlet = (ElectricityInlet) out;
			outlets.add(outlet);
		}
	}

	@Override
	public void removeOutlet(Inlet out) {
		if (out instanceof ElectricityInlet){
			ElectricityInlet outlet = (ElectricityInlet) out;
			outlets.remove(outlet);
		}
	}
	
	@Override
	public double print(){
		return 1;
	}
	 
}
