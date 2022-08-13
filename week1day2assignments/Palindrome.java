package week1day2assignments;

public class Palindrome {
	public static void main(String[] args) 
	{
		int num=34343,temp,rev,rem;
		temp=num;
		{
		for(rev=0;num>0;num/=10)
		{
			rem=num%10;
			rev=(rev*10)+rem;
		}
		
		if(rev==temp)
		{
			System.out.println("The given number is palindrome");
		}
		else
		{
			System.out.println("The given number is not palindrome");
		}
		}
}

}
