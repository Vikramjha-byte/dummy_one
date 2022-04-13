package demo;

import java.util.Arrays;

public class UniqueNumbers {
	static int count=0;
	public static void main(String[] args) {
		int[] numberSeries={1,3,2,4,3,2,4,5,3,6,8,3};
		uniqueNumbers(numberSeries);
	}

	private static void uniqueNumbers(int[] numberSeries) {
		// TODO Auto-generated method stub
		Arrays.sort(numberSeries);
		System.out.println("The unique element in the series are : ");
		int count=1;
		for(int i=0;i<numberSeries.length;i++) {//{1,3,2,4,3,2,4,5,3,6,8,3}
			if(count>1) {
				count=1;
				continue;
			}
			
			// initialized count variable as 1
			for(int j=i+1;j<numberSeries.length;j++) {
				if(numberSeries[i]==numberSeries[j]) {// comparing the element with its next element
					//visited[j]=true; // same element found, hence visited[j]=true
					count++; //count increased by 1
				}
				
			}
			if(count==1) {
				System.out.print(numberSeries[i]+ " ");
			}
		}
	}
}
