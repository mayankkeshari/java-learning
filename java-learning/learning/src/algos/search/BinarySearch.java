package algos.search;

public class BinarySearch {
	
	public static void main(String[] args) {
		int arr[] = {8, 9, 35, 59, 60, 89, 100, 111, 119, 139, 171, 180};
		System.out.println(binSearch(arr, 89, 0, 11));
	}
	
	static int binSearch(int []arr, int key, int low, int high) {
		if (low > high) {
			return -1;
		}
		
		int mid = low + (high-low)/2;
		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] > key) {
			return binSearch(arr, key, low, mid-1);			
		} else {
			return binSearch(arr, key, mid+1, high);
		}
	}

}
