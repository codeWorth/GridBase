package Utitlity;

import Inlets.Inlet;

public interface Outlet {	
	public void outputToAll();
	public void addOutlet(Inlet out);
	public void removeOutlet(Inlet out);
}
