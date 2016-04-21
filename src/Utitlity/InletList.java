package Utitlity;

import java.util.ArrayList;

import Inlets.Inlet;

public class InletList{
	private ArrayList<?> inlets;
	
	public <E extends Inlet> InletList(){
		inlets = new ArrayList<E>();
	}
	
	public boolean add(Inlet obj){
		inlets.add(obj);
	}
	
}
