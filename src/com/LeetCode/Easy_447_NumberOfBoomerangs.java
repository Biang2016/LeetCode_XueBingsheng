package com.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by biang on 2017/5/11.
 */
public class Easy_447_NumberOfBoomerangs {
    public static void main(String args[]) {
        int[][] in = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(in));
    }

    //146ms,根本就不需要记录矩阵，直接算一个记录一个即可。
    public static int My_numberOfBoomerangs(int[][] points) {
        int[][] matrix = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                matrix[i][j] = dx * dx + dy * dy;
                matrix[j][i] = matrix[i][j];
            }
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        int total = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) continue;
                if (countMap.containsKey(matrix[i][j])) {
                    total += countMap.get(matrix[i][j]);
                    countMap.put(matrix[i][j], countMap.get(matrix[i][j]) + 1);
                } else countMap.put(matrix[i][j], 1);
            }
            countMap.clear();
        }
        return total*2;
    }

    //107ms
    public static int numberOfBoomerangs(int[][] points) {
        int res=0;
        HashMap<Integer,Integer>map= new HashMap<Integer,Integer>();
        for(int[]i:points){
            for(int[]j:points){
                int dis=(i[0]-j[0])*(i[0]-j[0])+(i[1]-j[1])*(i[1]-j[1]);
                int numbers = map.containsKey(dis)?map.get(dis):0;
                res+=numbers*2;
                map.put(dis,numbers+1);
            }
            map.clear();//Do not forget this
        }
        return res;
    }
}
