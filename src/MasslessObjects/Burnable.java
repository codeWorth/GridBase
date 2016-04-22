package MasslessObjects;

public class Burnable extends MasslessObject{
	public static final double energyPerAmount = 1;
	public static final double weight = 1;
	
	public Burnable(double _amount){
		super(_amount);
	}
	
	@Override
	public Burnable empty() {
		Burnable temp = new Burnable(this.amount);
		this.amount = 0;
		return temp;
	}
}
