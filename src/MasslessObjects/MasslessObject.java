package MasslessObjects;

public class MasslessObject{
	public double amount = 0;
	
	public boolean add(MasslessObject other){
		if (other.getClass().equals(this.getClass())){
			this.amount += other.amount;
			return true;
		} else {
			return false;
		}
	}
	
	public MasslessObject(){
	}
	
	public MasslessObject(double _amount){
		amount = _amount;
	}
}