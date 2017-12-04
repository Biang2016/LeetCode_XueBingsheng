package com.company;

import java.util.*;

/**
 * Created by biang on 2017/5/10.
 */
public class Medium_207_Course_Schedule {

    //一个变量的变化会使另一个变量发生改变从而发生计算，用栈来做,54ms
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++;
            matrix[pre][ready] = 1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0)
                stack.push(i);
        int count = 0;
        while (!stack.isEmpty()) {
            int column = stack.pop();
            count++;
            for (int i = 0; i < matrix[column].length; i++) {
                if (matrix[column][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        stack.push(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

    //4ms
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        int[] visited = new int[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0 && !dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, int[] visited, int course){
        if(visited[course] == 1)
            return false;
        else if(visited[course] == 0)
            visited[course] = 1;
        else
            return true;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        visited[course] = 2;
        return true;
    }
}