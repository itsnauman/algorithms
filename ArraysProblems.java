package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Solutions to Array interview problems.
 */
public class ArraysProblems {
    /**
     * Given an unsorted array that may contain duplicates.
     * Also given a number k which is smaller than size of array.
     * Write a function that returns true if array contains duplicates within k distance.
     */
    private boolean duplicatesWithinKDistance(int[] a, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            int n = a[i];

            if (set.contains(n))
                return true;

            set.add(n);

            if (i >= k)
                set.remove(i - k);
        }

        return false;
    }

    /**
     * Given an array of elements check if elements in the array are consecutive or not.
     * Sum of geometric progression: (n)(n + 1) / 2
     * Time: O(n) Space: O(1)
     */
    private static boolean consecutiveIntegers(int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int n: a) {
            sum += n;

            if (n <= min)
                min = n;
            if (n >= max)
                max = n;
        }

        int sumMax = ((max) * (max + 1)) / 2;
        int sumMin = ((min - 1) * (min)) / 2;

        return (sumMax - sumMin) == sum;

    }

    private static void shiftArrayCircular(int[] a, int k) {
        k = k % a.length;

        while (k-- > 0) {
            int tmp = a[0];

            for (int i = 1; i < a.length; i++)
                a[i - 1] = a[i];

            a[a.length - 1] = tmp;
        }
    }
    /**
     * Given an ArrayList, write a function that segregates even and odd numbers.
     * The functions should put all even numbers first, and then odd numbers.
     * @param a
     * @return
     */
    private static void segregateEvenOdd(ArrayList<Integer> a) {
        int start = 0;
        int end = a.size() - 1;

        while (start < end) {
            if (start < end && a.get(start) % 2 == 0)
                start++;

            if (start < end && a.get(end) % 2 != 0)
                end--;

            int tmp = a.get(start);
            a.set(start, a.get(end));
            a.set(end, tmp);
        }
    }

    private static ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        Collections.sort(a);
        ArrayList<Integer> returnVal = new ArrayList<>();

        int duplicate = 0;
        int num = a.get(a.size() - 1);
        int expectedSum = ((num) * (num + 1)) / 2;
        int sum = a.get(0);

        for (int i = 1; i < a.size(); i++) {
            sum += a.get(i);
            if (a.get(i - 1).equals(a.get(i))) {
                duplicate = a.get(i - 1);
                sum -= duplicate;
            }
        }

        returnVal.add(duplicate);
        returnVal.add(expectedSum - sum);
        return returnVal;
    }

    public static int sumOf(ArrayList<Integer> a, int sum) {
        int start = 0;
        int end = a.size() - 1;

        while (start < end) {
            int checkSum = a.get(start) + a.get(end);
            if (sum == checkSum)
                return 1;
            else if (checkSum < sum)
                end--;
            else
                start++;
        }

        return -1;
    }

    /**
     * Given a sorted array, remove the duplicates in place such that each element can appear at most twice
     * @param a
     * @return New Length
     */
    public static List<Integer> removeDuplicates(ArrayList<Integer> a) {
        int k = 1;
        int count = 1;

        for (int i = 1; i < a.size(); i++) {
            if (a.get(i - 1).equals(a.get(i)) && count < 2) {
                a.set(k++, a.get(i));
                count++;
            } else if (!a.get(i - 1).equals(a.get(i))) {
                a.set(k++, a.get(i));
                count = 1;
            }
        }

        return a.subList(0, k);
    }

    /**
     * Given an array of integers, sort the array into a wave like array and return it,
     * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
     */
    public static ArrayList<Integer> waveSort(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<Integer> wave = new ArrayList<>();

        for (int i = 0; i < a.size() - 1; i += 2) {
            wave.add(a.get(i + 1));
            wave.add(a.get(i));
        }

        return wave;
    }

    public static int diffPossible(ArrayList<Integer> a, int k) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size() - 1; j++) {
                int dif = a.get(i) - a.get(j);
                int negDef = -dif;

                if (dif == k || negDef == k)
                    return 1;
            }
        }

        return 0;
    }

    public static List<Integer> removeElement(ArrayList<Integer> a, int b) {
        int k = 0;

        for (int i = 0; i < a.size(); i++) {
            a.set(k, a.get(i));

            if (a.get(k) != b)
                k++;
        }

        return a.subList(0, k);
    }
}
