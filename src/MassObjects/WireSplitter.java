package MassObjects;

import MasslessObjects.Electricity;
import Utitlity.Inlet;

public class WireSplitter extends Wire {

	public WireSplitter(int _x, int _y) {
		super(_x, _y);
	}

	@Override
	public void outputToAll() {
		int outletsLength = outlets.size();
		double amountPer = power.amount/outletsLength;
		
		power.empty();
		
		for (Inlet<?> outlet : outlets){
				Inlet<Electricity> thisOutlet = (Inlet<Electricity>) outlet;
				thisOutlet.addToStore(new Electricity(amountPer));
		}
	}
	
	@Override
	protected boolean shouldAddOutlet() {
		return true;
	}
}
