package MassObjects;

import MasslessObjects.Electricity;
import MasslessObjects.Wood;
import Utitlity.Connection;
import Utitlity.Inlet;
import Utitlity.Outlet;

public class WoodGenerator extends Connection{		
	private Wood fuel = new Wood(0);
	
	public WoodGenerator(int _x, int _y){
		super(_x, _y, 2, 2);
	}
	
	@Override
	protected void intakeAll(){
		for (Inlet<?> inlet : inlets){
			if (inlet.type().equals(Wood.class)){
				Inlet<Wood> thisInlet = (Inlet<Wood>) inlet;
				fuel.add(thisInlet.removeStore());
			}
		}
	}
	
	@Override
	public void outputToAll() {
		double energyAmount = fuel.amount * Wood.energyPerAmount;
		int outletsLength = outlets.size();
		double amountPer = energyAmount/outletsLength;
		
		for (Inlet<?> outlet : outlets){
				Inlet<Electricity> thisOutlet = (Inlet<Electricity>) outlet;
				thisOutlet.addToStore(new Electricity(amountPer));
		}
	}
	
	@Override
	public double print(){
		return 1;
	}

	@Override
	public boolean handleAddInlet(Inlet<?> in) {
		if (in.type().equals(Wood.class)){
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
	protected boolean shouldAddInlet() {
		return true;
	}

	@Override
	protected boolean shouldAddOutlet() {
		return true;
	}

	@Override
	public boolean canTransferFrom(Outlet from) {
		return adjacentTo(from);
	}

	@Override
	public boolean linkTo(Outlet out) {
		return linkTo(out, new Inlet<Wood>(new Wood(0)));
	}

	@Override
	public boolean linkTo(Outlet out, Inlet<?> connector) {
		if (!connector.type().equals(Wood.class)){
			return false;
		}		
		
		return this.addInlet(connector) && out.addOutlet(connector);
	}
	 
}
