package algos.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

//Array consist of only 0's, 1's and 2's. 
//Write an algorithm to sort  this array in O(n) time complexity and
//O(1) Space complexity with only one traversal 
public class ThreeValuesArraySort {
	
	public static void main(String[] args) {
		int[] arr = {1,2,0,1,2,2,0,1,0,2,1};

		System.out.println("====== Sort result now=======");
		sortMethod(arr);		
		IntStream stream = Arrays.stream(arr);
		stream.forEach(val -> System.out.print(val + " "));
	}
	
	public static void sortMethod(int[] arr) {
		int start = 0; int end = arr.length - 1; int counter = start;
		while (counter <= end) {
			if (arr[counter] == 2) {
				// swap with the last ele, and move the end to end-1
				swap(arr, counter, end);
				end--;
			} else if (arr[counter] == 0) {
				// swap with the first ele, and move the counter to next pos
				swap(arr, counter, start);
				counter++;
				start++;
			} else if (arr[counter] == 1) {
				counter++;
			}
		}
	}
	
	public static void swap(int[] arr, int index1, int index2) {
		arr[index1] = arr[index1] + arr[index2];
		arr[index2] = arr[index1] - arr[index2];
		arr[index1] = arr[index1] - arr[index2];
	}
}
