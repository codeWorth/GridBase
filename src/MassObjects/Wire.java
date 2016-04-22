package MassObjects;

import java.util.ArrayList;

import Inlets.E;
import Inlets.Inlet;
import MasslessObjects.Electricity;
import Utitlity.Connection;

public class Wire<E extends E> extends MassObject implements Connection<E> {
	public static double efficiency = 0.8;
	
	private E inlet;
	private ArrayList<E> outlets = new ArrayList<E>();
	
	private Electricity power = new Electricity(0);
	
	public Wire(int _x, int _y) {
		super(_x, _y, 1, 1);
	}

	@Override
	public void update() {
		intakeAll();
		outputToAll();
	}
	
	@Override
	public void addOutlet(Inlet out) {
		if (out instanceof E){
			E outlet = (E) out;
			outlets.add(outlet);
		}
	}

	@Override
	public void removeOutlet(Inlet out) {
		if (out instanceof E){
			E outlet = (E) out;
			outlets.remove(outlet);
		}
	}
	
	private void intakeAll(){
		power.add(inlet.removeStore());
	}
	
	@Override
	public void outputToAll() {		
		int outletsLength = outlets.size();
		double amountPer = power.amount/outletsLength * Wire.efficiency * Electricity.efficiency;
		
		for (E inlet : outlets){
			inlet.addToStore(new Electricity(amountPer));
		}
	}

	@Override
	public double print() {
		if (power.amount > 0){
			return 2;
		} else {
			return 1;
		}
	}

	@Override
	public void canTransfer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInlet(Inlet _inlet){
		inlet = _inlet;
	}
	
	@Override
	public void removeInlet() {
		this.inlet.removeThis();
		this.inlet = null;
	}

}
