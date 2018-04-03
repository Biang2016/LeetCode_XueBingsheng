package com.LeetCode;

/**
 * Created by biang on 2018/1/17.
 */
public class Easy_67_AddBinary {

    public String addBinary(String a, String b) {
        if (a.length() > b.length()) return addBinary(b, a);
        int n = a.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int sum = a.charAt(a.length() - i - 1) - '0' + b.charAt(b.length() - i - 1) - '0' + carry;
            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 2);
        }
        for (int i = n; i < b.length(); i++) {
            int sum = b.charAt(b.length() - i - 1) - '0' + carry;
            if (sum >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 2);
        }
        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
