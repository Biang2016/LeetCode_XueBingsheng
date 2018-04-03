package com.LeetCode;

/**
 * Created by biang on 2017/11/29.
 */
public class Medium_474_OnesandZeroes {
    public static void main(String args[]) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm2(strs, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] strMN = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            for (char c : chars) {
                if (c == '0') strMN[i][0]++;
                else strMN[i][1]++;
            }
        }

        int[][][] A = new int[strs.length][m + 1][n + 1];
        for (int im = 0; im <= m; im++) {
            for (int in = 0; in <= n; in++) {
                if (im < strMN[0][0] || in < strMN[0][1]) {
                    A[0][im][in] = 0;
                } else A[0][im][in] = 1;
            }
        }
        for (int is = 1; is < strs.length; is++) {
            for (int im = 0; im <= m; im++) {
                for (int in = 0; in <= n; in++) {
                    if (im >= strMN[is][0] && in >= strMN[is][1])
                        A[is][im][in] = Math.max(A[is - 1][im][in], A[is - 1][im - strMN[is][0]][in - strMN[is][1]] + 1);
                    else A[is][im][in] = A[is - 1][im][in];
                }
            }
        }

        return A[strs.length - 1][m][n];
    }

    public static int findMaxForm2(String[] strs, int m, int n) {
        int[][] A = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            int numZeros = 0;
            int numOnes = 0;
            for (char c : chars) {
                if (c == '0') numZeros++;
                else numOnes++;
            }
            // from the first few strings up to the current string s
            // Catch: have to go from bottom right to top left
            for (int im = m; im >= numZeros; im--) {
                for (int in = n; in >= numOnes; in--) {
                    A[im][in] = Math.max(A[im][in], A[im - numZeros][in - numOnes] + 1);
                }
            }
        }

        return A[m][n];
    }
}
