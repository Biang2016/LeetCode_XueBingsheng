package com.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by biang on 2017/11/18.
 */
public class Medium_210_CourseScheduleII_BFS {
    public static void main(String args[]) {
        int[] aa = findOrder(3, new int[][]{{1, 0},{2, 1}});
    }

    //BFS
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int exploreCount = 0;
        int[] courseOrdering = new int[numCourses];
        int[] indegree = new int[numCourses];
        int current_label = 0;
        Queue<Integer> q = new LinkedList<Integer>();

        //初始化
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        //生成图
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
            graph[pair[1]].add(pair[0]);
        }

        //遍历节点
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int s = q.poll();
            exploreCount++;
            courseOrdering[current_label++] = s;
            for (int i = 0; i < graph[s].size(); i++) {
                indegree[(int) graph[s].get(i)]--;
                if (indegree[(int) graph[s].get(i)]==0) q.offer((int) graph[s].get(i));
            }
        }


        if (exploreCount < numCourses) return new int[0];

        return courseOrdering;
    }


}
