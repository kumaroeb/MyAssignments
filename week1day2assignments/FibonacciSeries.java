package week1day2assignments;

public class FibonacciSeries {
	public static void main(String[] args)
	{
		int range=8,firstNum=0,secNum=1,sum;
		System.out.println(firstNum+ "" +secNum);
		for(int i=2;i<range;++i)
		{
			sum=firstNum+secNum;
			System.out.println(""+sum);
			firstNum=secNum;
			secNum=sum;
		}
		
		
	}
}
