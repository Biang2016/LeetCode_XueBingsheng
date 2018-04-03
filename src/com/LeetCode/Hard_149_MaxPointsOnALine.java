package com.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by biang on 2017/5/7.
 */
public class Hard_149_MaxPointsOnALine {

    public static void main(String args[]) {
//        Point[] points1 = new Point[6];
//        points1[0] = new Point(0, 0);
//        points1[1] = new Point(1, 1);
//        points1[2] = new Point(2, 2);
//        points1[3] = new Point(1, 2);
//        points1[4] = new Point(2, 0);
//        points1[5] = new Point(3, 0);
//        System.out.println(maxPoints(points1));
        Point[] points2 = new Point[4];
        points2[0] = new Point(3, 1);
        points2[1] = new Point(12, 3);
        points2[2] = new Point(3, 1);
        points2[3] = new Point(-6, -1);
        System.out.println(maxPoints(points2));


        Point[] points3 = new Point[]{new Point(-54, -297), new Point(-36, -222), new Point(3, -2), new Point(30, 53), new Point(-5, 1), new Point(-36, -222), new Point(0, 2), new Point(1, 3), new Point(6, -47), new Point(0, 4), new Point(2, 3), new Point(5, 0), new Point(48, 128), new Point(24, 28), new Point(0, -5), new Point(48, 128), new Point(-12, -122), new Point(-54, -297), new Point(-42, -247), new Point(-5, 0), new Point(2, 4), new Point(0, 0), new Point(54, 153), new Point(-30, -197), new Point(4, 5), new Point(4, 3), new Point(-42, -247), new Point(6, -47), new Point(-60, -322), new Point(-4, -2), new Point(-18, -147), new Point(6, -47), new Point(60, 178), new Point(30, 53), new Point(-5, 3), new Point(-42, -247), new Point(2, -2), new Point(12, -22), new Point(24, 28), new Point(0, -72), new Point(3, -4), new Point(-60, -322), new Point(48, 128), new Point(0, -72), new Point(-5, 3), new Point(5, 5), new Point(-24, -172), new Point(-48, -272), new Point(36, 78), new Point(-3, 3)};
        System.out.println(maxPoints(points3));
    }

    public static int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private static int generateGCD(int a, int b) {

        if (b == 0) return a;
        else return generateGCD(b, a % b);

    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
