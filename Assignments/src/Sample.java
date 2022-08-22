import java.util.Arrays;
import java.util.Scanner;

//Input = [ 6, 4, 2, 8, 1, 5, 4, 6, 8, 6, 7, 6, 9]
//
//Output = [6, 6, 6, 6, 4, 4, 8, 8, 2, 1, 5, 7, 9]  

public class Sample {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[] = {6, 4, 2, 8, 1, 5, 4, 6, 8, 6, 7, 6, 9};
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		int cnt = sortByFrequence(arr,n);	
		sortArray(arr);
		printSortedArray(arr, cnt);
	}
	
	public static void sortArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static int sortByFrequence(int arr[], int n) {
		// initilaize maxE=-1;
		int maxE = -1;
		
		// Find the maximum element of arr[]
		for(int i=0; i<n; i++) {
			maxE = Math.max(maxE, arr[i]);
		}
		
		//create frequency array freq[]
		int freq[] = new int[maxE+1];
		
		//per the occurence of element in arr[]
		for(int i=0; i<n; i++) {
			freq[arr[i]]++;
		}
		System.out.println("frequency array : "+Arrays.toString(freq));
		
		int cnt = 0;
		for (int i = 0; i <= maxE; i++) {
			if(freq[i] > 0) {
				int value = 10000-i; // 9999
				arr[cnt] = 10000 * freq[i] + value; 
				cnt++;
			}
		}
		System.out.println("frequency array1 : "+Arrays.toString(arr));
		return cnt;
	}
	
	static void printSortedArray(int arr[], int cnt) {
		for(int i=0; i<cnt; i++) {
			int frequency = arr[i] / 10000;
			int value = 10000 - (arr[i]%10000);
			for(int j=0; j<frequency; j++) {
				System.out.print(value+" ");
			}
		}
	}

}
