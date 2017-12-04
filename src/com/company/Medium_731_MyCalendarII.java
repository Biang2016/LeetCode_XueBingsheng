package com.company;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by biang on 2017/12/4.
 */
public class Medium_731_MyCalendarII {


    public static void main(String args[]) {
        Medium_731_MyCalendarII m = new Medium_731_MyCalendarII();
        m.book(10, 20);
        m.book(50, 60);
        m.book(10, 40);
        m.book(5, 15);
        m.book(5, 10);
        m.book(25, 55);
    }

    //14:05
    public Medium_731_MyCalendarII() {
        booking = new LinkedList<>();
    }

    LinkedList<int[]> booking;


    public boolean book(int start, int end) {
        Medium_729_MyCalendarI calendar=new Medium_729_MyCalendarI();//此处务必每次循环初始化一次，因为下面的循环需要一个空的树检查重叠
        for (int[] p : booking)
            if (Math.max(p[0], start) < Math.min(p[1], end))
                if (!calendar.book(Math.max(p[0], start), Math.min(p[1], end))) return false;
        booking.add(new int[]{start, end});
        return true;
    }


    class Medium_729_MyCalendarI {
        public Medium_729_MyCalendarI() {
            calendar = new TreeMap<>();
        }

        TreeMap<Integer, Integer> calendar;

        public boolean book(int start, int end) {
            Integer floorKey = calendar.floorKey(start);
            if (floorKey != null && calendar.get(floorKey) > start) return false;
            Integer ceilingKey = calendar.ceilingKey(start);
            if (ceilingKey != null && ceilingKey < end) return false;
            calendar.put(start, end);
            return true;
        }
    }

}
