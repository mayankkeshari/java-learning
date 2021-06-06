package algos.search;


public class BinarySearchProblems {
	
	public static void main(String[] args) {
		System.out.println("=== Finding maximum value in an inc. and then dec. array ===");
		int[] incThenDecArr = {7, 10, 19, 34, 45, 49, 65, 37, 25};
		System.out.println(findMaximumValue(incThenDecArr, 0, incThenDecArr.length-1));
		
		System.out.println("=== Finding index in a roatated array ===");
		int[] rotatedArr = {20, 30, 40, 50, 1, 2, 4, 5, 7, 8, 9, 10};
		System.out.println(searchAValueInTheRotatedArr(rotatedArr, 8, 0, rotatedArr.length-1));
	}
	
	// One array of integers is given as an input, which is initially increasing and then decreasing,
	// or it can be only increasing or decreasing , you need to find the maximum value in the array
	public static int findMaximumValue(int[] arr, int start, int end) {
		if (start == end) {
			// 1 ele array
			return arr[start];
		}

		if (start + 1 == end) {
			// 2 elem arr
			return arr[start] > arr[end] ? arr[start] : arr[end];
		}
		
		int mid = (start + end) / 2;
		if (arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]) {
			// mid on increasing slope
			return findMaximumValue(arr, mid+1, end);
		} else if (arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1]) {
			// mid on decreasing slope
			return findMaximumValue(arr, start, mid-1);
		} else {
			// this is max
			return arr[mid];
		}
	}

	// Input array is rotated at some index (i.e. arr is inc. then dropped to minimum and then again inc.)
	// Find a value in that array
	public static int searchAValueInTheRotatedArr(int[] arr, int key, int start, int end) {
		if (start > end) return -1;

		if (start == end) {
			if (arr[start] == key) {
				return start;
			} else {
				return -1;
			}
		}

		int mid = (start + end) / 2;

		if (key == arr[mid]) {
			return mid;
		}

		if (arr[mid] == key) {
			return mid;
		} 

		if (arr[start] <= arr[mid]) {
			// mid lies in the first slope
			if (key >= arr[start] && key <= arr[mid]) {
				return searchAValueInTheRotatedArr(arr, key, start, mid-1);
			} else {
				return searchAValueInTheRotatedArr(arr, key, mid+1, end);
			}
		} else {
			// mid lies in the second slope
			if (key >= arr[mid] && key <= arr[end]) {
				return searchAValueInTheRotatedArr(arr, key, mid+1, end);
			} else {
				return searchAValueInTheRotatedArr(arr, key, start, mid-1);
			}
		}
	}

}
