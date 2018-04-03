package com.LeetCode;

import java.util.*;

/**
 * Created by biang on 2018/1/16.
 */
public class Medium_763_PartitionLabels {
    //10:26

    public static void main(String args[]) {
        List<Integer> res = partitionLabels("abcabcefgefg");
        for (Integer num : res) {
            System.out.println(num);
        }
    }

    //43ms
    public static List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        char[] chars = S.toCharArray();
        List<HashSet<Character>> lh = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            boolean isContain = false;
            for (int lhIndex = 0; lhIndex < lh.size(); lhIndex++) {
                HashSet<Character> h = lh.get(lhIndex);
                if (h.contains(chars[i])) {
                    int mergeTime = lh.size() - lhIndex;
                    int sum = 0;
                    for (int m = 0; m < mergeTime; m++) {
                        sum += stack.pop();
                    }
                    sum++;
                    stack.push(sum);

                    for (int removeHashIndex = lhIndex + 1; removeHashIndex < lh.size(); ) {
                        HashSet<Character> remH = lh.remove(removeHashIndex);
                        for (Character ch : remH) {
                            lh.get(lhIndex).add(ch);
                        }
                    }
                    isContain = true;
                    break;
                }
            }
            if (!isContain) {
                stack.push(1);
                HashSet<Character> newH = new HashSet<>();
                newH.add(chars[i]);
                lh.add(newH);
            }
        }

        Stack<Integer> rev_stack = new Stack<>();
        while (!stack.isEmpty()) {
            rev_stack.add(stack.pop());
        }

        List<Integer> res = new LinkedList<>();
        while (!rev_stack.isEmpty()) {
            res.add(rev_stack.pop());
        }
        return res;
    }

    //大神解法 18ms
    public List<Integer> partitionLabels2(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if (last == i) {   //此步很重要！如果last==i说明可以截断了
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }
}
