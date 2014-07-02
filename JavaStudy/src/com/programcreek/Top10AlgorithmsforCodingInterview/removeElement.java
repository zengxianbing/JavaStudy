package com.programcreek.Top10AlgorithmsforCodingInterview;

public class removeElement {

	public int removeElement(int[] A, int elem) {

		if (A.length == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[count] = A[i];
				count++;
			}
		}
		return count;
	}

	public int removeElement1(int[] A, int elem) {
		int i = 0, j = A.length - 1;

		while (i <= j) {
			if (A[i] == elem)
				swap(A, i, j--);

			else
				i++;

		}
		return j + 1;
	}

	public void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
