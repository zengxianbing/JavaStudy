package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Interleaving_String {

	public boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();

		if (l1 + l2 != l3)
			return false;
		if (l3 == 0)
			return true;

		boolean[][] isInter = new boolean[l1 + 1][l2 + 1];

		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				int k = i + j;
				if (k == 0) {
					isInter[i][j] = true;
					continue;
				}

				if (i > 0 && s1.charAt(i - 1) == s3.charAt(k - 1))
					isInter[i][j] |= isInter[i - 1][j];

				if (j > 0 && s2.charAt(j - 1) == s3.charAt(k - 1))
					isInter[i][j] |= isInter[i][j - 1];

			}
		}

		return isInter[l1][l2];
	}

}
