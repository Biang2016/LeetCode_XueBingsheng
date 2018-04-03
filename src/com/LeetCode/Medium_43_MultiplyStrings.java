package com.LeetCode;

/**
 * Created by biang on 2018/1/17.
 */
public class Medium_43_MultiplyStrings {

    public static void main(String args[]) {
        System.out.println(multiply("123", "456"));
    }


    //该题相继被ACM、华为、腾讯等选作笔试、面试题，笔者2014年替师兄去腾讯笔试就遇到此题，
    // 当然若无准备要写出这种程序，还是要花一定的时间的。觉得有必要深入研究一下。
    // 搜索了网上的大多数该类程序和算法，发现，大数乘法主要有模拟手工计算的普通大数乘法，分治算法和FFT算法。
    // 其中普通大数乘法占据了90%以上，其优点是空间复杂度低，实现简单，时间复杂度为O（N²）
    // 分治算法虽然时间复杂度降低为,O（N^1.59），但其实现需要配 合字符串模拟加减法操作，实现较为复杂。
    public static String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0 || num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.length() == 1 && num2.length() == 1) {
            return Integer.toString(Integer.parseInt(num1) * Integer.parseInt(num2));
        } else {
            int n1 = num1.length();
            int n2 = num2.length();
            if (n1 > n2) return multiply(num2, num1);
            else if (n1 < n2) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n2 - n1; i++) {
                    sb.append(0);
                }
                return addStringInt(multiply(num1, num2.substring(0, n1)) + sb.toString(), multiply(num1, num2.substring(n1)));
            } else {//n1=n2
                int exp = n1 - n1 / 2;
                String a = num1.substring(0, n1 / 2);
                String b = num1.substring(n1 / 2);
                String c = num2.substring(0, n2 / 2);
                String d = num2.substring(n2 / 2);
                String ac = multiply(a, c);
                String bd = multiply(b, d);
                String ad_bc = subtractStringInt(multiply(addStringInt(a, b), addStringInt(c, d)), addStringInt(ac, bd));

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < exp; i++) {
                    sb.append(0);
                }
                String zeros = sb.toString();
                if (!ac.equals("0")) ac += zeros + zeros;
                if (!ad_bc.equals("0")) ad_bc += zeros;
                return addStringInt(addStringInt(ac, ad_bc), bd);
            }
        }
    }

    public static String addStringInt(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "0";
        if (num1.length() > num2.length()) return addStringInt(num2, num1);
        int n = num1.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int sum = num1.charAt(num1.length() - i - 1) - '0' + num2.charAt(num2.length() - i - 1) - '0' + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 10);
        }
        for (int i = n; i < num2.length(); i++) {
            int sum = num2.charAt(num2.length() - i - 1) - '0' + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 10);
        }
        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }


    //字符串模拟减法操作
    static String subtractStringInt(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "0";

        //正负数转换
        if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            return '-' + addStringInt(num1.substring(1), num2);
        } else if (num1.charAt(0) != '-' && num2.charAt(0) == '-') {
            return addStringInt(num1, num2.substring(1));
        } else if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            return subtractStringInt(num2.substring(1), num1.substring(1));
        } else {//x是正数，y也是正数
            int flag = comparePositiveInt(num1, num2);
            if (flag == 0) {
                return "0";
            } else if (flag == -1) {
                return "-" + subtractStringInt(num2, num1);
            } else {//x>y
                //y补0
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < num1.length() - num2.length(); i++) {
                    sb.append(0);
                }
                num2 = sb.toString() + num2;

                StringBuilder resSB = new StringBuilder();
                int borrow = 0;
                for (int i = num1.length() - 1; i >= 0; i--) {
                    int difference = num1.charAt(i) - num2.charAt(i) - borrow;
                    if (difference < 0) {
                        difference += 10;
                        borrow = 1;
                    } else borrow = 0;
                    resSB.append(difference);
                }
                String res = resSB.reverse().toString();
                while (res.charAt(0) == '0') res = res.substring(1);
                return res;
            }
        }
    }

    //比较大小
    static int comparePositiveInt(String x, String y) {
        if (x.length() > y.length()) {
            return 1;
        } else if (x.length() < y.length()) {
            return -1;
        } else {
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) > y.charAt(i)) {
                    return 1;
                } else if (x.charAt(i) < y.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
