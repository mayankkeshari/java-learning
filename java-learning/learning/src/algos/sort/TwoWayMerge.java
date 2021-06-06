package algos.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TwoWayMerge {
	
	// Merge 2 sorted arrays into one array
	private static void merge(int[] arr1, int[] arr2, int[] result) {
		int m = arr1.length;
		int n = arr2.length;
		int i = 0, j = 0, k = 0;

		while (i < m && j < n) {
			// Compare individual items till one of the array is exhausted
			if (arr1[i] < arr2[j]) {
				result[k++] = arr1[i++];
			} else {
				result[k++] = arr2[j++];
			}
		}

		// Copy leftovers if any
		for (;i < m; i++) {
			result[k++] = arr1[i];
		}
		for (;j < n; j++) {
			result[k++] = arr2[j];
		}
	}
	
	public static void main(String[] args) {
		//Input - 2 sorted arrays
		int[] arr1 = {5, 35, 50, 68, 70, 85};
		int[] arr2 = {2, 6, 35, 40, 49, 58, 72, 80, 84, 97};
		int[] mergedResult = new int [arr1.length + arr2.length];
		merge(arr1, arr2, mergedResult); // Merge 2 sorted arrays
		
		System.out.println("====== 2-way Merge result now=======");
		IntStream stream = Arrays.stream(mergedResult);
		stream.forEach(val -> System.out.print(val + " "));
	}

}
