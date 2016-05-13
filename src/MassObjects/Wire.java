package MassObjects;

import java.lang.reflect.InvocationTargetException;

import MasslessObjects.Electricity;
import Utitlity.Connection;
import Utitlity.Inlet;
import Utitlity.Outlet;

public class Wire extends Connection {
	public static double efficiency = 0.8;
	
	protected Electricity power = new Electricity(0);
	
	public Wire(int _x, int _y) {
		super(_x, _y, 1, 1);
	}
	
	public Wire(int _x, int _y, Inlet<Electricity> input, Inlet<Electricity> output){
		super(_x, _y, 1, 1);
	}

	@Override
	public boolean handleAddInlet(Inlet<?> in) {
		if (in.type().equals(Electricity.class)){
			inlets.add(in);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean handleAddOutlet(Inlet<?> out) {
		if (out.type().equals(Electricity.class)){
			outlets.add(out);
			return true;
		} else {
			return false;
		}	
	}

	@Override
	public void outputToAll() {
		if (outlets.size() < 1){
			return;
		}
		
		Inlet<Electricity> out = (Inlet<Electricity>) outlets.get(0);
		out.addToStore(power.empty());
	}

	@Override
	protected void intakeAll() {
		if (inlets.size() < 1){
			return;
		}
		
		Inlet<Electricity> in = (Inlet<Electricity>) inlets.get(0);
		power.add(in.removeStore());
	}

	@Override
	protected boolean shouldAddInlet() {
		return (inlets.size() < 1);
	}

	@Override
	protected boolean shouldAddOutlet() {
		return (outlets.size() < 1);
	}

	@Override
	public boolean canTransferFrom(Outlet from) {
		return adjacentTo(from);
	}
	
	@Override
	public String print(){
		return power.print();
	}

	@Override
	public boolean linkTo(Outlet out) {
		return linkTo(out, new Inlet<Electricity>(new Electricity(0)));
	}

	@Override
	public boolean linkTo(Outlet out, Inlet<?> connector) {
		if (!connector.type().equals(Electricity.class)){
			return false;
		}		
		
		return this.addInlet(connector) && out.addOutlet(connector);
	}

}
