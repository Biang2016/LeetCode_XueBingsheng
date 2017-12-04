package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by biang on 2017/11/18.
 */
public class Medium_210_CourseScheduleII_DFS {
    public static void main(String args[]) {
        int[] aa = findOrder(3, new int[][]{{1, 0}});
    }

    //BFS
    //采用Hashmap<Integer, Arraylist<Integer>>的数据结构运行时间11ms
    //采用Arraylist[]的数据结构运行时间11ms
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        isExplored = new int[numCourses];
        courseOrdering = new int[numCourses];
        current_label = numCourses - 1;

        //初始化
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        //生成图
        for (int[] pair : prerequisites) {
            graph[pair[1]].add(pair[0]);
        }

        //遍历节点
        for (int i = 0; i < numCourses; i++) {
            if (isExplored[i] != 1 && graph[i].size() != 0) {
                if (!DFS(graph, i)) return new int[]{};
            }
        }

        //写出顺序
        int countIndependentCourse = 0;
        for (int i = 0; i < numCourses; i++) {
            if (isExplored[i] != 1) {
                courseOrdering[countIndependentCourse] = i;//如果没探索过，肯定为单独课程
                countIndependentCourse++;
            }
        }

        return courseOrdering;
    }

    private static int current_label;
    private static int[] courseOrdering;
    private static int[] isExplored;//0-unexplored, 1- explored, -1-descendantVisiting

    public static boolean DFS(ArrayList[] graph, int s) {
        isExplored[s] = -1;
        for (int i = 0; i < graph[s].size(); i++) {
            int seniorNode = (int) graph[s].get(i);
            if (isExplored[seniorNode] == 0) {
                if (!DFS(graph, seniorNode)) return false;
            } else if (isExplored[seniorNode] == -1)
                return false;
        }
        isExplored[s] = 1;
        courseOrdering[current_label] = s;
        current_label--;
        return true;
    }


}
