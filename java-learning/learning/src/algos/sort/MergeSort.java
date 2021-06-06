package algos.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {
	
	// Merge 2 sorted arrays into one array
	private static void merge(int[] arr, int[] result, int low, int mid, int high) {
		int i = low, j = mid+1, k = low;
		while (i <= mid && j <= high) {
			// Compare and merge individual items till one of the array is exhausted
			if (arr[i] <= arr[j]) {
				result[k++] = arr[i++];
			} else {
				result[k++] = arr[j++];
			}
		}

		// Copy leftovers if any
		while (i <= mid) {
			result[k++] = arr[i++];
		}
		while (j <= high) {
			result[k++] = arr[j++];
		}

		// Update the original array
		for (i=low; i<high; i++) {
			arr[i] = result[i];
		}
	}

	private static void mergeSort(int[] arr, int[] sortedArr, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			// Single element
			return;
		}

		// Break the array into 2 half arrays
		int midIndex = (startIndex + endIndex) / 2;
		mergeSort(arr, sortedArr, startIndex, midIndex);
		mergeSort(arr, sortedArr, midIndex + 1, endIndex);

		//merge
		merge(arr, sortedArr, startIndex, midIndex, endIndex);
	}

	public static void main(String[] args) {
		System.out.println("====== Merge Sort result now=======");
		
		//Merge sort - Sort an array using 2-way merge
		int[] unsortedArr = {45, 78, 50, 67, 9, 49, 39, 77, 67, 20, 69, 75, 99};
		int[] sortedArr = new int[unsortedArr.length];
		mergeSort(unsortedArr, sortedArr, 0, unsortedArr.length - 1);
		IntStream stream2 = Arrays.stream(sortedArr);
		stream2.forEach(val -> System.out.print(val + " "));
		
	}

}
