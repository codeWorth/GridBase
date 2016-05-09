package Utitlity;

import java.util.ArrayList;

import Grid.Grid;
import MassObjects.MassObject;

public abstract class Outlet extends MassObject{	

	public Outlet(int _x, int _y, int _width, int _height) {
		super(_x, _y, _width, _height);
	}

	protected ArrayList<Inlet<?>> outlets = new ArrayList<Inlet<?>>();
	
	protected abstract boolean handleAddOutlet(Inlet<?> out);
	protected abstract boolean shouldAddOutlet();
	public abstract void outputToAll();
	
	public boolean remove(Inlet<?> out){
		return outlets.remove(out);
	}
	
	public boolean addOutlet(Inlet<?> out){
		if (!shouldAddOutlet()){
			return false;
		}
		
		boolean didAdd = out.addOwner(this);
		if (!didAdd){
			return false;
		} else {
			return handleAddOutlet(out);
		}
	}
	
	public boolean shouldRemove(Inlet<?> out){
		return out.removeThis();
	}
	/**
	 * @return A list of MassObjects which should be updated together later. Primarily for use within update()
	 */
	protected ArrayList<MassObject> allToPropagte(){
		ArrayList<MassObject> others = new ArrayList<MassObject>();
		
		for (Inlet<?> out : outlets){
			others.add(out.toPropagte());
		}
		
		return others;
	}
	
	@Override
	public ArrayList<MassObject> update(){
		outputToAll();
		
		return allToPropagte();
	}
}
