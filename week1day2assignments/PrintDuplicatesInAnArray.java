package week1day2assignments;

public class PrintDuplicatesInAnArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		int l=arr.length;
		int count=0;
		for(int i=0;i<l;i++) {
			for(int j=0;j<l;j++) {
				if((arr[i]==arr[j])&& (i!=j)){
					count=count+1;
					System.out.println(arr[i]);
				}
			}
		}
	}
}
