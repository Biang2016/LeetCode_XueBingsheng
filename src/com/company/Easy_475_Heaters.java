package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * Created by biang on 2017/5/7.
 */
public class Easy_475_Heaters {
    public static void main(String args[]) {
        int[] house = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(My_findRadius(house, heaters));
    }

    //20ms
    public static int My_findRadius(int[] houses, int[] heaters) {
        int lastHouse = 0;
        int maxDistance = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int j = 0; j < houses.length; j++)
            if (houses[j] < heaters[0]) {
                maxDistance = Math.max(maxDistance, heaters[0] - houses[j]);
                break;
            }
        for (int i = 1; i < heaters.length; i++) {
            for (int j = lastHouse; j < houses.length; j++)
                if (houses[j] <= heaters[i] && houses[j] >= heaters[i - 1])
                    maxDistance = Math.max(maxDistance, Math.min(Math.abs(houses[j] - heaters[i]), Math.abs(houses[j] - heaters[i - 1])));
                else if(houses[j] > heaters[i]){
                    lastHouse = j;
                    break;
                }
        }
        for (int j = houses.length - 1; j >= 0; j--) {
            if (houses[j] > heaters[heaters.length - 1]) {
                maxDistance = Math.max(maxDistance, houses[j] - heaters[heaters.length - 1]);
                break;
            }
        }
        return maxDistance;
    }

    //Cleaner,25ms
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                    && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }

        return res;
    }

    //30ms
    public static int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }
}
