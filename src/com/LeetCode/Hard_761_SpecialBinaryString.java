package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by biang on 2018/1/16.
 */
public class Hard_761_SpecialBinaryString {
    public static void main(String args[]) {
        System.out.println(makeLargestSpecial("11011000"));
    }

    public static String makeLargestSpecial(String S) {
        char[] chars = S.toCharArray();

        int[] MH = new int[chars.length];
        MH[0] = 1;
        int curMax = 1;
        List<Mountain> Ms = new ArrayList<>();
        for (int i = 1; i < chars.length; i++) {
            MH[i] = chars[i] == '1' ? MH[i - 1] + 1 : MH[i - 1] - 1;
            if (MH[i] > curMax) {
                curMax = MH[i];
            }
            if (MH[i] == 0) {
                Mountain newM = new Mountain();
                newM.height = curMax;
                newM.start = Ms.isEmpty() ? 0 : Ms.get(Ms.size() - 1).end + 1;
                newM.end = i;
                newM.string = S.substring(newM.start, newM.end + 1);
                newM.subMountainSort(MH);

                Ms.add(newM);
                curMax = 0;
            }
        }

        Mountain[] m_array = new Mountain[Ms.size()];
        for (int i = 0; i < m_array.length; i++) {
            m_array[i] = Ms.get(i);
        }
        Arrays.sort(m_array);
        StringBuilder sb = new StringBuilder();
        for (Mountain m : m_array) {
            sb.append(m.string);
        }
        return sb.toString();
    }

    static class Mountain implements Comparable<Mountain> {
        int height;
        int start;
        int end;
        String string;

        public int compareTo(Mountain m) {
//            for (int i = 0; i < Math.min(string.length(), m.string.length()); i++) {
//                if (string.charAt(i) > m.string.charAt(i)) return -1;
//                else if (string.charAt(i) < m.string.charAt(i)) return 1;
//            }
            return -string.compareTo(m.string) ;
        }

        //Side effect: change this.string to optimal one.
        public void subMountainSort(int[] MH) {
            int[] mh = new int[end - start + 1];

            int curMinBottom = 0;
            for (int i = 0; i < mh.length; i++) {
                mh[i] = MH[i + start];
            }
            for (int i = 0; i < mh.length; i++) {
                if (i >= 1 && i <= mh.length - 2 && mh[i] < mh[i - 1] && mh[i] < mh[i + 1]) {
                    if (curMinBottom == 0) curMinBottom = mh[i];
                    else curMinBottom = Math.min(curMinBottom, mh[i]);
                }
            }

            if (curMinBottom == 0) return;
            else
                string = string.substring(0, curMinBottom) + makeLargestSpecial(string.substring(curMinBottom, string.length() - curMinBottom)) + string.substring(string.length() - curMinBottom, string.length());
        }

    }


    //大神解法
    public String makeLargestSpecial2(String S) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<String>();
        for (int j = 0; j < S.length(); ++j) {
            if (S.charAt(j) == '1') count++;
            else count--;
            if (count == 0) {
                res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');   //通过每次至少降一阶来递归迭代很快就有结果！！关键步骤
                i = j + 1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());                //根本无需计算山的高度、跨度，以及山的比较，因为山本身的string即有大小值，可以直接比较string
        return String.join("", res);
    }

    //每次时间为n，n-2，n-4，…… 时间复杂度n平方
}
