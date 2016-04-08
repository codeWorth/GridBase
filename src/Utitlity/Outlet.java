package Utitlity;

import Utitlity.Inlets.Inlet;

public interface Outlet {	
	public void outputToAll();
	public void addInlet(Inlet in);
	public void removeInlet(Inlet in);
}
