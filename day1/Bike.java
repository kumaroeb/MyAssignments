package week1.day1;

public class Bike {
	String applyBreak;
	String soundHorn;

	public static void main(String[] args) {
		
		Car obj=new Car();
		obj.applyBreak();
		obj.soundHorn();
		Bike obj1=new Bike();
		obj1.applyBreak();
		obj1.soundHorn();
		
	}
	public void applyBreak()
	{
		System.out.println("Applied Break");
	}
	public void soundHorn()
	{
		System.out.println("Sound Horn");
	}

}
