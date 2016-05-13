package Utitlity;

import java.util.ArrayList;

import MassObjects.MassObject;

public abstract class Connection extends Outlet {	
	public Connection(int _x, int _y, int _width, int _height) {
		super(_x, _y, _width, _height);
	}
		
	protected ArrayList<Inlet<?>> inlets = new ArrayList<Inlet<?>>();
	
	protected abstract boolean handleAddInlet(Inlet<?> in);
	protected abstract boolean shouldAddInlet();
	protected abstract void intakeAll();
	
	public abstract boolean canTransferFrom(Outlet from);
	
	public abstract boolean linkTo(Outlet out);
	public abstract boolean linkTo(Outlet out, Inlet<?> connector);
	
	@Override
	public boolean remove(Inlet<?> inlet){
		return (super.remove(inlet) || inlets.remove(inlet));
	}
	
	public boolean addInlet(Inlet<?> in){
		if (!shouldAddInlet()){
			return false;
		}
		
		boolean didAdd = in.addOwner(this);
		if (!didAdd){
			return false;
		} else {
			return handleAddInlet(in);
		}
	}
	
	@Override
	public ArrayList<MassObject> update(){
		outputToAll();
		intakeAll();
		
		return allToPropagte();
	}
}
