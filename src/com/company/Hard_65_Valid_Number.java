package com.company;

/**
 * Created by biang on 2017/11/19.
 */
public class Hard_65_Valid_Number {

    public static void main(String args[]) {
        System.out.println(isNumber("1 "));
    }

    public static boolean isNumber(String s) {
        s=s.trim();
        if (s.length() == 0) return false;
        int indexE = -1;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == 'e' || a == 'E') {
                if (indexE < 0) {
                    indexE = i;
                } else return false;//排除重复E
            }
        }
        if(indexE==-1)return isNumberWithoutE(s);
        else return isNumberWithoutE(s.substring(0, indexE)) && isNumberWithoutE(s.substring(indexE + 1));
    }

    public static boolean isNumberWithoutE(String s) {
        int indexPoint = -1;
        boolean isNeg = false;
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (!(a <= 57 && a >= 48) && a != '.' && a != '-') return false;//排除其他字符
            if (a == '.') {
                if (indexPoint < 0) {
                    indexPoint = i;
                } else return false;//排除重复点
            } else if (a == '-') {
                if (i == 0) {
                    isNeg = true;
                } else return false;//负号只能出现在第一位
            }
        }
        if (indexPoint == -1) return true;
        if (isNeg) {
            if (indexPoint < 1 || indexPoint > s.length() - 1) return false;
        } else {
            if (indexPoint > s.length() - 1) return false;
        }
        return true;
    }
}
