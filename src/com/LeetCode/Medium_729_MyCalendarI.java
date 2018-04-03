package com.LeetCode;

import java.util.TreeMap;

/**
 * Created by biang on 2017/12/4.
 */
public class Medium_729_MyCalendarI {

//    public static void main(String args[]) {
//
//    }
//
//
//    public Medium_729_MyCalendarI() {
//        bookings = new LinkedList<>();
//    }
//
//    LinkedList<Integer[]> bookings;
//
//    public boolean book(int start, int end) {
//        for (Integer[] book : bookings) {
//            if ((start >= book[0] && start <= book[1]) | (end - 1 >= book[0] && end - 1 <= book[1])) return false;
//            else if (start < book[0] && end > book[1]) return false;
//        }
//        bookings.addStringInt(new Integer[]{start, end - 1});
//        return true;
//    }

    //采用TreeMap，精妙！线性时间
    TreeMap<Integer, Integer> calendar;

    public Medium_729_MyCalendarI() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start) return false;
        Integer ceilingKey = calendar.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;

        calendar.put(start, end);
        return true;
    }

}
