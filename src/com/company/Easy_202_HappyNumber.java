package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biang on 2017/5/8.
 */
public class Easy_202_HappyNumber {
    public static void main(String args[]) {
        System.out.println(My_isHappy(10));
        System.out.println(My_isHappy(10));
        System.out.println(My_isHappy(10));
    }

    private static List<Integer> record = new ArrayList<>();

    //6ms
    public static boolean My_isHappy(int n) {
        if (n == 1) {
            record.clear();
            return true;
        }
        if (record.contains(n)) return false;
        List<Integer> nList = new ArrayList<>();
        record.add(n);
        while (n > 0) {
            nList.add(n % 10);
            n /= 10;
        }
        n = 0;
        for (int ns : nList)
            n += ns * ns;
        return My_isHappy(n);
    }

    //2ms
    public boolean isHappy1(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }

    //1ms
    public boolean isHappy2(int n) {
        int i = findHappy(n, 0);
        if (i == 1){
            return true;
        }
        return false;
    }

    public int findHappy(int n, int i){
        if (i > 10){
            return n;
        }
        int sum = 0;
        while (n != 0){
            int temp = n%10;
            sum += temp*temp;
            n /= 10;
        }
        return findHappy(sum, i+1);
    }
}
