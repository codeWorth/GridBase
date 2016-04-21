package Utitlity;

import java.util.ArrayList;

import Inlets.Inlet;

public class InletList{
	private ArrayList<Inlet> inlets;
	private Class wantedClass;
	
	public InletList(Class<? extends Inlet> _wantedClass){
		inlets = new ArrayList<Inlet>();
		wantedClass = _wantedClass;
	}
	
	public boolean add(Inlet obj){
		inlets.add(obj);
	}
	
	private boolean isCorrectType(Inlet obj){
		return obj.getClass().equals(wantedClass.toString());
	}
	
}
