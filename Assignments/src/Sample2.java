import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Input = [ 6, 4, 2, 8, 1, 5, 4, 6, 8, 6, 7, 6, 9]
//
//Output = [6, 6, 6, 6, 4, 4, 8, 8, 2, 1, 5, 7, 9]  

public class Sample2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[] = {6, 4, 2, 8, 1, 5, 4, 6, 8, 6, 7, 6, 9};
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 0);
			}
			else{
				int value = map.get(arr[i]);
				System.out.println(value);
				map.put(arr[i],++value);
			}
		}
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			System.out.println("key : "+entry.getKey()+"value : "+entry.getValue());
		}
		
	}
	
}
/* table a { 1 ,2 3 }
 * table b { 3,4,5}
 * 
 * Input = [ 6, 4, 2, 8, 1, 5, 4, 6, 8, 6, 7, 6, 9]

Output = [6, 6, 6, 6, 4, 4, 8, 8, 2, 1, 5, 7, 9]  


https://www.codechef.com/ide

 * 
 * inner join of a and b table = 3
 * left join of a = 1,2
 * left join of b = 4,5
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */














