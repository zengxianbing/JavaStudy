package leetcode;

public class Quicksort_Array {

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}

		}

		if (low < j)
			quickSort(arr, low, j);
		if (high > i)
			quickSort(arr, i, high);
	}

	public static void printArray(int[] x) {
		for (int a : x) {
			System.out.println(a + " ");
		}
		System.out.println();
	}
}
