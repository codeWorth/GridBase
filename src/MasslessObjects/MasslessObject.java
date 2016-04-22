package MasslessObjects;

public abstract class MasslessObject{
	public double amount = 0;
	
	public boolean add(MasslessObject other){
		if (other.getClass().equals(this.getClass())){
			this.amount += other.amount;
			return true;
		} else {
			return false;
		}
	}
	
	public MasslessObject(double _amount){
		amount = _amount;
	}
	
	public MasslessObject empty(){
		MasslessObject temp = (MasslessObject) this.clone();
		this.amount = 0;
		return temp;
	}
	
	public MasslessObject clone(){
		
	}
}