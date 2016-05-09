package MasslessObjects;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class MasslessObject{
	public double amount = 0;
	protected final double maxTransfer = 3;
	
	public MasslessObject(double _amount){
		amount = _amount;
	}
	
	public boolean add(MasslessObject other){
		if (other.getClass().equals(this.getClass())){
			this.amount += other.amount;
			return true;
		} else {
			return false;
		}
	}
	
	public MasslessObject empty(){
		MasslessObject temp = this.clone();
		if (this.amount > maxTransfer){
			temp.amount = maxTransfer;
			this.amount -= maxTransfer;
		} else {
			this.amount = 0;
		}
		return temp;
	}
	
	public MasslessObject clone(){
		Constructor<? extends MasslessObject> ctor;
		try {
			ctor = this.getClass().getConstructor(double.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
		
		MasslessObject myClone;
		try {
			myClone = ctor.newInstance(this.amount);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
		
		return myClone;
	}
}